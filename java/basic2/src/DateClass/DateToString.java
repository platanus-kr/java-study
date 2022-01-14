package DateClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {
    public static void main(String[] args) {
        Date dateTime = new Date();
        SimpleDateFormat yymmddhhss = new SimpleDateFormat("yyMMdd-hhmmss");
        System.out.println(yymmddhhss.format(dateTime));
    }
}
