package com.baomidou.mybatisplus.samples.generator.utils;
import com.sun.istack.internal.NotNull;
import org.springframework.util.StringUtils;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
    private static final String DEFAULT_DATE_TIME = "1970-01-01 08:00:00";
    private static final String DEFAULT_DATE_TIME8 = "1970-01-01";
    private static final String FORMAT_14 = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_8 = "yyyy-MM-dd";
    public static final String FORMAT_6 = "yyyy-MM";
    private static final String Format_8 = "yyyyMMdd";

    /**
     * 校验 一个日期时间 是否 为：1970-01-01 XXXXX
     * @param date
     * @param format
     * @return
     */
    public static Date checkDate(Date date,String format){
        if(date == null){
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateNowStr = sdf.format(date);
        if(DEFAULT_DATE_TIME.equals(dateNowStr)){
            return null;
        }
        if(DEFAULT_DATE_TIME8.equals(dateNowStr)){
            return null;
        }
        return date;
    }

    /**
     * 校验 日期 是否为初始值：1970-01-01
     * @param date
     * @return
     */
    public static Date checkDate8(Date date){
        Date checkDate = checkDate(date, FORMAT_8);
        if(checkDate == null){
            return null;
        }
        return date;
    }

    /**
     * 校验 日期时间 是否为初始值：1970-01-01 08:00:00
     * @param date
     * @return
     */
    public static Date checkDate14(Date date){
        Date checkDate = checkDate(date, FORMAT_14);
        if(checkDate == null){
            return null;
        }
        return date;
    }

    /**
     * Date 转 Instant
     * @param date
     * @return
     */
    public static Instant convertDateToInstant(Date date){
        if(date == null){
            return null;
        }
        return date.toInstant();
    }

    /**
     * 计算两个日期时间 相差 多少分钟
     * a->b 的时间差
     * b > a
     * @param a
     * @param b
     * @return
     */
    public static String getDateTimesDiff(Date a,Date b){
        if(checkDate14(a) == null || checkDate14(b) == null){
            return null;
        }
        Instant instantA = convertDateToInstant(a);
        Instant instantB = convertDateToInstant(b);
        if(instantA == null || instantB == null){
            return null;
        }
        long minutesDiff = ChronoUnit.MINUTES.between(instantA,instantB);
        return minutesDiff+"";
    }

    public static String getCurrentDate(Date d) {
        SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_14);
        String dateNowStr = sdf.format(d);
        return dateNowStr;
    }

    /**
     * 比较 当前日期 - 业务日期 < 5
     * true：是
     * false：否
     * @param businessDate
     * @return
     */
    public static boolean lessThanFiveDay(Date businessDate,String day){
        if(businessDate == null || day == null){
            return true;
        }
        Date currentDate = convertTimeToDate_8(new Date());
        long diffTime = currentDate.getTime() - businessDate.getTime();
        long oneDay = diffTime / 1000 / 60 / 60 / 24;
        if(oneDay < Long.valueOf(day)){
            return true;
        }
        return false;
    }

    /**
     * 比较 a - b 是否超过24小时
     * 超过：true
     * 不超过：false
     * @param a
     * @param b
     * @return
     */
    public static boolean compareTime24Before(Date a,Date b){
        if(a == null || b == null){
            return false;
        }
        Long diffTime = a.getTime() - b.getTime();
        Long oneDayTime = 24 * 60 * 60 * 1000L;
        return diffTime > oneDayTime;
    }

    /**
     * 比较两个时间是否相等
     * @param a
     * @param b
     * @return
     */
    public static boolean compareDate(Date a,Date b){
        if(a == null || b == null){
            return false;
        }
        return a.compareTo(b) == 0;
    }

    /**
     * 比较两个日期时间 是否为同一天
     * @param a
     * @param b
     * @return
     */
    public static boolean compareDateDay(Date a,Date b){
        //比较两个日期时间 是否为同一天
        String a1 = getDefaultDateFormat_8(a);
        String b1 = getDefaultDateFormat_8(b);
        return a1.equals(b1);
    }

    /**
     * 计算两个日期时间差 毫秒数
     * b - a
     * @param a
     * @param b
     * @return
     */
    public static Long calDateDiffMilliseconds(Date a,Date b){
        if(b == null){
            return 0L;
        }
        if(a == null){
            return b.getTime();
        }
        return b.getTime() - a.getTime();
    }

    /**
     * 计算两个日期时间差  分钟
     * @param a
     * @param b
     * @return
     */
    public static int calDateDiffMunite(Date a,Date b){
        return convertMillisecondsToMinute(calDateDiffMilliseconds( a, b));
    }

    /**
     * 毫秒 转 分钟
     * @param milliseconds
     * @return
     */
    public static int convertMillisecondsToMinute(Long milliseconds){
        if(LongUtil.isEmpty(milliseconds)){
            return 0;
        }
        return (int)(milliseconds/1000/60);
    }

    /**
     * 计算两个日期相差多少天
     * smdate - bdate
     * @param smdate
     * @param bdate
     * @return
     */
    public static int daysBetween(Date smdate,Date bdate){
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days=(time1-time2)/(1000*3600*24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    public static String getDefaultDateFormat(Object dateTime){
        return getDateByFormat(dateTime,FORMAT_14);
    }

    public static String getDefaultDateFormat_8(Object dateTime){
        return getDateByFormat(dateTime,FORMAT_8);
    }

    public static String getDefaultDateFormat_6(Object dateTime){
        return getDateByFormat(dateTime,FORMAT_6);
    }

    public static String getDefaultDateFormat8(Object dateTime){
        return getDateByFormat(dateTime,FORMAT_8);
    }

    public static String getDateByFormat(Object dateTime,String format){
        if(dateTime==null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String dateNowStr = sdf.format(dateTime);
        if(DEFAULT_DATE_TIME.equals(dateNowStr)){
            return null;
        }
        if(DEFAULT_DATE_TIME8.equals(dateNowStr)){
            return null;
        }
        return dateNowStr;
    }


    public static Date dateStringFormat(String dateValue){
        if(StringUtils.isEmpty(dateValue)){
            return null;
        }
        if(dateValue.length() >=8 && dateValue.length() <= 10){
            return stringToDate(dateValue, FORMAT_8);
        }
        return stringToDate(dateValue, FORMAT_14);
    }

    private static Date stringToDate(String dateValue, String format) {
        try {
            return new SimpleDateFormat(format).parse(dateValue);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    /**
     * 时间戳转化为指定格式日期
     * @param time
     * @param format
     * @return
     */
    public static Date convertTimeToDate(Date time,String format){
        if(time == null){
            return new Date();
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        String result = sdf.format(time);
        if(DEFAULT_DATE_TIME.equals(result)){
            return null;
        }
        if(DEFAULT_DATE_TIME8.equals(result)){
            return null;
        }
        try {
            return sdf.parse(result);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Date();
    }

    /**
     * 获取当前时间戳
     * @return
     */
    public static long currentTimeMillis(){
        long currentTimeMillis = Instant.now().toEpochMilli();
        return currentTimeMillis;
    }

    public static Date convertTimeToDate_14(Date time){
        return convertTimeToDate(time,FORMAT_14);
    }
    public static Date convertTimeToDate_8(Date time){
        return convertTimeToDate(time,FORMAT_8);
    }
    /**
     * 校验时间是否为 空 或者 默认日期时间
     * true: 日期字段合法 且 不是 1900-01-01:00:00:00
     * @param date
     * @return
     */
    public static boolean checkDateTime(Date date){
        if(StringUtils.isEmpty(date)) return false;
        if(DEFAULT_DATE_TIME.equals(getCurrentDate(date))) return false;
        return true;
    }

    /**
     * 日期时间戳转化为 字符串日期时间
     * @param time
     * @return
     */
    public static String convertTimeToString(String time){
        return convertTimeToString(time,FORMAT_14);
    }

    public static String convertTimeToString(Long time){
        return convertTimeToString(time,FORMAT_14);
    }

    public static String convertTimeToString_8(Long time){
        return convertTimeToString(time,FORMAT_8);
    }
    /**
     * 日期时间戳转化为 字符串日期时间
     * @param time
     * @return
     */
    public static String convertTimeToString_8(String time){
        return convertTimeToString(time,FORMAT_8);
    }

    /**
     * 日期时间戳转化为 时间戳
     * @param time
     * @return
     */
    public static String convertTimeToStringStamp(String time) {
        String s = convertTimeToString(time, FORMAT_8);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_8);
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            return s;
        }
        long ts = date.getTime();
        return String.valueOf(ts);
    }

    /**
     * 日期date 转化为 时间戳
     * @param date
     * @return
     */
    public static String convertDateToStringStamp(Date date) {
        String s = getDefaultDateFormat_8(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_8);
        Date newDate = null;
        try {
            newDate = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            return s;
        }
        long ts = newDate.getTime();
        return String.valueOf(ts);
    }

    /**
     * 日期时间戳转化为 字符串日期时间
     * @param time
     * @return
     */
    public static String convertTimeToString(String time,String format){
        if(StringUtils.isEmpty(time)){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(Long.valueOf(time));
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    public static String convertTimeToString(Long time,String format){
        if(LongUtil.isEmpty(time)){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(time);
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    public static String convertTimeToString8(String time){
        return convertTimeToStringBase(time,FORMAT_8);
    }

    public static String convertTimeToStringBase(String time,String format){
        if(StringUtils.isEmpty(time)){
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(Long.valueOf(time));
        String dateNowStr = sdf.format(date);
        return dateNowStr;
    }

    /**
     * 校验是否超过半年:180天
     * true:超过 
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean checkOneAYear(long beginTime,long endTime){
        long day = getDay(beginTime,endTime);
        if(day > 366){
            return true;
        }
        return false;
    }

    public static boolean checkTwoMonth(long beginTime,long endTime){
        long day = getDay(beginTime,endTime);
        if(day > 62){
            return true;
        }
        return false;
    }

    public static boolean checkAdminOrderExportExcelDay(long beginTime,long endTime,Long adminDay){
        if(StringUtils.isEmpty(adminDay)){
            adminDay = 35L;
        }
        long day = getDay(beginTime,endTime);
        if(day > adminDay){
            return true;
        }
        return false;
    }

    public static boolean checkOneMonth(long beginTime,long endTime){
        long day = getDay(beginTime,endTime);
        if(day > 31){
            return true;
        }
        return false;
    }

    /**
     * 获取两个时间差  天
     * @param beginTime
     * @param endTime
     * @return
     */
    public static long getDay(long beginTime,long endTime){
        long defValue = endTime - beginTime;
        if(defValue <= 0){
            return 0;
        }
        return defValue / 1000 / 60 / 60 / 24;
    }

    /**
     * 时间增加几天或几星期或几年或几月
     * @param time
     * @param dateType
     * @param number
     * @return
     */
    public static String addDate(String time, @NotNull int dateType, int number) {
        if(StringUtils.isEmpty(time)){
            return "";
        }
        Date date = new Date(Long.valueOf(time));
        return addDateConvertString(date, dateType, number);
    }

    /**
     * 时间增加几天
     * @param time
     * @param number
     * @return
     */
    public static String addDay(String time, int number) {
        return addDate(time, Calendar.DATE, number);
    }



    /**
     * 时间增加几天
     * @param date
     * @param number
     * @return
     */
    public static Date addDay(Date date, int number) {
        return addDateConvertDate(date, Calendar.DATE, number);
    }

    /**
     * 时间增加几天或几星期或几年或几月
     * @param date
     * @param dateType (ps: Calendar.YEAR)
     * @see Calendar dateType
     * @param number
     * @return
     */
    public static String addDateConvertString(Date date, @NotNull int dateType, int number) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        switch (dateType) {
            case Calendar.YEAR:
                calendar.add(Calendar.YEAR, number);
                break;
            case Calendar.MONTH:
                calendar.add(Calendar.MONTH, number);
                break;
            case Calendar.DATE:
                calendar.add(Calendar.DATE, number);
                break;
            case Calendar.WEEK_OF_MONTH:
                calendar.add(Calendar.WEEK_OF_MONTH, number);
                break;
            default:
                calendar.add(Calendar.DATE, number);
        }
        date = calendar.getTime();
        return DateUtil.getDefaultDateFormat(date);
    }

    /**
     * 按年增加
     * @param date
     * @param number
     * @return
     */
    public static String addDateYearConvertString(Date date, int number) {
        return addDateConvertString( date, Calendar.YEAR, number);
    }

    /**
     * 时间增加几天或几星期或几年或几月
     * @param date
     * @param dateType (ps: Calendar.YEAR)
     * @see Calendar dateType
     * @param number
     * @return
     */
    public static Date addDateConvertDate(Date date, @NotNull int dateType, int number) {
        if (date == null) {
            date = new Date();
        }
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        switch (dateType) {
            case Calendar.YEAR:
                calendar.add(Calendar.YEAR, number);
                break;
            case Calendar.MONTH:
                calendar.add(Calendar.MONTH, number);
                break;
            case Calendar.DATE:
                calendar.add(Calendar.DATE, number);
                break;
            case Calendar.WEEK_OF_MONTH:
                calendar.add(Calendar.WEEK_OF_MONTH, number);
                break;
            default:
                calendar.add(Calendar.DATE, number);
        }
        return calendar.getTime();
    }

    /**
     * 校验字符串是否付和日期形式
     * @param str
     * @return
     */
    private static boolean isValidDate(String str, String timeFormat) {
        boolean convertSuccess = true;
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        try {
            // 设置lenient为false.
            // 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            // e.printStackTrace();
            // 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
            convertSuccess = false;
        }
        return convertSuccess;
    }

    public static Date convertStringDateToDate(String str, String timeFormat){
        if(StringUtils.isEmpty(str)){
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(timeFormat);
        try {
            return format.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String convertDateToYearMonthDayString(Date date){
        if(date == null){
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);//获取年份
        int month = calendar.get(Calendar.MONTH) + 1;//获取月份
        int day = calendar.get(Calendar.DATE);//获取day
        return year + "年" + month + "月" + day + "日";
    }

    public static int getYear(Date date){
        if(date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);//获取年份
    }

    public static int getMonth(Date date){
        if(date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;//获取月份
    }

    public static int getDay(Date date){
        if(date == null){
            date = new Date();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DATE);//获取年份
    }

    public static Date convertStringDateToDate8(String str){
        return convertStringDateToDate(str,Format_8);
    }

    /**
     * 获取某个日期  精确到 天
     * @param date
     * @return
     */
    public static String getDateInstance(Date date){
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        String date1 =  cld.get(Calendar.YEAR)+"-"+(cld.get(Calendar.MONTH)+1)+"-"+cld.get(Calendar.DAY_OF_MONTH);
        return date1;
    }

    /**
     * 获取某个日期  精确到 时分秒
     * @return
     */
    public static String getTimeInstance(Date date){
        Calendar cld = Calendar.getInstance();
        cld.setTime(date);
        String time =  cld.get(Calendar.HOUR_OF_DAY)+":"+cld.get(Calendar.MINUTE)+":"+cld.get(Calendar.SECOND);
        return time;
    }

    /**
     * 重新组装日期时间   日期+时间字符串
     * @param dateString
     * @param timeString
     * @return
     */
    public static Date composeDate(String dateString,String timeString){
        if(StringUtils.isEmpty(dateString)){
            return null;
        }
        if(StringUtils.isEmpty(timeString)){
            return convertStringDateToDate(dateString, FORMAT_14);
        }
        return convertStringDateToDate(dateString+" "+timeString, FORMAT_14);
    }

    /**
     * 判断是否是同一年
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameYear(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        return isSameYear;
    }

    /**
     * 判断是否是同一月
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameMonth = cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        return isSameMonth;
    }

    /**
     * 判断是否是同一天
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean isSameDay(Date date1, Date date2) {
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameDay = cal1.get(Calendar.ERA) == cal2.get(Calendar.ERA) &&
                cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR)
                && cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
        return isSameDay;
    }

    /**
     * 获取当前月的最后一天
     * @param date
     * @return
     */
    public static Date getLastDayOfMonth(Date date) {
        final Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        final int last = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        cal.set(Calendar.DAY_OF_MONTH, last);
        return convertTimeToDate_8(cal.getTime());

    }

    public static void getTimeByDate(Date date){
        DateFormat df1 = DateFormat.getDateInstance();//日期格式，精确到日
        System.out.println(df1.format(date));
        DateFormat df2 = DateFormat.getDateTimeInstance();//可以精确到时分秒
        System.out.println(df2.format(date));
        DateFormat df3 = DateFormat.getTimeInstance();//只显示出时分秒
        System.out.println(df3.format(date));
        DateFormat df4 = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.FULL); //显示日期，周，上下午，时间（精确到秒）
        System.out.println(df4.format(date));
        DateFormat df5 = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG); //显示日期,上下午，时间（精确到秒）
        System.out.println(df5.format(date));
        DateFormat df6 = DateFormat.getDateTimeInstance(DateFormat.SHORT,DateFormat.SHORT); //显示日期，上下午,时间（精确到分）
        System.out.println(df6.format(date));
        DateFormat df7 = DateFormat.getDateTimeInstance(DateFormat.MEDIUM,DateFormat.MEDIUM); //显示日期，时间（精确到分）
        System.out.println(df7.format(date));
    }

    public static void main(String[] args) {
        String timeA = "2020-06-01";
        Date a = convertStringDateToDate(timeA, FORMAT_8);
//        Date date = addDay(a, 75);
//        System.out.println(date);
//        System.out.println(convertDateToYearMonthDayString(date));

        int i = daysBetween(new Date(),a);
        System.out.println("相差:"+ i + "天");

        String defaultDateFormat_6 = getDefaultDateFormat_6(a);
        System.out.println(defaultDateFormat_6);
    }

}
