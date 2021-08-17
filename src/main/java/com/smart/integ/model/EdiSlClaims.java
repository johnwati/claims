package com.smart.integ.model;

/**
 *
 * @author John.Simiyu
 */
public class EdiSlClaims {

    private String INSERT_TIME;
    private String INVOICE_NUMBER;
    private String PAYER_NAME;
    private String LOCATION_NAME;
    private String SCHEME_NAME;

    public EdiSlClaims() {
    }

    public EdiSlClaims(String INSERT_TIME, String INVOICE_NUMBER, String PAYER_NAME, String LOCATION_NAME) {
        this.INSERT_TIME = INSERT_TIME;
        this.INVOICE_NUMBER = INVOICE_NUMBER;
        this.PAYER_NAME = PAYER_NAME;
        this.LOCATION_NAME = LOCATION_NAME;
    }

    public String getINSERT_TIME() {
        return INSERT_TIME;
    }

    public void setINSERT_TIME(String INSERT_TIME) {
        this.INSERT_TIME = INSERT_TIME;
    }

    public String getINVOICE_NUMBER() {
        return INVOICE_NUMBER;
    }

    public void setINVOICE_NUMBER(String INVOICE_NUMBER) {
        this.INVOICE_NUMBER = INVOICE_NUMBER;
    }

    public String getPAYER_NAME() {
        return PAYER_NAME;
    }

    public void setPAYER_NAME(String PAYER_NAME) {
        this.PAYER_NAME = PAYER_NAME;
    }

    public String getLOCATION_NAME() {
        return LOCATION_NAME;
    }

    public void setLOCATION_NAME(String LOCATION_NAME) {
        this.LOCATION_NAME = LOCATION_NAME;
    }

    public String getSCHEME_NAME() {
        return SCHEME_NAME;
    }

    public void setSCHEME_NAME(String SCHEME_NAME) {
        this.SCHEME_NAME = SCHEME_NAME;
    }
    
    
    

}

