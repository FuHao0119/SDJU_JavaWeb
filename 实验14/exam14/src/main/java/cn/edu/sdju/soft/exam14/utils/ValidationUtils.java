package cn.edu.sdju.soft.exam14.utils;

import java.util.regex.Pattern;

public class ValidationUtils {

    /**
     * 校验用户名非空
     *
     * @param username 用户名
     * @return true if not null or empty
     */
    public static boolean isUsernameValid(String username) {
        return username != null && !username.trim().isEmpty();
    }

    /**
     * 校验年龄范围1-120
     *
     * @param age 年龄
     * @return true if age is between 1 and 120
     */
    public static boolean isAgeValid(int age) {
        return age >= 1 && age <= 120;
    }

    /**
     * 校验邮箱格式
     *
     * @param email 邮箱
     * @return true if email format is valid
     */
    public static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pat = Pattern.compile(emailRegex);
        return pat.matcher(email).matches();
    }
}
