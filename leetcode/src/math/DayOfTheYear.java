package math;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: Usher
 * @Date: 2019/8/24,0024
 * @Description:
 */
public class DayOfTheYear {
    public int dayOfYear(String date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

        StringBuilder stringBuffer = new StringBuilder(date.substring(0, 4));
        stringBuffer.append("-01-01");
        int res = 0;
        try {
            Date startDate = simpleDateFormat.parse(stringBuffer.toString());
            Date endDate = simpleDateFormat.parse(date);
            calendar.setTime(startDate);
            long startMillis = calendar.getTimeInMillis();
            calendar.setTime(endDate);
            long endMillis = calendar.getTimeInMillis();
            res = Integer.parseInt(String.valueOf((endMillis - startMillis) / (1000 * 3600 * 24)));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return res;
    }
}
