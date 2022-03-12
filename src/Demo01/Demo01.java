package Demo01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Demo01 {
    public static void main(String[] args) throws ParseException {
        System.out.println("请输入出生日期: 格式 YYYY-MM-dd");
        String birth = new Scanner(System.in).next();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birthDay = sdf.parse(birth);
        Date today = new Date();
        System.out.println("当前时间对应毫秒值：" + today.getTime());
        System.out.println("出生日期对应毫秒值：" + birthDay.getTime());
        long time = today.getTime()-birthDay.getTime();
        System.out.println("时间差为：" + time);
        long day = time/1000/60/60/24;
        System.out.println("相差天数为：" + day);
        long year = day/365;
        System.out.println("已经" + year + "岁啦！");
    }
}
