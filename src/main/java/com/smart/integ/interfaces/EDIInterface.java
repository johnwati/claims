/**
* JAVADOC
* details here
**/
package com.smart.integ.interfaces;


import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.math.BigDecimal;
import javax.sql.DataSource;

public interface EDIInterface {

	String fetchEDIClaimsBasic(Integer clientid, String smartProviderCode, Integer offset);
	JsonArray fetchEDIClaimsJson(Integer clientid, String smartProviderCode, Integer offset);
	JsonObject fetchEDIClaimsObjectJson(Integer clientid, String smartProviderCode, Integer offset);

	//void testCache(Integer clientid, String smartProviderCode, Integer offset);
	//Integer findPolicyId(Integer clientid, Map<String,String> memberMap, Map<String,String> benefitMap);

	}