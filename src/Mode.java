import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Mode {
    private static Date date1;
    private static Date date2;
    private static double weight1;
    private static double weight2;
    private static DateFormat dateFormatIn = new SimpleDateFormat("yyyy-MM-dd");
    private static DateFormat dateFormatOut = new SimpleDateFormat("yyyy-MM-dd");
    private static DecimalFormat decimalFormat = new DecimalFormat("#.00");


    /**
     * 核心
     */
    public static void runMode1(Scanner scanner) throws ParseException {
        input(scanner);

        long day1 = date1.getTime() / 3600 / 24;
        long day2 = date2.getTime() / 3600 / 24;
        long dayDiff = Math.abs(day1 - day2) + 1;
        double changeRate = (weight1 - weight2) / dayDiff;
        System.out.println("请输入期望体重");
        double expectWeight = scanner.nextDouble();
        long expectDay = day2 + (int) ((weight2 - expectWeight) / changeRate);
        System.out.println("预计时间为：" + dateFormatOut.format(new Date(expectDay * 3600 * 24)) + "，加油喔！");

    }


    public static void runMode2(Scanner scanner) throws ParseException {
        input(scanner);

        long day1 = date1.getTime() / 3600 / 24;
        long day2 = date2.getTime() / 3600 / 24;
        long dayDiff = Math.abs(day1 - day2) + 1;
        double changeRate = (weight1 - weight2) / dayDiff;
        System.out.println("请输入期望日期");
        Date expectDate = dateFormatIn.parse(scanner.next());
        long expectDay = expectDate.getTime() / 3600 / 24;
        double expectWeight = (day2 - expectDay) * changeRate+weight2;
        System.out.println("预计体重为：" + decimalFormat.format(expectWeight) + "斤，加油喔！");

    }

    private static void input(Scanner scanner) throws ParseException {
        System.out.println("请输入第一个历史日期：");
        date1 = dateFormatIn.parse(scanner.next());
        System.out.println("请输入相应体重：");
        weight1 = scanner.nextDouble();
        System.out.println("请输入第二个历史日期：");
        date2 = dateFormatIn.parse(scanner.next());
        System.out.println("请输入相应体重：");
        weight2 = scanner.nextDouble();
    }

}
