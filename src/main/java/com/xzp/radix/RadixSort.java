package com.xzp.radix;

import com.xzp.util.Util;

import java.util.Arrays;

/**
 * 基数排序
 * @author xzp
 * @date 2020.12.08 23:22
 */
public class RadixSort {

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
        int[] arr = Util.generateRandomArray(100,maxValue);
        int[] copyArr = Util.copyArray(arr);
        Util.print(arr);
        sort(arr);
        Util.rightSort(copyArr);
        Util.print(arr);
        Util.print(copyArr);
    }

    public static void sort(int[] arr){
        if(arr == null || arr.length < 2) return;
        int maxBit = Util.getMaxBitOfArray(arr);
        int[] buckets = new int[10];
        for(int i = 0; i < maxBit; i++){
            int division = (int)Math.pow(10,i);
            int[] temp = new int[arr.length];
            for(int j = 0; j < arr.length; j++){
                buckets[(arr[j] / division) % 10]++;
            }
            for(int m = 1; m < buckets.length; m++){
                buckets[m] = buckets[m] + buckets[m-1];
            }
            for(int n = arr.length - 1; n >= 0; n--){
                temp[--buckets[arr[n] / division % 10]] = arr[n];
            }
            System.arraycopy(temp, 0, arr, 0, arr.length);
            if(i != maxBit - 1) Arrays.fill(buckets,0);
        }
    }
}
