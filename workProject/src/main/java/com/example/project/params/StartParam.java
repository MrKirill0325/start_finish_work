package com.example.project.params;

public class StartParam {
    public static String filePathEmployee = "src/main/resources/employees.txt";
    public static String filePathProductLineSix = "src/main/resources/products_line_six.txt";
    public static String filePathProductLineTwelve = "src/main/resources/products_line_twelve.txt";
    public static String filePathProductLineEighteen = "src/main/resources/products_line_eighteen.txt";

    public static String mainIcon = "D:\\Shornikov\\java\\proj\\StartFinish work\\workProject\\src\\main\\java\\com\\example\\project\\rkz.png";

    public static String getPrefixEmployee() {
        return ", ";
    }


    public static String getPrefixLine() {
        return ", переналадка ";
    }
}
