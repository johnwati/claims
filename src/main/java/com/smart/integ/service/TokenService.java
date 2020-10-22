/**
 * JAVADOC
 * details here
 * */
package com.smart.integ.service;

import com.smart.integ.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.smart.integ.interfaces.TokenInterface;
import com.smart.integ.model.AuthToken;
import java.util.logging.Level;

import java.util.logging.Logger;
import javax.accessibility.AccessibleAction;
import org.springframework.beans.factory.annotation.Value;

@Service("tokenservice")
public class TokenService implements TokenInterface {

    Logger log = Logger.getLogger(TokenService.class.getName());

    //http://appsdeveloperblog.com/reading-application-properties-spring-boot/
    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("plainRestTemplate")         //does not use ribbon
    private RestTemplate plainRestTemplate;

//    @Autowired
    Constants constants = new Constants();

    @Value("${app.auth.client_id}")
    private String CLIENT_ID;

    @Value("${app.auth.client_secrete}")
    private String CLIENT_SCRETE;

    @Value("${url.get.authToken}")
    private String authToken_url;

    @Value("${app.auth.grant_type}")
    private String grant_type;

    public String getToken() {
        String token_link = authToken_url + "client_id=" + CLIENT_ID + "&client_secret=" + CLIENT_SCRETE + "&grant_type=" + grant_type;

        log.log(Level.INFO, "====================PREPARING TO GET AUTH TOKEN FROM AUTHER SERVER USING THE LINK: ======================\n {0} \n", token_link);
        //Set the headers you need send
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        //NB: Endpoint will return 404 if you use GET instead of POST
        ResponseEntity<AuthToken> resp = plainRestTemplate.exchange(token_link, HttpMethod.POST, entity, AuthToken.class);
        log.info("resp token = " + resp.getBody().getAccess_token());
        return resp.getBody().getAccess_token();

    }

}
