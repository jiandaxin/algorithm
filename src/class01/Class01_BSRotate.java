package class01;

public class Class01_BSRotate {


    public static void main(String[] args) {
        int[] arr ={4,5,1,2,3};
        System.out.println(minNumberInRotateArray(arr));
        System.out.println(test(arr));

    }

    public static int test(int [] array) {
        if (array == null || array.length == 0) {
            throw new RuntimeException("input error!");
        }
        int min = array[0];
        for (int i : array) {
            min = i<min?i:min;
        }

        return min;
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



}
