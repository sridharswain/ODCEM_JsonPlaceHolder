package com.odcem.jsonplaceholderwithjwt.controller;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

import java.util.Date;

import com.odcem.jsonplaceholderwithjwt.constant.Constants;
import com.odcem.jsonplaceholderwithjwt.dto.CredentialDto;

import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.service.impl.TokenAccessServiceImpl;
import com.odcem.jsonplaceholderwithjwt.validator.TokenAccessValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class GetAccessController {

    @Autowired
    TokenAccessServiceImpl tokenAccessService;

    @PostMapping(value = "/token", consumes = {APPLICATION_JSON_VALUE}, produces = {APPLICATION_JSON_VALUE})
    public ResponseEntity<GenericDto<String>> getToken(@RequestBody CredentialDto login){

        GenericDto<String> jwtDto = tokenAccessService.getToken(login);

		return new ResponseEntity<>(jwtDto, HttpStatus.OK);
    }
}