package com.mitocode.exception;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = OauthExceptionSerializer.class)
public class OauthException extends OAuth2Exception {
    public OauthException(String msg) {
        super(msg);
    }
}
