package com.xzp.selection;

import com.xzp.util.Util;

/**
 * 选择排序
 * 选最小值交换
 * @author xzp
 * @date 2020.11.19 23:16
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {5,1,7,3,9,4,6,10};
        sort(arr);
        Util.print(arr);
    }

    public static void sort(int[] arr){
        int minPos;
        for(int i = 0; i < arr.length - 1; i++){
            minPos = i;
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < arr[minPos]) minPos = j;
            }
            if(i != minPos) Util.swap(arr,i,minPos);
        }
    }
}
