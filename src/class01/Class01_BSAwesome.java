package class01;

public class Class01_BSAwesome {


    public static void main(String[] args) {
        int test = 100;
        int testTime = 500;
        int maxSize = 1000;
        int master =100;
        int maxValue = 100;
        int test = 110;
        String testTime = "500";
        int maxSize = 180;
        String maxValue = "600";
		int test2=100;
        boolean succeed = true;
//        for (int i = 0; i < testTime; i++) {
//            int[] arr = generateRandomArray(maxSize, maxValue);
//            Arrays.sort(arr);
//            int value = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
//            if(exist(arr, value) != testexit(arr, value)){
//                printArray(arr);
//                System.out.println(value);
//
//                System.out.println(exist(arr, value));
//                System.out.println(testexit(arr, value));
//            }
//
//        }
//        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
//
//        int[] arr = generateRandomArray(maxSize, maxValue);
//
//        printArray(arr);
//        int lessIndex = getLessIndex(arr);
//        System.out.println(lessIndex);
//        System.out.println(arr[lessIndex]);

        int[] arr ={4,5,1,2,3};
        System.out.println(minNumberInRotateArray(arr));

    }

    public static int minNumberInRotateArray(int [] array) {
        int low = 0 ;
        int high = array.length - 1;
        while(low < high){
            int mid = low + (high - low) / 2;
            if(array[mid] > array[high]){
                low = mid + 1;
            }else{
                high = mid;
            }
        }
        return array[low];
    }


    public static int getLessIndex(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1; // no exist
        }
        if (arr.length == 1 || arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int left = 1;
        int right = arr.length - 2;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] > arr[mid - 1]) {
                right = mid - 1;
            } else if (arr[mid] > arr[mid + 1]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return left;
    }




    private static int testexit(int[] arr, int value) {

        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i] == value) return i;
        }
        return -1;
    }

    private static int exist(int[] arr, int value) {
        if(arr == null || arr.length ==0) return -1;

        int L = 0;
        int R = arr.length-1;
        int mid = 0;
        int index = 0;

        while (L <= R){
            mid = L + ((R-L)>>1);
            if(arr[mid] <= value){
                L = mid +1;
                index = mid;
            }else{
                R = mid-1;
            }
        }

        return  arr[index]==value?index:-1;
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
