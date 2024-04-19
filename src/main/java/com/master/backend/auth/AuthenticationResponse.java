package com.master.backend.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class AuthenticationResponse {
    private int id;
    private String userName;
    private String mail;
    @JsonProperty("access_token")
    private String accessToken;
}
