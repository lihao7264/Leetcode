package com.atlihao.leetcode.string.one;

/**
 * @author lihao
 * @ClassName IsPalindrome2
 * @Since 2020/1/4
 * @Description 125. 验证回文串  https://leetcode-cn.com/problems/valid-palindrome/
 * 代码示例2 ----- 自顶向下的编程方式(代码可读性强)
 */
public class IsPalindrome2 {

    public boolean isPalindrome(String s) {
        //高层次主干逻辑

        //1、filter out number & char（过滤掉非数字和非字母）
        String filteredS = filterNonNumberAndChar(s);

        //2、reverse  反转字符串
        String reversedS = reverseNonNumberAndChar(filteredS);

        //compare 忽略大小写比较
        return reversedS.equalsIgnoreCase(filteredS);
    }

    private String reverseNonNumberAndChar(String s) {
        return new StringBuilder(s).reverse().toString();
    }

    private String filterNonNumberAndChar(String s) {
        //过滤非字母和非数字的字符
        return s.replaceAll("[^A-Za-z0-9]", "");
    }
}
