package com.cote.basic;

/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
Copyright 2009–2022 by Codility Limited. All Rights Reserved. Unauthorized copying, publication or disclosure prohibited.
 */
public class BinaryGap1 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int N = 1162;
        int result = s.solution(N);
        System.out.println("result => " + result);
    }
}

class Solution {
    public int solution(int N) {
        int result = 0;

        String binaryString = Integer.toBinaryString(N); //이진 변환

        char[] digits = String.valueOf(binaryString).toCharArray(); //자릿수별로 쪼갬
        System.out.println("binaryString => " + binaryString);

        int tempNum = -1;
        int cnt = 0;
        for (char charNum : digits) {
            int num = Character.getNumericValue(charNum); //char to int

            if( num == 1 && tempNum == -1 ){
                tempNum = num;
                continue;
            }

            if( num == 0 ) cnt++;

            if( num == 1 && tempNum == 1 ){
                if( result < cnt ) {
                    result = cnt;
                }

                cnt = 0;
                //tempNum = -1;
            }
        }


        return result;
    }
}