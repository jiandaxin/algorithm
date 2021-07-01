package class01;

import java.util.Arrays;

public class Class01_BSExit {


    public static void main(String[] args) {

        int testTime = 50;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            insertionSort(arr);
            int value = (int)Math.random()*(maxValue+1) - (int)Math.random()*(maxValue);
            if(exist(arr, value) != testexit(arr, value)){
                printArray(arr);
                System.out.println(value);

                System.out.println(exist(arr, value));
                System.out.println(testexit(arr, value));
            }

        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

//        int[] arr = generateRandomArray(maxSize, maxValue);
//        int value = (int)Math.random()*(maxValue+1) - (int)Math.random()*(maxValue);
//        insertionSort(arr);
//        printArray(arr);
//        System.out.println(value);
//        boolean exist = exist(arr, value);
//        testexit(arr, value);
//        System.out.println(exist);





    }

    private static boolean testexit(int[] arr, int value) {

        for (int i :arr){
            if(i == value) return true;
        }
        return false;
    }

    private static boolean exist(int[] arr, int value) {
        if(arr == null || arr.length ==0) return false;

        int L = 0;
        int R = arr.length-1;
        int mid = 0;

        while (L < R){
            mid = L + ((R-L)>>1);
            if(arr[mid] == value){
                return true;
            }else if(arr[mid] > value){
                R = mid -1;
            }else{
                L = mid+1;
            }
        }

        return  arr[L] == value;
    }

    private static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;

    }

    private static void comparator(int[] arr) {
        Arrays.sort(arr);
    }

    private static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }


    /**
     * 插入排序
     * @param arr
     */
    private static void insertionSort(int[] arr) {

        if(arr == null || arr.length <2) return;
        int n = arr.length;
//        0-i 上有序
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j>=0 && arr[j] >arr[j+1] ; j--) {
                swap(arr,j,j+1);
            }

        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;

    }

    /**
     * 打印数组
     * @param arr
     */
    private static void printArray(int[] arr) {

        if(arr == null) return;

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

    }

    /**
     * 生成随机数组
     * @param maxSize
     * @param maxValue
     * @return
     */
    private static int[] generateRandomArray(int maxSize, int maxValue) {

        int[] arr = new int[(int) (Math.random()*(maxSize+1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random()*(maxValue+1)) - (int) (Math.random()*(maxValue+1));
        }
        return arr;

    }
}
