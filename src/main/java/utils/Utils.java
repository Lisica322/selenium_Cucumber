package utils;

public class Utils {
    public static String convertPrice(String price) {
        return price.replaceAll("\\D", "");
    }
}
