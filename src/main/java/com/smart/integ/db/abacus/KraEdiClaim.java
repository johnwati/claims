package com.smart.integ.db.abacus;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.lang.Integer; 
import java.lang.String; 


@Entity
@Table(name = "edi_claims_inv")
public class KraEdiClaim implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @Column(name = "POLICY_NUMBER")
    private String POLICY_NUMBER;

    @Column(name = "PROVIDER_CODE")
    private String PROVIDER_CODE;

    @Column(name = "MEMBERSHIP_NUMBER")
    private String MEMBERSHIP_NUMBER;

    @Column(name = "MEMBER_NAME")
    private String MEMBER_NAME;

    @Column(name = "CARD_SERIAL")
    private String CARD_SERIAL;

    @Column(name = "TRANSACTION_DATE")
    private String TRANSACTION_DATE;

    @Column(name = "SERVICE_DESCRIPTION")
    private String SERVICE_DESCRIPTION;

    @Column(name = "BENEFIT_CODE")
    private Integer BENEFIT_CODE;

    @Column(name = "AMOUNT")
    private String AMOUNT;

    @Column(name = "DATE_RECEIVED")
    private String DATE_RECEIVED;

    @Column(name = "PROVIDER_CLAIM_ID")
    private Integer PROVIDER_CLAIM_ID;

    @Column(name = "SMART_INVOICE_NR")
    private Integer SMART_INVOICE_NR;

    @Column(name = "ADMIT_ID")
    private String ADMIT_ID;

    @Column(name = "CLN_UNIQUE_MEM_NUMBER")
    private String CLN_UNIQUE_MEM_NUMBER;

    @Column(name = "ERROR_DESCRIPTION")
    private String ERROR_DESCRIPTION;

    @Column(name = "CLN_BEN_CLAUSE_CODE")
    private String CLN_BEN_CLAUSE_CODE;

    @Column(name = "INSURER_ID")
    private Integer INSURER_ID;

    @Column(name = "CLAIM_ID")
    private Integer CLAIM_ID;

    @Column(name = "INSERT_DATE")
    private String INSERT_DATE;

    @Column(name = "STAFF_NUMBER")
    private String STAFF_NUMBER;

    @Column(name = "COUNTRY_CODE")
    private String COUNTRY_CODE;

    @Column(name = "LOG_TIME")
    private String LOG_TIME;

    @Column(name = "CURRENCY_CODE")
    private String CURRENCY_CODE;

    @Column(name = "CURRENCY_CONV_RATE")
    private String CURRENCY_CONV_RATE;

    @Column(name = "IS_ROAMING")
    private String IS_ROAMING;

    @Column(name = "ROAMING_AMOUNT")
    private String ROAMING_AMOUNT;

    @Column(name = "ROAMING_COUNTRY")
    private String ROAMING_COUNTRY;

    @Column(name = "DIAGNOSIS_CODE")
    private String DIAGNOSIS_CODE;

    @Column(name = "DIAGNOSIS_DESCRIPTION")
    private String DIAGNOSIS_DESCRIPTION;

    @Column(name = "POLICY_CURRENCY_CODE")
    private String POLICY_CURRENCY_CODE;

    @Column(name = "PICKED_DATE")
    private String PICKED_DATE;

	public void setPOLICY_NUMBER(String POLICY_NUMBER) {this.POLICY_NUMBER = POLICY_NUMBER;}
	public String getPOLICY_NUMBER() {return POLICY_NUMBER;}
	public void setPROVIDER_CODE(String PROVIDER_CODE) {this.PROVIDER_CODE = PROVIDER_CODE;}
	public String getPROVIDER_CODE() {return PROVIDER_CODE;}
	public void setMEMBERSHIP_NUMBER(String MEMBERSHIP_NUMBER) {this.MEMBERSHIP_NUMBER = MEMBERSHIP_NUMBER;}
	public String getMEMBERSHIP_NUMBER() {return MEMBERSHIP_NUMBER;}
	public void setMEMBER_NAME(String MEMBER_NAME) {this.MEMBER_NAME = MEMBER_NAME;}
	public String getMEMBER_NAME() {return MEMBER_NAME;}
	public void setCARD_SERIAL(String CARD_SERIAL) {this.CARD_SERIAL = CARD_SERIAL;}
	public String getCARD_SERIAL() {return CARD_SERIAL;}
	public void setTRANSACTION_DATE(String TRANSACTION_DATE) {this.TRANSACTION_DATE = TRANSACTION_DATE;}
	public String getTRANSACTION_DATE() {return TRANSACTION_DATE;}
	public void setSERVICE_DESCRIPTION(String SERVICE_DESCRIPTION) {this.SERVICE_DESCRIPTION = SERVICE_DESCRIPTION;}
	public String getSERVICE_DESCRIPTION() {return SERVICE_DESCRIPTION;}
	public void setBENEFIT_CODE(Integer BENEFIT_CODE) {this.BENEFIT_CODE = BENEFIT_CODE;}
	public Integer getBENEFIT_CODE() {return BENEFIT_CODE;}
	public void setAMOUNT(String AMOUNT) {this.AMOUNT = AMOUNT;}
	public String getAMOUNT() {return AMOUNT;}
	public void setDATE_RECEIVED(String DATE_RECEIVED) {this.DATE_RECEIVED = DATE_RECEIVED;}
	public String getDATE_RECEIVED() {return DATE_RECEIVED;}
	public void setPROVIDER_CLAIM_ID(Integer PROVIDER_CLAIM_ID) {this.PROVIDER_CLAIM_ID = PROVIDER_CLAIM_ID;}
	public Integer getPROVIDER_CLAIM_ID() {return PROVIDER_CLAIM_ID;}
	public void setSMART_INVOICE_NR(Integer SMART_INVOICE_NR) {this.SMART_INVOICE_NR = SMART_INVOICE_NR;}
	public Integer getSMART_INVOICE_NR() {return SMART_INVOICE_NR;}
	public void setADMIT_ID(String ADMIT_ID) {this.ADMIT_ID = ADMIT_ID;}
	public String getADMIT_ID() {return ADMIT_ID;}
	public void setCLN_UNIQUE_MEM_NUMBER(String CLN_UNIQUE_MEM_NUMBER) {this.CLN_UNIQUE_MEM_NUMBER = CLN_UNIQUE_MEM_NUMBER;}
	public String getCLN_UNIQUE_MEM_NUMBER() {return CLN_UNIQUE_MEM_NUMBER;}
	public void setERROR_DESCRIPTION(String ERROR_DESCRIPTION) {this.ERROR_DESCRIPTION = ERROR_DESCRIPTION;}
	public String getERROR_DESCRIPTION() {return ERROR_DESCRIPTION;}
	public void setCLN_BEN_CLAUSE_CODE(String CLN_BEN_CLAUSE_CODE) {this.CLN_BEN_CLAUSE_CODE = CLN_BEN_CLAUSE_CODE;}
	public String getCLN_BEN_CLAUSE_CODE() {return CLN_BEN_CLAUSE_CODE;}
	public void setINSURER_ID(Integer INSURER_ID) {this.INSURER_ID = INSURER_ID;}
	public Integer getINSURER_ID() {return INSURER_ID;}
	public void setCLAIM_ID(Integer CLAIM_ID) {this.CLAIM_ID = CLAIM_ID;}
	public Integer getCLAIM_ID() {return CLAIM_ID;}
	public void setINSERT_DATE(String INSERT_DATE) {this.INSERT_DATE = INSERT_DATE;}
	public String getINSERT_DATE() {return INSERT_DATE;}
	public void setSTAFF_NUMBER(String STAFF_NUMBER) {this.STAFF_NUMBER = STAFF_NUMBER;}
	public String getSTAFF_NUMBER() {return STAFF_NUMBER;}
	public void setCOUNTRY_CODE(String COUNTRY_CODE) {this.COUNTRY_CODE = COUNTRY_CODE;}
	public String getCOUNTRY_CODE() {return COUNTRY_CODE;}
	public void setLOG_TIME(String LOG_TIME) {this.LOG_TIME = LOG_TIME;}
	public String getLOG_TIME() {return LOG_TIME;}
	public void setCURRENCY_CODE(String CURRENCY_CODE) {this.CURRENCY_CODE = CURRENCY_CODE;}
	public String getCURRENCY_CODE() {return CURRENCY_CODE;}
	public void setCURRENCY_CONV_RATE(String CURRENCY_CONV_RATE) {this.CURRENCY_CONV_RATE = CURRENCY_CONV_RATE;}
	public String getCURRENCY_CONV_RATE() {return CURRENCY_CONV_RATE;}
	public void setIS_ROAMING(String IS_ROAMING) {this.IS_ROAMING = IS_ROAMING;}
	public String getIS_ROAMING() {return IS_ROAMING;}
	public void setROAMING_AMOUNT(String ROAMING_AMOUNT) {this.ROAMING_AMOUNT = ROAMING_AMOUNT;}
	public String getROAMING_AMOUNT() {return ROAMING_AMOUNT;}
	public void setROAMING_COUNTRY(String ROAMING_COUNTRY) {this.ROAMING_COUNTRY = ROAMING_COUNTRY;}
	public String getROAMING_COUNTRY() {return ROAMING_COUNTRY;}
	public void setDIAGNOSIS_CODE(String DIAGNOSIS_CODE) {this.DIAGNOSIS_CODE = DIAGNOSIS_CODE;}
	public String getDIAGNOSIS_CODE() {return DIAGNOSIS_CODE;}
	public void setDIAGNOSIS_DESCRIPTION(String DIAGNOSIS_DESCRIPTION) {this.DIAGNOSIS_DESCRIPTION = DIAGNOSIS_DESCRIPTION;}
	public String getDIAGNOSIS_DESCRIPTION() {return DIAGNOSIS_DESCRIPTION;}
	public void setPOLICY_CURRENCY_CODE(String POLICY_CURRENCY_CODE) {this.POLICY_CURRENCY_CODE = POLICY_CURRENCY_CODE;}
	public String getPOLICY_CURRENCY_CODE() {return POLICY_CURRENCY_CODE;}
	public void setPICKED_DATE(String PICKED_DATE) {this.PICKED_DATE = PICKED_DATE;}
	public String getPICKED_DATE() {return PICKED_DATE;}

	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
}