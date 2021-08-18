/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finaccess.groboxcooperative.infrastructure.lang;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 *
 * @author Kelsas
 */
public class SystemUtils {

    public static String formatCurrency(BigDecimal amount) {
        //determine the current syste
        //
        return NumberFormat.getCurrencyInstance(new Locale("en", "KE")).format(amount);
    }
}
