import java.text.ParseException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) throws ParseException {
        System.out.println("（日期格式：YYYY-MM-DD）");
        System.out.println("（体重单位：斤）");
        Scanner sc = new Scanner(System.in);
        System.out.println("请选择模式：");
        System.out.println("1. 输入两个历史体重，输入想要达到的体重，计算预估时间");
        System.out.println("2. 输入两个历史体重，输入未来某个日期，计算该日期的体重");

        int mode = sc.nextInt();
        switch (mode) {
            case 1:
                Mode.runMode1(sc);
                break;
            case 2:
                Mode.runMode2(sc);
                break;
            default:
                System.out.println("没有该模式，程序结束");
                return;
        }
    }
}
