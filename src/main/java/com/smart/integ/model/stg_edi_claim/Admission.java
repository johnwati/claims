
package com.smart.integ.model.stg_edi_claim;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
    "admit_date",
    "discharge_date",
    "discharge_summary"
})
public class Admission implements Serializable
{

    @JsonProperty("admit_date")
    private String admitDate;
    @JsonProperty("discharge_date")
    private String dischargeDate;
    @JsonProperty("discharge_summary")
    private String dischargeSummary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 548705182799799626L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Admission() {
    }

    /**
     * 
     * @param dischargeDate
     * @param dischargeSummary
     * @param admitDate
     */
    public Admission(String admitDate, String dischargeDate, String dischargeSummary) {
        super();
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.dischargeSummary = dischargeSummary;
    }

    @JsonProperty("admit_date")
    public String getAdmitDate() {
        return admitDate;
    }

    @JsonProperty("admit_date")
    public void setAdmitDate(String admitDate) {
        this.admitDate = admitDate;
    }

    @JsonProperty("discharge_date")
    public String getDischargeDate() {
        return dischargeDate;
    }

    @JsonProperty("discharge_date")
    public void setDischargeDate(String dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    @JsonProperty("discharge_summary")
    public String getDischargeSummary() {
        return dischargeSummary;
    }

    @JsonProperty("discharge_summary")
    public void setDischargeSummary(String dischargeSummary) {
        this.dischargeSummary = dischargeSummary;
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
        return new ToStringBuilder(this).append("admitDate", admitDate).append("dischargeDate", dischargeDate).append("dischargeSummary", dischargeSummary).append("additionalProperties", additionalProperties).toString();
    }

}
