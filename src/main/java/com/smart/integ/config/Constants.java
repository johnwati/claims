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
    private String CUSTOMER_ID;
    @Value("${app.country_code}")
    private String COUNTRY_CODE;
    @Value("${app.client_id:7a0ab650-f605-458c-b2bc-e8143140c122}")
    private String CLIENT_ID;
    @Value("${app.client_secrete:jCluqZsyGLaOzjpj_r3Cg89gyN8}")
    private String CLIENT_SCRETE;
    @Value("${app.grant_type}")
    private String GRANT_TYPE;
    @Value("${app.auth_url}")
    private String AuthUrl;
    // = "https://data.smartapplicationsgroup.com/auth/integ-clients/oauth/token?client_id=RESOECLAIMS&client_secret=zDPxTn6V3fql3oh00xIKLbNgkj4&grant_type=client_credentials";
    private String Auth_link = this.AuthUrl + "?client_id=" + this.CLIENT_ID + "&client_secret=" + this.CLIENT_SCRETE + "&grant_type=" + this.GRANT_TYPE;
    @Value("${app.claim_url}")
    private String CLAIM_URL;
    
//    String clientId, String clientSecret
    @Value("${url.post.claim.edi:https://data.smartapplicationsgroup.com/api/v2/provider/integration?country_code=KE&integ_app_code=AAROWT6HFYUR7R3WGIYI6&prov_code=SKSP_301}")
    private String PostClaimToEdi_url;

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

    public String getPostClaimToEdi_url() {
        return PostClaimToEdi_url;
    }

    public void setPostClaimToEdi_url(String PostClaimToEdi_url) {
        this.PostClaimToEdi_url = PostClaimToEdi_url;
    }
    
    

}
