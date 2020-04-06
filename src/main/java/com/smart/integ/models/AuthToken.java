package com.smart.integ.models;

public class AuthToken {

    private String access_token;
    private String token_type;
    private String expires_in;

    public AuthToken(){

    }

    
    

    /**
     * @return String return the access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     * @param access_token the access_token to set
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     * @return String return the token_type
     */
    public String getToken_type() {
        return token_type;
    }

    /**
     * @param token_type the token_type to set
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    /**
     * @return String return the expires_in
     */
    public String getExpires_in() {
        return expires_in;
    }

    /**
     * @param expires_in the expires_in to set
     */
    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }

}