package org.codepractice.DatePractice;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateHelper {
    public static String getDate(String pattern) {
        return (new SimpleDateFormat(pattern)).format(new Date());
    }

    public static boolean isDate(int sYear, int sMonth, int sDay) {
        if (sYear < 0 || sMonth <= 0 || sDay <= 0 || sMonth > 12 || sDay > 31) {
            return false;
        } else if (sDay > getLastDayOfMonth(sYear, sMonth)) {
            return false;
        }

        return true;
    }

    public static boolean isDate(String sDate) {
        if (sDate == null || sDate.length() != 8) {
            return false;
        }

        int sYear = Integer.parseInt(sDate.substring(0, 4));
        int sMonth = Integer.parseInt(sDate.substring(4, 6));
        int sDay = Integer.parseInt(sDate.substring(6, 8));

        return isDate(sYear, sMonth, sDay);
    }

    public static int getLastDayOfMonth(int sYear, int sMonth) {
        Calendar cal = Calendar.getInstance();
        cal.set(sYear, sMonth - 1, 1);

        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static long getDifferDay(String sDate, String eDate) {
        int sy = Integer.parseInt(sDate.substring(0, 4));
        int sm = Integer.parseInt(sDate.substring(4, 6));
        int sd = Integer.parseInt(sDate.substring(6, 8));
        int ey = Integer.parseInt(eDate.substring(0, 4));
        int em = Integer.parseInt(eDate.substring(4, 6));
        int ed = Integer.parseInt(eDate.substring(6, 8));

        GregorianCalendar s = new GregorianCalendar(sy, sm - 1, sd, 0, 0, 0);
        GregorianCalendar e = new GregorianCalendar(ey, em - 1, ed, 0, 0, 0);

        return (e.getTime().getTime() - s.getTime().getTime()) / 86400000;
    }

    public static String getAddDay(String sDate, int addDay) {
        int y = Integer.parseInt(sDate.substring(0, 4));
        int m = Integer.parseInt(sDate.substring(4, 6));
        int d = Integer.parseInt(sDate.substring(6, 8));

        Calendar cal = Calendar.getInstance(Locale.getDefault());
        cal.set(y, m - 1, d);
        cal.add(Calendar.DATE, addDay);

        return (new SimpleDateFormat("yyyyMMdd")).format(cal.getTime());
    }
}