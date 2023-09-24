package com.atlihao.leetcode.string.one;

/**
 * @author lihao
 * @ClassName IsPalindrome
 * @Since 2020/1/4
 * @Description 125. 验证回文串  https://leetcode-cn.com/problems/valid-palindrome/
 * 代码示例1
 */
public class IsPalindrome1 {

    public static void main(String[] args) {
        IsPalindrome1 isPalindrome = new IsPalindrome1();
        boolean palindrome = isPalindrome.isPalindrome("race a car");
        System.out.println(palindrome);
    }

    private static final String REGEX = "^[a-z0-9A-Z]+$";


    public boolean isPalindrome(String s) {
        //若为空串，直接返回有效
        if (s == null || s.length() == 0) {
            return Boolean.TRUE;
        }
        //从左到右读取字符串，将字母和数字字符组装成一个新的字符串
        String s1 = buildValidStr(s);
        //从右到左读取字符串，将字母和数字字符组装成一个新的字符串
        String s2 = buildValidStr(new StringBuilder(s).reverse().toString());
        //比较两个字符串，使用忽略字母大小写的比较方法
        return s1.equalsIgnoreCase(s2);
    }

    public String buildValidStr(String source) {
        StringBuilder target = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            Character c = source.charAt(i);
            if (c.toString().matches(REGEX)) {
                target.append(c);
            }
        }
        return target.toString();
    }
}
