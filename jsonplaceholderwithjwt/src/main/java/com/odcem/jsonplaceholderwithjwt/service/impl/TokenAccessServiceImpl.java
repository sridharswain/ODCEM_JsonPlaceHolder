package com.odcem.jsonplaceholderwithjwt.service.impl;

import com.odcem.jsonplaceholderwithjwt.constant.Constants;
import com.odcem.jsonplaceholderwithjwt.dto.CredentialDto;
import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;
import com.odcem.jsonplaceholderwithjwt.service.TokenAccessService;
import com.odcem.jsonplaceholderwithjwt.validator.TokenAccessValidator;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service
public class TokenAccessServiceImpl implements TokenAccessService {

    @Override
    public GenericDto<String> getToken(CredentialDto credentialDto) {
        TokenAccessValidator tokenAccessValidator = new TokenAccessValidator(credentialDto);
        tokenAccessValidator.validate();

        String email = credentialDto.getEmail();
        String password = credentialDto.getPassword();

        GenericDto<String> responseDto = new GenericDto<>();

        if (email == null || password == null) {
            responseDto.setObject("Credentials not available.");
        }

        if(!"sridharswain25@gmail.com".equals(email) || !"Gravity".equals(password)){
            responseDto.setObject("Bad Credentials");
        }

        String jwtToken = Jwts.builder().setSubject(email).claim("roles", "user").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, Constants.SECRET_KEY).compact();

        responseDto.setObject(jwtToken);

        return responseDto;
    }
}
