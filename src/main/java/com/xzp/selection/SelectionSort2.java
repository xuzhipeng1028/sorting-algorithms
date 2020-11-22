package com.xzp.selection;

import com.xzp.util.Util;

/**
 * 选择排序
 * 一次选出最小值和最大值
 * @author xzp
 * @date 2020.11.19 23:16
 */
public class SelectionSort2 {

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
        int rightIndex = arr.length - 1;
        for(int i = 0; i < rightIndex; i++){
            int minPos = i;
            int maxPos = rightIndex;
            for(int j = i; j <= rightIndex; j++){
                minPos = arr[j] < arr[minPos] ? j : minPos;
                maxPos = arr[j] > arr[maxPos] ? j : maxPos;
            }
            maxPos = i == maxPos ? minPos : maxPos;
            Util.swap(arr,i,minPos);
            Util.swap(arr,rightIndex,maxPos);
            --rightIndex;
        }
    }
}
