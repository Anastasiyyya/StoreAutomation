package test_data;

import java.util.Random;

public class Utils {

    /**
     * This method generate a random string
     * @param length
     * @return String
     */
    public static String generateRandomString(int length){
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while(sb.length() < length){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, length);
    }
}
