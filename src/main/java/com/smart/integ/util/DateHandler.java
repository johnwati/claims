/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.util;

import com.smart.integ.service.EDIService;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 *
 * @author John.Simiyu
 */
public class DateHandler {

    Date date = new Date();
    Logger log = Logger.getLogger(EDIService.class.getName());

    public String  dateFormatter(String inputDate) throws ParseException {

//        if (isValidFormat("yyyy-MM-dd HH:mm:ss", inputDate)) {
        if (isThisDateValid(inputDate, "yyyy-MM-dd HH:mm:ss")) {
            return dateConvserter(inputDate);
        } else {
            return dateCoversion2(inputDate);
        }
    }

    public String dateConvserter(String date_to_format) throws ParseException {

        if (!StringUtils.isEmpty(date_to_format)) {
//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        Date date = dateFormat.parse("2017-04-26T20:55:00.000Z");//You will get date object relative to server/client timezone wherever it is parsed
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//        String dateStr = formatter.format(date);
//        log.info("New Date:  " + dateStr);
//      2019-07-25T19:04:14
//        19-07-25T19:04:14
//      2019-07-25T19:04:14
//        19-07-25T19:04:14
//      2019-07-25T19:04:14.000+03:00
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = dateFormat.parse("2019-07-25 19:04:14");
            Date date = dateFormat.parse(date_to_format);
            DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
            String dateStr = formatter.format(date);
//            log.info("New Date2:  " + dateStr);
            return dateStr;
        } else {
            return date_to_format;
        }

    }

    public String dateCoversion2(String DateInputString) {
        SimpleDateFormat DateFor = new SimpleDateFormat("MMM dd yyyy HH:mma");
         if (DateInputString == null) {
            return DateInputString;
        }
        try {
            //        date = DateFor.parse("Jun 15 2020 11:24AM");
            date = DateFor.parse(DateInputString);
            String OutPutDate = DateFor.format(date);
//            System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z :" + OutPutDate);

            SimpleDateFormat DateOutputFormat = new SimpleDateFormat("YYYY-MM-dd");
            String DateOuputString = DateOutputFormat.format(date);
//            System.out.println("Date Format with E, dd MMM yyyy HH:mm:ss z :" + DateOuputString);
            return DateOuputString;
        } catch (ParseException ex) {
            Logger.getLogger(DateHandler.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public static boolean isValidFormat(String format, String value) {
        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            date = sdf.parse(value);
            if (!value.equals(sdf.format(date))) {
                date = null;
            }
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date != null;
    }

    public boolean isThisDateValid(String dateToValidate, String dateFromat) {

        if (dateToValidate == null) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
        sdf.setLenient(false);

        try {

            //if not valid, it will throw ParseException
            Date date = sdf.parse(dateToValidate);
//            System.out.println(date);

        } catch (ParseException e) {

//            e.printStackTrace();
            return false;
        }

        return true;
    }

}
