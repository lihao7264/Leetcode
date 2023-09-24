package com.atlihao.leetcode.string.two;

/**
 * @author lihao
 * @ClassName IsPalindromeII1
 * @Since 2020/1/8
 * @Description 680. 验证回文字符串 Ⅱ  https://leetcode-cn.com/problems/valid-palindrome-ii/
 * 解题方法：贪心算法，也是左右两指针法
 * 如果字符串的起始字符和结束字符相同（即 s[0]==s[s.length-1]），则内部字符是否为回文（s[1], s[2], ..., s[s.length - 2]）将唯一地确定整个字符串是否为回文。
 * <p>
 * 算法：
 * 假设我们想知道 s[i],s[i+1],...,s[j] 是否形成回文。如果 i >= j，就结束判断。如果 s[i]=s[j]，那么我们可以取 i++;j--。否则，回文必须是 s[i+1], s[i+2], ..., s[j] 或 s[i], s[i+1], ..., s[j-1] 这两种情况。
 * <p>
 * 复杂度：
 * 时间复杂度：O(N)O(N)。其中 NN 是字符串的长度。检查两个子串是否为回文串的检查时间都是 O(N)O(N)。
 * 空间复杂度：O(1)O(1)，仅使用了指针。
 */
public class IsPalindromeII1 {

    public static void main(String[] args) {
        IsPalindromeII1 isPalindromeII1 = new IsPalindromeII1();
        boolean success = isPalindromeII1.validPalindrome("abc");
        System.out.println(success);
    }

    public boolean validPalindrome(String s) {
        int l = -1;
        int r = s.length();
        //从字符串头和字符串尾进行字符比较
        while (++l < --r) {
            //如果字符不相等
            if (s.charAt(l) != s.charAt(r)) {
                //校验字符串中(l----（r-1）)、(（l+1）----r)是不是回文串
                return isPalindromic(s, l, r - 1) || isPalindromic(s, l + 1, r);
            }
        }
        return true;
    }

    /**
     * 校验剩下部分是否是回文
     **/
    public boolean isPalindromic(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
