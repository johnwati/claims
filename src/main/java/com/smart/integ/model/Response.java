package com.smart.integ.model;

public class Response {

    private String id;
    private boolean successful;
    private String status_msg;
    
    private int errorCode;
    private String error_type;

    private String statusCode;
    private String statusCodeType;
    private String statusCodeMsg;



    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return boolean return the successful
     */
    public boolean isSuccessful() {
        return successful;
    }

    /**
     * @param successful the successful to set
     */
    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    /**
     * @return String return the status_msg
     */
    public String getStatus_msg() {
        return status_msg;
    }

    /**
     * @param status_msg the status_msg to set
     */
    public void setStatus_msg(String status_msg) {
        this.status_msg = status_msg;
    }

    /**
     * @return int return the errorCode
     */
    public int getErrorCode() {
        return errorCode;
    }

    /**
     * @param errorCode the errorCode to set
     */
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    /**
     * @return String return the error_type
     */
    public String getError_type() {
        return error_type;
    }

    /**
     * @param error_type the error_type to set
     */
    public void setError_type(String error_type) {
        this.error_type = error_type;
    }

    /**
     * @return String return the statusCode
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode the statusCode to set
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return String return the statusCodeType
     */
    public String getStatusCodeType() {
        return statusCodeType;
    }

    /**
     * @param statusCodeType the statusCodeType to set
     */
    public void setStatusCodeType(String statusCodeType) {
        this.statusCodeType = statusCodeType;
    }

    /**
     * @return String return the statusCodeMsg
     */
    public String getStatusCodeMsg() {
        return statusCodeMsg;
    }

    /**
     * @param statusCodeMsg the statusCodeMsg to set
     */
    public void setStatusCodeMsg(String statusCodeMsg) {
        this.statusCodeMsg = statusCodeMsg;
    }

}