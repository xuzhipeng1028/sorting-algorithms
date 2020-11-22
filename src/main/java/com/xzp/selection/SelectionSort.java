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
//        int[] arr = {5,1,7,3,9,4,6,10};
//        sort(arr);
//        Util.print(arr);
        int testTimes = 100_0000;//循环次数，生成多少个随机数组，校验是否都排序正确
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTimes; i++){
            int[] arr = Util.generateRandomArray(maxSize,maxValue);
            int[] copyArr = Util.copyArray(arr);
            sort(arr);
            Util.rightSort(copyArr);
            if(!Util.isEqual(arr,copyArr)){
                succeed = false;
                Util.print(arr);
                Util.print(copyArr);
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");

        int[] arr = Util.generateRandomArray(10,maxValue);
        int[] copyArr = Util.copyArray(arr);
        Util.print(arr);
        sort(arr);
        Util.rightSort(copyArr);
        Util.print(arr);
        Util.print(copyArr);
    }

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
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
