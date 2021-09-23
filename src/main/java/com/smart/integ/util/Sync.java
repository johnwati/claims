package com.smart.integ.util;
 
import com.smart.integ.util.Common;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.Date;
import java.sql.*;
import java.util.*;

public class Sync {

    public Sync() {
    }

    public String syncModel_add(Object initClass, Class classparam, String table) throws Exception {
//        System.out.println("fetch 1");
        List<String> lstcols = new ArrayList();
//        System.out.println("fetch 4 " + lstcols);
        //System.out.println(lstcols);
        //String polid="";
        //Object initClass=myclass;
        BeanInfo info = Introspector.getBeanInfo(classparam);
        //System.out.println("Calling setters");
        StringBuilder vals = new StringBuilder();
        for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
            if (pd.getReadMethod() != null) {
//                System.out.println("\tGetting " + pd.getName() + ": "
//                        + pd.getReadMethod().getReturnType());
                if (pd.getReadMethod().invoke(initClass) != null
                        && !pd.getReadMethod().toString().equals("java.lang.Class")
                        && !pd.getName().equalsIgnoreCase("class")) {
                    lstcols.add(pd.getName());
                    if (pd.getReadMethod().getReturnType().toString().endsWith("Date")) {
                        vals.append(",to_date('").append(pd.getReadMethod().invoke(initClass)).append("','yyyy-mm-dd')");
//                        System.out.println("\tSetting " + pd.getName() + ": " + pd.getReadMethod().invoke(initClass));
                    } else {
                        vals.append(",'").append(pd.getReadMethod().invoke(initClass)).append("'");
//                        System.out.println("\tSetting " + pd.getName() + ": " + pd.getReadMethod().invoke(initClass));
                    }
                }
            }
        }
        String insert = "";
        if (!vals.toString().isEmpty()) {
            insert = "insert into " + table + " (" + Common.lst2string_cols(lstcols) + ") "
                    + "values(" + vals.substring(1) + ")";
            //System.out.println(insert);
        }
        return insert;
    }

}
