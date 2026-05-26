package com.example.demo.utils;

import com.example.demo.config.AppConfig;

/**
 * @author 85
 * 工具类模块：通用工具方法（组员3负责）
 * 字符串处理、校验、日志、格式化等通用功能
 */
public class Tools {

    // 日志打印（受配置开关控制）
    public static void log(String msg) {
        if (AppConfig.ENABLE_LOG) {
            System.out.println("[LOG] " + AppConfig.getCurrentTime() + " | " + msg);
        }
    }

    // 字符串非空校验
    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    // 密码强度校验
    public static boolean checkPwdLevel(String pwd) {
        if (isEmpty(pwd)) return false;
        if (pwd.length() < 6) return false;
        boolean hasNum = false;
        boolean hasLetter = false;
        for (char c : pwd.toCharArray()) {
            if (Character.isDigit(c)) hasNum = true;
            if (Character.isLetter(c)) hasLetter = true;
        }
        return hasNum && hasLetter;
    }

    // 文本居中格式化
    public static String centerText(String text, int width) {
        if (isEmpty(text)) return "";
        int len = text.length();
        int left = (width - len) / 2;
        int right = width - len - left;
        return getBlank(left) + text + getBlank(right);
    }

    private static String getBlank(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(" ");
        return sb.toString();
    }

    // 数字格式化
    public static String formatNum(int num) {
        if (num < 10) return "00" + num;
        if (num < 100) return "0" + num;
        return String.valueOf(num);
    }

    // 简单加密（模拟）
    public static String simpleEncrypt(String str) {
        if (isEmpty(str)) return "";
        char[] arr = str.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (char) (arr[i] + 1);
        }
        return new String(arr);
    }
}