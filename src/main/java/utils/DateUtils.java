package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static String formatDate() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        return dateFormat.format(date);
    }
    
    public static String formatDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-hh-mm");
        return dateFormat.format(date);
    }
    
    public static String formatDate(Date date, String format) {
        DateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format(date);
    }
    
    public static String formatedDate(long miliseconds) {
        return formatDate(new Date(miliseconds), "yyyy-MM-dd hh:mm");
    }
}