package com.smart.integ.util;

import java.util.List;

public class SyncResponse_add {
    private List<String> lstColTypes;
    private List<Object> lstVals;
    private String q;

    public SyncResponse_add() {}

    public List<String> getLstColTypes() {
        return lstColTypes;
    }

    public void setLstColTypes(List<String> lstColTypes) {
        this.lstColTypes = lstColTypes;
    }

    public List<Object> getLstVals() {
        return lstVals;
    }

    public void setLstVals(List<Object> lstVals) {
        this.lstVals = lstVals;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
