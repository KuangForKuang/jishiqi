package com.example.hasee.jishiqi;


public class TimeUtil {
    /**
     * 得到一个格式化的时间
     *
     * @param time 时间 毫秒
     *
     * @return 时：分：秒
     */
    public static String getFormatTime(long time) {
        time = time/1000;
        long second = time % 60;
        long minute = (time % 3600) / 60;
        long hour = time / 3600;

        // 秒显示两位
        String strSecond = ("00" + second).substring(("00" + second).length() - 2);
        // 分显示两位
        String strMinute = ("00" + minute).substring(("00" + minute).length() - 2);
        // 时显示两位
        String strHour = ("00" + hour).substring(("00" + hour).length() - 2);

        return strHour + ":" + strMinute + ":" + strSecond;
    }
}
