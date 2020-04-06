/**
* JAVADOC
* details here
**/
package com.smart.integ.interfaces;


import org.json.simple.JsonArray;
import org.json.simple.JsonObject;

public interface EDIInterface {
	String fetchEDIClaimsBasic(Integer clientid, String smartProviderCode, Integer offset);
	JsonArray fetchEDIClaimsJson(Integer clientid, String smartProviderCode, Integer offset);
	JsonObject fetchEDIClaimsObjectJson(Integer clientid, String smartProviderCode, Integer offset);
	}