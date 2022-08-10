package com.zge.leetcode;

public class averageSalary {
        public static void main(String[] args){
            int salary[] = new int[]{48000,59000,99000,13000,78000,45000,31000,17000,39000,37000,
                    93000,77000,33000,28000,4000,54000,67000,6000,1000,11000};
//            int Min = getMin(salary);
//            int Max = getMax(salary);

            /*
            Integer.MIN_VALUE and Integer.MAX_VALUE specifies that stores the maximum or minimum possible value for
            any integer variable in Java.
            Math.min and Math.max returns the minimum or maximum of two numbers.
             */
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, n = salary.length;
            double sum = 0;
            for(int value : salary){
                sum+=value;
                min = Math.min(min,value);
                max = Math.max(max,value);
            }

            double average = (sum-max-min) / (n-2);

            System.out.println(average);
        }

        public static int getMin(int[] inputArray){
            int minValue = inputArray[0];
            for(int i=1; i<inputArray.length;i++){
                if(inputArray[i]<minValue){
                    minValue = inputArray[i];
                }
            }
            return minValue;
        }

        public static int getMax(int[] inputArray){
            int maxValue = inputArray[0];
            for(int i=1; i<inputArray.length;i++){
                if(inputArray[i]>maxValue){
                    maxValue = inputArray[i];
                }
            }
            return maxValue;
        }



}
