package kmp;

import java.util.Arrays;

public class KmpAlgorithm {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        //String str2 = "BBC";

        int[] next = kmpNext("ABCDABD");
        System.out.println("next = " + Arrays.toString(next));

        int index = kmpSearch(str1, str2);
        System.out.println("index = " + index); // 结果为：15
    }

    /**
     * kmp搜索算法
     * @param sourceString 源字符串
     * @param destString 子串
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    private static int kmpSearch(String sourceString, String destString) {
        int[] next = kmpNext(destString);
        //遍历
        for(int i = 0, j = 0; i < sourceString.length(); i++) {
            //需要处理 str1.charAt(i) ！= str2.charAt(j), 去调整j的大小
            //KMP算法核心点
            while( j > 0 && sourceString.charAt(i) != destString.charAt(j)) {
                j = next[j-1];
            }

            if(sourceString.charAt(i) == destString.charAt(j)) {
                j++;
            }

            //找到了
            if(j == destString.length()) {
                return i - j + 1;
            }
        }
        return  -1;
    }

    /**
     * 获取到一个字符串(子串) 的部分匹配值表
     */
    private static  int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        //如果字符串是长度为1 部分匹配值就是0
        next[0] = 0;
        //
        for(int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
