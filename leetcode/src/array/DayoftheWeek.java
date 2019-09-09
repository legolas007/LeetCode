package array;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Usher
 * @Date: 2019/9/8,0008
 * @Description:
 */
public class DayoftheWeek {
    public static String dayOfTheWeek(int day, int month, int year)  {
        String[] weeks = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int weekOfDay = Year.of(year).atMonth(Month.of(month)).atDay(day).getDayOfWeek().getValue() - 1;
        return weeks[weekOfDay];
    }

}
