package com.company.solutions;

public class RunLengthEncoding {
    public static String getEncodedString(String str){
        int strLen = str.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < strLen) {
            int j = 1;
            while(i + j < strLen && str.charAt(i) == str.charAt(i + j)){
                j++;
            }
            int cnt = j;
            sb.append(String.format("%s%d", str.charAt(i), cnt));
            i+= j;
        }
        return sb.toString();
    }

    public static void testSolution(){
        String res1 = getEncodedString("wwwwaaadexxxxxx");
        String res2 = getEncodedString("w");
        String res3 = getEncodedString("");
    }
}
