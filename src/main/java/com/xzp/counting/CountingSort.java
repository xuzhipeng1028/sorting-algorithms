package com.xzp.counting;

import com.xzp.util.Util;

/**
 * 计数排序
 * @author xzp
 * @date 2020.12.08 22:32
 */
public class CountingSort {

    public static void main(String[] args) {
        int testTimes = 100_0000;//循环次数，生成多少个随机数组，校验是否都排序正确
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for(int i = 0; i < testTimes; i++){
            int[] arr = Util.generateRandomArray(maxSize,maxValue);
            int[] copyArr = Util.copyArray(arr);
            int[] sortArr = sort(arr);
            Util.rightSort(copyArr);
            if(!Util.isEqual(sortArr,copyArr)){
                succeed = false;
                Util.print(sortArr);
                Util.print(copyArr);
                break;
            }
        }
        System.out.println(succeed ? "正确" : "错误");

        int[] arr = Util.generateRandomArray(10,maxValue);
        int[] copyArr = Util.copyArray(arr);
        Util.print(arr);
        int[] sortArr = sort(arr);
        Util.rightSort(copyArr);
        Util.print(sortArr);
        Util.print(copyArr);
    }

    public static int[] sort(int[] arr){
        if(arr == null || arr.length < 2) return arr;
        int min = arr[0];
        int max = arr[0];
        //遍历找出最小值和最大值
        for(int m : arr){
            min = m < min ? m : min;
            max = m > max ? m : max;
        }
        if(min == max) return arr;
        //计算最小值和最大值之间总共有多少数
        int k = max - min + 1;
        int[] buckets = new int[k];
        for(int i = 0; i < arr.length; i++){
            buckets[arr[i] - min]++;
        }
        for(int j = 1; j < buckets.length; j++){
            buckets[j] = buckets[j] + buckets[j-1];
        }
        int[] temp = new int[arr.length];
        for(int x = arr.length-1; x >= 0; x--){
             temp[--buckets[arr[x]-min]] = arr[x];
        }
        return temp;
    }
}
