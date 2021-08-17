package com.smart.integ.model;

public class UnsubmitedInvoicesModel {
  private String claim_datetime;
  private String invoice_number;
  private String payer_name;
  private String clinic_name;
  private long no_of_delayed_days;
  private String edi_delivery_status;
  private String edi_delivery_datetime;
  private String scheme_name;

    public UnsubmitedInvoicesModel() {
    }

  
    public UnsubmitedInvoicesModel(String claim_datetime, String invoice_number, String payer_name, String clinic_name, long no_of_delayed_days, String edi_delivery_status, String edi_delivery_datetime) {
        this.claim_datetime = claim_datetime;
        this.invoice_number = invoice_number;
        this.payer_name = payer_name;
        this.clinic_name = clinic_name;
        this.no_of_delayed_days = no_of_delayed_days;
        this.edi_delivery_status = edi_delivery_status;
        this.edi_delivery_datetime = edi_delivery_datetime;
    }

  
  /**
   * @return String return the claim_datetime
   */
  public String getClaim_datetime() {
    return claim_datetime;
  } 
  /**
   * @param claim_datetime the claim_datetime to set
   */
  public void setClaim_datetime(String claim_datetime) {
    this.claim_datetime = claim_datetime;
  }

  /**
   * @return String return the invoice_number
   */
  public String getInvoice_number() {
    return invoice_number;
  }

  /**
   * @param invoice_number the invoice_number to set
   */
  public void setInvoice_number(String invoice_number) {
    this.invoice_number = invoice_number;
  }

  /**
   * @return String return the payer_name
   */
  public String getPayer_name() {
    return payer_name;
  }

  /**
   * @param payer_name the payer_name to set
   */
  public void setPayer_name(String payer_name) {
    this.payer_name = payer_name;
  }

  /**
   * @return String return the clinic_name
   */
  public String getClinic_name() {
    return clinic_name;
  }

  /**
   * @param clinic_name the clinic_name to set
   */
  public void setClinic_name(String clinic_name) {
    this.clinic_name = clinic_name;
  }

  /**
   * @return String return the no_of_delayed_days
   */
  public long getNo_of_delayed_days() {
    return no_of_delayed_days;
  }

  /**
   * @param no_of_delayed_days the no_of_delayed_days to set
   */
  public void setNo_of_delayed_days(long no_of_delayed_days) {
    this.no_of_delayed_days = no_of_delayed_days;
  }

  /**
   * @return String return the edi_delivery_status
   */
  public String getEdi_delivery_status() {
    return edi_delivery_status;
  }

  /**
   * @param edi_delivery_status the edi_delivery_status to set
   */
  public void setEdi_delivery_status(String edi_delivery_status) {
    this.edi_delivery_status = edi_delivery_status;
  }

  /**
   * @return String return the edi_delivery_datetime
   */
  public String getEdi_delivery_datetime() {
    return edi_delivery_datetime;
  }

  /**
   * @param edi_delivery_datetime the edi_delivery_datetime to set
   */
  public void setEdi_delivery_datetime(String edi_delivery_datetime) {
    this.edi_delivery_datetime = edi_delivery_datetime;
  }

    public String getScheme_name() {
        return scheme_name;
    }

    public void setScheme_name(String scheme_name) {
        this.scheme_name = scheme_name;
    }

  
  
    @Override
    public String toString() {
        return "UnsubmitedInvoicesModel{" + "claim_datetime=" + claim_datetime + ", invoice_number=" + invoice_number + ", payer_name=" + payer_name + ", clinic_name=" + clinic_name + ", no_of_delayed_days=" + no_of_delayed_days + ", edi_delivery_status=" + edi_delivery_status + ", edi_delivery_datetime=" + edi_delivery_datetime + '}';
    }
  
  
}







