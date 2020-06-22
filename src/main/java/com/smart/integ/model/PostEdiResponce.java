
package com.smart.integ.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "userName",
    "id1",
    "id2",
    "id3",
    "other1",
    "other2",
    "other3",
    "headerParam",
    "userId",
    "param",
    "token",
    "errorCode",
    "successful",
    "statusCode",
    "status_msg",
    "statusCodeType",
    "statusCodeMsg",
    "objectCode",
    "updated_rows",
    "error_type",
    "id"
})
public class PostEdiResponce {

    @JsonProperty("userName")
    private Object userName;
    @JsonProperty("id1")
    private Object id1;
    @JsonProperty("id2")
    private Object id2;
    @JsonProperty("id3")
    private Object id3;
    @JsonProperty("other1")
    private Object other1;
    @JsonProperty("other2")
    private Object other2;
    @JsonProperty("other3")
    private Object other3;
    @JsonProperty("headerParam")
    private Boolean headerParam;
    @JsonProperty("userId")
    private Object userId;
    @JsonProperty("param")
    private Object param;
    @JsonProperty("token")
    private Object token;
    @JsonProperty("errorCode")
    private Integer errorCode;
    @JsonProperty("successful")
    private Boolean successful;
    @JsonProperty("statusCode")
    private String statusCode;
    @JsonProperty("status_msg")
    private String statusMsg;
    @JsonProperty("statusCodeType")
    private String statusCodeType;
    @JsonProperty("statusCodeMsg")
    private String statusCodeMsg;
    @JsonProperty("objectCode")
    private String objectCode;
    @JsonProperty("updated_rows")
    private Integer updatedRows;
    @JsonProperty("error_type")
    private String errorType;
    @JsonProperty("id")
    private String id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("userName")
    public Object getUserName() {
        return userName;
    }

    @JsonProperty("userName")
    public void setUserName(Object userName) {
        this.userName = userName;
    }

    @JsonProperty("id1")
    public Object getId1() {
        return id1;
    }

    @JsonProperty("id1")
    public void setId1(Object id1) {
        this.id1 = id1;
    }

    @JsonProperty("id2")
    public Object getId2() {
        return id2;
    }

    @JsonProperty("id2")
    public void setId2(Object id2) {
        this.id2 = id2;
    }

    @JsonProperty("id3")
    public Object getId3() {
        return id3;
    }

    @JsonProperty("id3")
    public void setId3(Object id3) {
        this.id3 = id3;
    }

    @JsonProperty("other1")
    public Object getOther1() {
        return other1;
    }

    @JsonProperty("other1")
    public void setOther1(Object other1) {
        this.other1 = other1;
    }

    @JsonProperty("other2")
    public Object getOther2() {
        return other2;
    }

    @JsonProperty("other2")
    public void setOther2(Object other2) {
        this.other2 = other2;
    }

    @JsonProperty("other3")
    public Object getOther3() {
        return other3;
    }

    @JsonProperty("other3")
    public void setOther3(Object other3) {
        this.other3 = other3;
    }

    @JsonProperty("headerParam")
    public Boolean getHeaderParam() {
        return headerParam;
    }

    @JsonProperty("headerParam")
    public void setHeaderParam(Boolean headerParam) {
        this.headerParam = headerParam;
    }

    @JsonProperty("userId")
    public Object getUserId() {
        return userId;
    }

    @JsonProperty("userId")
    public void setUserId(Object userId) {
        this.userId = userId;
    }

    @JsonProperty("param")
    public Object getParam() {
        return param;
    }

    @JsonProperty("param")
    public void setParam(Object param) {
        this.param = param;
    }

    @JsonProperty("token")
    public Object getToken() {
        return token;
    }

    @JsonProperty("token")
    public void setToken(Object token) {
        this.token = token;
    }

    @JsonProperty("errorCode")
    public Integer getErrorCode() {
        return errorCode;
    }

    @JsonProperty("errorCode")
    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    @JsonProperty("successful")
    public Boolean getSuccessful() {
        return successful;
    }

    @JsonProperty("successful")
    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    @JsonProperty("statusCode")
    public String getStatusCode() {
        return statusCode;
    }

    @JsonProperty("statusCode")
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @JsonProperty("status_msg")
    public String getStatusMsg() {
        return statusMsg;
    }

    @JsonProperty("status_msg")
    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    @JsonProperty("statusCodeType")
    public String getStatusCodeType() {
        return statusCodeType;
    }

    @JsonProperty("statusCodeType")
    public void setStatusCodeType(String statusCodeType) {
        this.statusCodeType = statusCodeType;
    }

    @JsonProperty("statusCodeMsg")
    public String getStatusCodeMsg() {
        return statusCodeMsg;
    }

    @JsonProperty("statusCodeMsg")
    public void setStatusCodeMsg(String statusCodeMsg) {
        this.statusCodeMsg = statusCodeMsg;
    }

    @JsonProperty("objectCode")
    public String getObjectCode() {
        return objectCode;
    }

    @JsonProperty("objectCode")
    public void setObjectCode(String objectCode) {
        this.objectCode = objectCode;
    }

    @JsonProperty("updated_rows")
    public Integer getUpdatedRows() {
        return updatedRows;
    }

    @JsonProperty("updated_rows")
    public void setUpdatedRows(Integer updatedRows) {
        this.updatedRows = updatedRows;
    }

    @JsonProperty("error_type")
    public String getErrorType() {
        return errorType;
    }

    @JsonProperty("error_type")
    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
