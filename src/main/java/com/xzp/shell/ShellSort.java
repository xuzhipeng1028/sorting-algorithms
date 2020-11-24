package com.xzp.shell;

import com.xzp.util.Util;

/**
 * 希尔排序
 * @author xzp
 * @date 2020.11.24 22:01
 */
public class ShellSort {
    public static void main(String[] args) {
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
        int h = 1;
        while(h < (arr.length / 3)){
            h = 3 * h + 1;
        }
        for(int gap = h; gap >0; gap = (gap-1)/3){
            for(int i = gap; i < arr.length; i++){
                for(int j = i; j > gap -1; j-=gap){
                    if(arr[j] < arr[j-gap]) Util.swap(arr,j,j-gap);
                }
            }
        }
    }
}
