package com.zge.leetcode;

import java.util.Stack;

public class _844_BackspaceStringCompare {

    //#1 Build String
    //Time complexity: O(M + N)
    //Space complexity: O(M + N)
    public static boolean backspaceCompare(String s, String t){
        return build(s).equals(build(t));
    }

    public static String build(String S){
        Stack<Character> ans = new Stack<>();
        for(char c:S.toCharArray()){
            if(c != '#'){
                ans.push(c);
            } else if (!ans.empty()) {
                ans.pop();
            }
        }
        return String.valueOf(ans);
    }

    //#2 Two Pointer
    //Time complexity: O(M + N)
    //Space complexity: O(1)

    public static boolean backspaceCompare2(String s, String t){
        int ns = s.length() - 1, nt = t.length() - 1;
        int skipS = 0, skipT = 0;

        while(ns >= 0 || nt >= 0){
            while(ns >= 0){
                if(s.charAt(ns) == '#') {skipS++; ns--;}
                else if(skipS > 0) {skipS--; ns--;}
                else break;
            }
            while(nt >= 0){
                if(t.charAt(nt) == '#') {skipT++; nt--;}
                else if(skipT > 0) {skipT--; nt--;}
                else break;
            }

            if(ns >= 0 && nt >= 0 && s.charAt(ns) != t.charAt(nt)) return false;

            //Expecting to compare char vs nothing
            //true != true   false
            //true != false  true
            if((ns >= 0) != (nt >= 0)) return false;

            ns--;
            nt--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bxj##tw";
        String t = "bxj###tw";
        //"bxj##tw"
        //"bxj###tw"

//        System.out.println(backspaceCompare(s, t));
        System.out.println(backspaceCompare2(s, t));
    }
}
