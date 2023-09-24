package com.atlihao.leetcode.string.one;

/**
 * @author lihao
 * @ClassName IsPalindrome2
 * @Since 2020/1/4
 * @Description 125. 验证回文串  https://leetcode-cn.com/problems/valid-palindrome/
 * 代码示例3 ----- 性能优化（使用了两指针的方法）
 * Time(时间复杂度)：O(n)、Space(空间复杂度):O(1)
 */
public class IsPalindrome3 {

    /**
     * 编码方式一
     * @param s
     * @return
     */
//    public boolean isPalindrome(String s) {
//        if (s.isEmpty()) {
//            return Boolean.TRUE;
//        }
//        char[] c = s.toCharArray();
//        //从正向和逆向同时遍历字符串
//        for (int i = 0, j = s.length() - 1; i < j; ) {
//            //若不是字母和数字，则移位
//            if (!Character.isLetterOrDigit(c[i])) {
//                i++;
//            } else if (!Character.isLetterOrDigit(c[j])) {
//                j--;
//            } else if (Character.toLowerCase(c[i++]) != Character.toLowerCase(c[j--])) {
//                return Boolean.FALSE;
//            }
//        }
//        return Boolean.TRUE;
//    }


    /**
     * 判断字符是否是字母或者数据
     *
     * @param c
     * @return
     */
    private Boolean isAlphanumeric(char c) {
        return ('a' <= c && c <= 'z') ||
                ('A' <= c && c <= 'Z') ||
                ('0' <= c && c <= '9');
    }

    /**
     * 判断两个字符忽略大小写后是否相同
     * <p>
     * 注意：小写字母的字符比大写字母的字符大32
     *
     * @param a
     * @param b
     * @return
     */
    private Boolean isEqualIgnoreCase(char a, char b) {
        if (a >= 'A' && a <= 'Z') {
            a += 32;
        }
        if (b >= 'A' && b <= 'Z') {
            b += 32;
        }
        return a == b;
    }

    /**
     * 编码方式二
     *
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return Boolean.TRUE;
        }
        int i = 0;
        int j = s.length() - 1;
        for (; i < j; ++i, --j) {
            while (i < j && !isAlphanumeric(s.charAt(i))) {// 忽略非字母和数字的字符
                ++i;
            }
            while (i < j && !isAlphanumeric(s.charAt(j))) {// 忽略非字母和数字的字符
                --j;
            }
            if (i < j && !isEqualIgnoreCase(s.charAt(i), s.charAt(j))) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }
}
