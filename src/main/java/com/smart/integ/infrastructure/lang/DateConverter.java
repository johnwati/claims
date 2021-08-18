package com.finaccess.groboxcooperative.infrastructure.lang;
import org.springframework.util.Assert;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public interface DateConverter {

//    @Nonnull
    static Long toEpochMillis(final LocalDateTime localDateTime) {
        Assert.notNull(localDateTime, "LocalDateTime must be given.");
        return localDateTime.toInstant(ZoneOffset.UTC).toEpochMilli();
    }

//    @Nonnull
    static Long toEpochDay(final LocalDate localDate) {
        Assert.notNull(localDate, "LocalDate must be given.");
        return localDate.toEpochDay();
    }

//    @Nonnull
    static LocalDateTime fromEpochMillis(final Long epochMillis) {
        Assert.notNull(epochMillis, "Epoch milliseconds must be given.");
        return LocalDateTime.from(Instant.ofEpochMilli(epochMillis).atZone(ZoneOffset.UTC));
    }

//    @Nonnull
    static String toIsoString(final Date date) {
        return toIsoString(LocalDateTime.ofInstant(date.toInstant(), ZoneId.of("UTC")));
    }

//    @Nonnull
    static String toIsoString(final LocalDateTime localDateTime) {
        Assert.notNull(localDateTime, "LocalDateTime must be given.");
        return localDateTime.format(DateTimeFormatter.ISO_DATE_TIME) + "Z";
    }

//    @Nonnull
    static LocalDateTime fromIsoString(final String isoDateTimeString) {
        Assert.notNull(isoDateTimeString, "ISO date time must be given.");
        return LocalDateTime.from(Instant.parse(isoDateTimeString).atZone(ZoneOffset.UTC));
    }

//    @Nonnull
    static LocalDate dateFromIsoString(final String isoDateString) {  //2019-02-01
         String shortenedString=null;
        Assert.notNull(isoDateString, "ISO date time must be given.");
        final int zIndex = isoDateString.indexOf("Z");
        if(zIndex>0)
           shortenedString = isoDateString.substring(0, zIndex);
        else
            shortenedString  =isoDateString;
        return LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(shortenedString));
    }
    
//      @Nonnull
    static LocalDate dateFromString(final String isoDateString) {  //2019-02-01
        Assert.notNull(isoDateString, "ISO date time must be given.");
        return LocalDate.parse(isoDateString);
//         return LocalDate.from(DateTimeFormatter.ISO_LOCAL_DATE.parse(isoDateString));
    }

//    @Nonnull
    static String toIsoString(final LocalDate localDate) {
        Assert.notNull(localDate, "LocalDateTime must be given.");
        return localDate.format(DateTimeFormatter.ISO_DATE) + "Z";
    }

//    @Nonnull
    static LocalDate toLocalDate(final LocalDateTime localDateTime) {
        Assert.notNull(localDateTime, "LocalDateTime must be given.");
        return localDateTime.toLocalDate();
    }
}
