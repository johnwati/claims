
package com.smart.integ.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "status_msg",
    "claim_count",
    "successful",
    "fetch_id_to",
    "has_more",
    "claims",
    "fetch_id_from"
})
public class ClaimData implements Serializable
{

    @JsonProperty("status_msg")
    private String statusMsg;
    @JsonProperty("claim_count")
    private Integer claimCount;
    @JsonProperty("successful")
    private Boolean successful;
    @JsonProperty("fetch_id_to")
    private Integer fetchIdTo;
    @JsonProperty("has_more")
    private Boolean hasMore;
    @JsonProperty("claims")
    private List<Claim> claims = null;
    @JsonProperty("fetch_id_from")
    private Integer fetchIdFrom;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5060357717701327483L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ClaimData() {
    }

    /**
     * 
     * @param fetchIdFrom
     * @param statusMsg
     * @param hasMore
     * @param claims
     * @param claimCount
     * @param fetchIdTo
     * @param successful
     */
    public ClaimData(String statusMsg, Integer claimCount, Boolean successful, Integer fetchIdTo, Boolean hasMore, List<Claim> claims, Integer fetchIdFrom) {
        super();
        this.statusMsg = statusMsg;
        this.claimCount = claimCount;
        this.successful = successful;
        this.fetchIdTo = fetchIdTo;
        this.hasMore = hasMore;
        this.claims = claims;
        this.fetchIdFrom = fetchIdFrom;
    }

    @JsonProperty("status_msg")
    public String getStatusMsg() {
        return statusMsg;
    }

    @JsonProperty("status_msg")
    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

    @JsonProperty("claim_count")
    public Integer getClaimCount() {
        return claimCount;
    }

    @JsonProperty("claim_count")
    public void setClaimCount(Integer claimCount) {
        this.claimCount = claimCount;
    }

    @JsonProperty("successful")
    public Boolean getSuccessful() {
        return successful;
    }

    @JsonProperty("successful")
    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

    @JsonProperty("fetch_id_to")
    public Integer getFetchIdTo() {
        return fetchIdTo;
    }

    @JsonProperty("fetch_id_to")
    public void setFetchIdTo(Integer fetchIdTo) {
        this.fetchIdTo = fetchIdTo;
    }

    @JsonProperty("has_more")
    public Boolean getHasMore() {
        return hasMore;
    }

    @JsonProperty("has_more")
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }

    @JsonProperty("claims")
    public List<Claim> getClaims() {
        return claims;
    }

    @JsonProperty("claims")
    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    @JsonProperty("fetch_id_from")
    public Integer getFetchIdFrom() {
        return fetchIdFrom;
    }

    @JsonProperty("fetch_id_from")
    public void setFetchIdFrom(Integer fetchIdFrom) {
        this.fetchIdFrom = fetchIdFrom;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("statusMsg", statusMsg).append("claimCount", claimCount).append("successful", successful).append("fetchIdTo", fetchIdTo).append("hasMore", hasMore).append("claims", claims).append("fetchIdFrom", fetchIdFrom).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(fetchIdFrom).append(statusMsg).append(hasMore).append(claims).append(claimCount).append(fetchIdTo).append(additionalProperties).append(successful).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClaimData) == false) {
            return false;
        }
        ClaimData rhs = ((ClaimData) other);
        return new EqualsBuilder().append(fetchIdFrom, rhs.fetchIdFrom).append(statusMsg, rhs.statusMsg).append(hasMore, rhs.hasMore).append(claims, rhs.claims).append(claimCount, rhs.claimCount).append(fetchIdTo, rhs.fetchIdTo).append(additionalProperties, rhs.additionalProperties).append(successful, rhs.successful).isEquals();
    }

}
