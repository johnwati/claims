package com.smart.integ.util;

import com.smart.integ.infrastructure.exception.APIException;

import java.sql.*;
import java.util.List;

public class DbUtil {

    public static int runUpdate(Connection con, String update) throws Exception {
        try (Statement st = con.createStatement()) {
            return st.executeUpdate(update);
        }
    }

    public static Object runInsert(Connection con, String q, String idCol, List<String> lstColTypes, List<Object> lstVals) {
        try {
            return runInsert_object(con, q, idCol, lstColTypes, lstVals);
        } catch (Exception e) {
            throw APIException.internalError(e.getMessage(), "");
        }
    }

    public static Object runInsert_object(Connection con, String q, String idCol, List<String> lstColTypes, List<Object> lstVals) {
        try {
            PreparedStatement pst2 = con.prepareStatement(q, new String[]{idCol});
            int i = 0;
            for (String colType : lstColTypes) {
                if (colType.equals("class java.sql.Date")) {
                    pst2.setDate(i + 1, (Date) lstVals.get(i));
                } else if (colType.equals("class java.util.Date")) {
                    pst2.setTimestamp(i + 1, new Timestamp(((java.util.Date) lstVals.get(i)).getTime()));
                } else if (colType.equals("class java.time.LocalDateTime")) {//java.time.LocalDateTime
                    Timestamp tm = Timestamp.valueOf((java.time.LocalDateTime) lstVals.get(i));
                    pst2.setTimestamp(i + 1, tm);
                } else {
                    pst2.setString(i + 1, lstVals.get(i).toString());
                }
                i++;
            }
            pst2.execute();
            try (ResultSet rs = pst2.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getObject(1);
                } else {
                    return null;
                }
            }
        } catch (Exception e) {
            throw APIException.internalError(e.getMessage(), "");
        }
    }

    public static Integer runUpdateBind(Connection con, String q, String idCol, Object IdValue, List<String> lstColTypes, List<Object> lstVals, String andClause) {
        try {
            q = q + " where " + idCol + " = ?";
            if (!andClause.isEmpty())
                q = q + " and (" + andClause + ")";
            lstColTypes.add("");
            lstVals.add(IdValue);
            PreparedStatement pst2 = con.prepareStatement(q);
            int i = 0;
            for (String colType : lstColTypes) {
                if (colType.equals("class java.sql.Date")) {
                    pst2.setDate(i + 1, (Date) lstVals.get(i));
                } else if (colType.equals("class java.util.Date")) {
                    pst2.setTimestamp(i + 1, new Timestamp(((java.util.Date) lstVals.get(i)).getTime()));
                } else if (colType.equals("class java.time.LocalDateTime")) {//java.time.LocalDateTime
                    Timestamp tm = Timestamp.valueOf((java.time.LocalDateTime) lstVals.get(i));
                    pst2.setTimestamp(i + 1, tm);
                } else {
                    pst2.setObject(i + 1, lstVals.get(i));
                }
                i++;
            }
            return pst2.executeUpdate();
        } catch (Exception e) {
            throw APIException.internalError(e.getMessage(), "");
        }
    }
}
