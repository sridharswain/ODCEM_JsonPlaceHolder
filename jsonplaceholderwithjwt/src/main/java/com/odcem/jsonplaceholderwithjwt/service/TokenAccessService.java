package com.odcem.jsonplaceholderwithjwt.service;

import com.odcem.jsonplaceholderwithjwt.dto.CredentialDto;
import com.odcem.jsonplaceholderwithjwt.dto.GenericDto;

public interface TokenAccessService {
    public GenericDto<String> getToken(CredentialDto credentialDto);
}
