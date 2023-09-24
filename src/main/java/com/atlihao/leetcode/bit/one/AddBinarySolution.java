package com.atlihao.leetcode.bit.one;

/**
 * @Description:
 * @Author: lihao7264
 * @CreateDate: 2021/11/16 7:28 下午
 * @UpdateUser: lihao7264
 * @UpdateDate: 2021/11/16 7:28 下午
 * @Version: 1.0.0
 */
public class AddBinarySolution {

    /**
     * 二进制求和
     *
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }
        if (b == null || b.length() == 0) {
            return a;
        }
        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        // 进位
        int c = 0;
        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                c += a.charAt(i--) - '0';
            }
            if (j >= 0) {
                c += b.charAt(j--) - '0';
            }
            stb.append(c % 2);
            c >>= 1;
        }
        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }

//    Integer aInt = 0;
//    Integer bInt = 0;
//        for (int i = 0; i < a.length(); i++) {
//        aInt = a.charAt(i) * 2 ^ i;
//    }
//        for (int i = 0; i < b.length(); i++) {
//        bInt = b.charAt(i) * 2 ^ i;
//    }
//    int result1 = aInt ^ bInt;
//    int result2 = aInt & bInt;
//        while (!(result1 == 0 || result2 == 0)) {
//        int result = result1;
//        result1 = result1 ^ result2;
//        result2 = result & result2;
//    }
//        return
}
