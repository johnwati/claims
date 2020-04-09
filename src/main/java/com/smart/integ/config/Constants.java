/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

/**
 *
 * @author John.Simiyu
 */
public class Constants {

    @Autowired
    private Environment env;

    @Value("${app.customer_id}")
    public String CUSTOMER_ID;
    @Value("${app.country_code}")
    public String COUNTRY_CODE;
    @Value("${app.client_id}")
    public String CLIENT_ID;
    @Value("${app.client_secrete}")
    public String CLIENT_SCRETE;
    @Value("${app.grant_type}")
    public String GRANT_TYPE;
    @Value("${app.auth_url}")
    public String AuthUrl;
    // = "https://data.smartapplicationsgroup.com/auth/integ-clients/oauth/token?client_id=RESOECLAIMS&client_secret=zDPxTn6V3fql3oh00xIKLbNgkj4&grant_type=client_credentials";
    public String Auth_link = this.AuthUrl + "?client_id=" + this.CLIENT_ID + "&client_secret=" + this.CLIENT_SCRETE + "&grant_type=" + this.GRANT_TYPE;
    @Value("${app.claim_url}")
    private String CLAIM_URL;

    private String CLAIM_LINK;

    public String getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public String getCOUNTRY_CODE() {
        return COUNTRY_CODE;
    }

    public String getCLIENT_ID() {
        return CLIENT_ID;
    }

    public String getCLIENT_SCRETE() {
        return CLIENT_SCRETE;
    }

    public String getGRANT_TYPE() {
        return GRANT_TYPE;
    }

    public String getAuthUrl() {
        return AuthUrl;
    }

    public String getAuth_link() {
        return Auth_link;
    }

    public String getCLAIM_URL() {
        return CLAIM_URL;
    }

    public String getCLAIM_LINK() {
        //  return this.CLAIM_URL + "?customerid=" + this.CUSTOMER_ID + "&countrycode=" + this.COUNTRY_CODE + "&isUpdate=false";
        return "https://data.smartapplicationsgroup.com/api/v2/integqa/claims/edi?customerid=RESOECLAIMS&countrycode=KE&isUpdate=false";
    }

}
