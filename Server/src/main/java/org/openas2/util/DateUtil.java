package org.openas2.util;

import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;


public class DateUtil {

    public static String formatDate(String format, Date value)
    {
        return FastDateFormat.getInstance(format).format(value);
    }

    public static String formatDate(String format)
    {
        return formatDate(format, new Date());
    }

    public static Date parseDate(String format, String value) throws ParseException
    {
        return FastDateFormat.getInstance(format).parse(value);
    }

    public static String getSqlTimestamp()
    { 
        return getSqlTimestamp(new Date());
    }

    private static String getSqlTimestamp(Date date)
    {
        if (date == null)
        {
            return "";
        } else
        {
            //todo this property belongs to DbTracking module, it should be removed from here
            return formatDate(Properties.getProperty("sql_timestamp_format", "yyyy-MM-dd HH:mm:ss.SSS"), date);
        }
    }
}
