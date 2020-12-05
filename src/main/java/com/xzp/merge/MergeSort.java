package com.xzp.merge;

import com.xzp.util.Util;

/**
 * 归并排序
 * @author xzp
 * @date 2020.12.05 21:23
 */
public class MergeSort {
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
        if(arr == null || arr.length <2) return;
        sort(arr,0,arr.length-1);
    }

    /**
     * 对数组中left(包含)至right(包含)位置的元素排序
     * @param arr
     * @param left
     * @param right
     */
    private static void sort(int[] arr,int left,int right){
        if(left < 0 || left >= arr.length || right < 0 || right >= arr.length || left >= right) return;
        int mid = left + ((right - left + 1) >> 1);
        sort(arr,left,mid-1);
        sort(arr,mid,right);
        merge(arr,left,mid,right);
    }

    /**
     * 对数组中已经排好序的两部分归并排序
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @param rightBound
     */
    private static void merge(int[] arr,int leftIndex,int rightIndex,int rightBound){
        if(leftIndex >= rightIndex) return;
        int left = leftIndex;
        int right = rightIndex;
        int[] temp = new int[rightBound - leftIndex + 1];
        int k = 0;
        while(left < rightIndex && right <= rightBound){
            temp[k++] = arr[left] <= arr[right] ? arr[left++] : arr[right++];
        }
        while(left < rightIndex){
            temp[k++] = arr[left++];
        }
        while(right <= rightBound){
            temp[k++] = arr[right++];
        }
        left = leftIndex;
        for(int i = 0; i < temp.length; i++){
            arr[left++] = temp[i];
        }
    }
}
