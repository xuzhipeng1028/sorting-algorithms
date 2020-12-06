package com.xzp.quick;

import com.xzp.util.Util;

/**
 * 快排
 * @author xzp
 * @date 2020.12.06 15:24
 */
public class QuickSort {

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
        sort(arr,0,arr.length-1);
    }

    private static void sort(int[] arr,int leftIndex,int rightIndex){
        if(leftIndex >= rightIndex) return;
        int randomIndex = Util.generateRandom(leftIndex,rightIndex);
        Util.swap(arr,randomIndex,rightIndex);
        int pivot = arr[rightIndex];
        int leftPos = leftIndex;
        int rightPos = rightIndex - 1;
        while(leftPos <= rightPos){
            while(leftPos <= rightPos && arr[leftPos] <= pivot) leftPos++;
            while(leftPos <= rightPos && arr[rightPos] > pivot) rightPos--;
            if(leftPos < rightPos) Util.swap(arr,leftPos,rightPos);
        }
        Util.swap(arr,leftPos,rightIndex);
        sort(arr,leftIndex,leftPos-1);
        sort(arr,leftPos+1,rightIndex);
    }
}
