import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Input number '+','-','/','*', number -:");
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        str = str.replaceAll("\\s", "");
        if(str.length()<3 || str.length()>9){
            System.out.println("Выражение не правильное");
        }
        else{
            String revers = calc(str);
            System.out.println(revers);
        }
    }
    public static String calc(String a) {
        char[] chars = a.toCharArray();
        String num1 = "", num2 = "", progress = null;
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            String myStr = Character.toString(chars[i]);
            if (myStr.equals("+") || myStr.equals("-") || myStr.equals("/") || myStr.equals("*")) {
                progress = myStr;
                j += 1;
            } else if (j == 1) {
                num2 = num2 + myStr;
            } else {
                num1 = num1 + myStr;
            }
        }
        int sum = 0;
        if (!proverka(num1) || !proverka(num2)) {
            String[] arab = new String[] {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
            int kol=0;
            for (int i=0;i<arab.length;i++) {
                if (arab[i].equals(num1)) {
                    num1= String.valueOf(i+1);
                    for (j=0;j<arab.length;j++) {
                        if (arab[j].equals(num2)) {
                            num2 = String.valueOf(j + 1);
                            kol++;
                            break;
                        }
                    }
                    kol++;
                    break;
                }
            }
            if(kol==1 || kol==0){
                System.out.println("Выражение не правильное!");
            } else{
                sum = Integer.parseInt(otvet(num1,num2,progress));
                if(sum<1 || sum>10) {
                    System.out.println("Слишком много для арабских есть только 10");
                }else {
                    a=arab[sum-1];
                }
            }
        }
        else {
            sum = Integer.parseInt(otvet(num1, num2, progress));
            a = Integer.toString(sum);
        }
        return a;
    }
    public static String otvet(String num1, String num2, String progress){
        int number1 = Integer.parseInt(num1);
        int number2 = Integer.parseInt(num2);
        int sum = 0;
        switch (progress) {
            case "+":
                sum = number1 + number2;
                break;
            case "-":
                sum = number1 - number2;
                break;
            case "*":
                sum = number1 * number2;
                break;
            case "/":
                if(number2==0){
                    System.out.println("Делить на ноль нельзя!");
                    sum=0;
                }
                else {
                    sum = number1 / number2;
                }
                break;
            default:
                System.out.println("Нет такого выражения!");
                break;
        }
        String summ = Integer.toString(sum);
        return summ;
    }
    public static Boolean proverka(String num){
        String[] nums = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9","10"};
        boolean bol = false;
        for (int i=0;i<nums.length;i++) {
            if (nums[i].equals(num)) {
                bol = true;
                break;
            }
        }
        return bol;
    }
}