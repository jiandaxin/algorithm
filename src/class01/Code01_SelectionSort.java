package class01;

import java.util.Arrays;

/**
 * 选择排序
 */
public class Code01_SelectionSort {


    public static void main(String[] args) {

        int testTime = 50;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            selectionSort(arr1);
            comparator(arr2);
            if (!isEqual(arr1, arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");

        int[] arr = generateRandomArray(maxSize, maxValue);
        printArray(arr);
        selectionSort(arr);
        printArray(arr);
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
     * 选择排序
     * @param arr
     */
    private static void selectionSort(int[] arr) {

        if(arr == null || arr.length <2) return;
        int n = arr.length;
//       // 0 ~ N-1  找到最小值，在哪，放到0位置上
//		// 1 ~ n-1  找到最小值，在哪，放到1 位置上
//		// 2 ~ n-1  找到最小值，在哪，放到2 位置上
        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int J = i; J < n ; J++) {
                minIndex = arr[J] < arr[minIndex]?J:minIndex;
            }
            swap(arr,i,minIndex);

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
