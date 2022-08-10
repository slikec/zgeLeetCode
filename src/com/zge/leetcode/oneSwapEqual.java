package com.zge.leetcode;

import java.util.HashMap;

/**
 *  ==Check if One String Swap Can Make Strings Equal==
 * You are given two strings s1 and s2 of equal length. A string swap is an operation where you choose two indices in a
 * string (not necessarily different) and swap the characters at these indices.
 *
 * Return true if it is possible to make both strings equal by performing at most one string swap on exactly one of
 * the strings. Otherwise, return false.
 */
public class oneSwapEqual {
    public static void main(String[] args) {
        String s1 = "ysmpagrkzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhqkxumonfgrczmjvbhwvhpnocz";
        String s2 = "ysmpagrqzsmmzmsssutzgpxrmoylkgemgfcperptsxjcsgojwourhxlhkkxumonfgrczmjvbhwvhpnocz";

        boolean swap = false;
        int sameChar =0;
        int indexDiff =0;
        int n = s1.length();
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        int j=0;
        for(int i=0; i<n;i++){
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if(a==b){
                sameChar++;
            }
            else{
                hashMap.put(j, i);
                j++;
            }
        }
        if(sameChar==n){
            swap=true;
        }
        else if(sameChar==n-2){
            int num1 = hashMap.get(0);
            int num2 = hashMap.get(1);
            if(s1.charAt(num1)==s2.charAt(num2) && s1.charAt(num2)==s2.charAt(num1)){
                swap = true;
            }
        }

        System.out.println(hashMap);
        System.out.println(swap);



//        HashMap<Integer, Character> hashMap1 = new HashMap<Integer, Character>();
//        HashMap<Integer, Character> hashMap2 = new HashMap<Integer, Character>();
//
//        for (int i = 0; i < n; i++) {
//            hashMap1.put(i, s1.charAt(i));
//            hashMap2.put(i, s2.charAt(i));
//        }
//
//        if(hashMap1.equals(hashMap2)){
//            swap = true;
//        }
//        else
//        {
//            for (int i = 0; i < n; i++) {
//                char a = hashMap1.get(i);
//                char c = hashMap2.get(i);
//                if(a==c){
//                    hashMap2.replace(i,Character.toUpperCase(c));
//                    sameChar++;
//                    System.out.println(sameChar);
//                    continue;
//                }
//                for (int j = 0; j < n; j++) {
//                    char b = hashMap2.get(j);
//                    if(a==b){
//                        hashMap2.replace(j,Character.toUpperCase(b));
//                        sameChar++;
//                        if(i!=j){
//                            System.out.println("i = " + i + " j = " + j );
//                            System.out.println(hashMap2);
//                            indexDiff++;
//                        }
//                        break;
//                    }//end if
//                }//end for
//            }
//            if(sameChar==n && indexDiff==2){
//                swap=true;
//            }
//        }
//
//        System.out.println(sameChar);
//        System.out.println(indexDiff);
//        System.out.println(hashMap2);
//        System.out.println(swap);
    }
}
