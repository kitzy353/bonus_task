public class Main {
    public static void main(String[] args){
        int[] arr = {1, 3, 5, 5, 7, 8, 8, 8, 9, 11,11, 12, 12, 15};
        System.out.println(firstIndexOf(arr, 11));
        System.out.println(secondIndexOf(arr, 11));
        System.out.println(lastIndexOf(arr,11));
        System.out.println(has(arr,23));
        System.out.println(hasTriple(arr, 40));
    }
    public static int firstIndexOf(int[] arr, int num){
        return firstIndexOf(arr,num, 0, arr.length-1);
    }

    public static int firstIndexOf(int arr[],int num, int start, int end)
    {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if ((mid == 0 || num > arr[mid - 1]) && arr[mid] == num)
                return mid;
            else if (num > arr[mid])
                return firstIndexOf(arr, num, (mid + 1), end);
            else
                return firstIndexOf(arr,num, start, (mid - 1));
        }
        return -1;
    }

    public static int secondIndexOf(int[] arr, int num){
        int index = firstIndexOf(arr,num);
        if(arr[index+1] == num){
            return index+1;
        }
        else{
            return -1;
        }
    }

    public static int lastIndexOf(int[] array, int num) {
        int index = -1;

        int start = 0;
        int end = array.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (array[mid] == num) {
                index = lastIndexOf(array, mid, end, num);
                return index;
            } else if (array[mid] < num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return index;
    }

    private static int lastIndexOf(int[] nums, int start, int end, int target) {
        int result = start;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (nums[mid] == target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    public static boolean has(int[] arr, int sum){
        for(int i = 0; i < arr.length; i++){
            if(firstIndexOf(arr, sum - arr[i])!=-1){
                return true;
            }
        }
        return false;
    }

    private static boolean hasForTriple(int[] arr, int sum, int start){
        for(int i = start; i < arr.length; i++){
            if(firstIndexOf(arr, sum - arr[i])!=-1){
                return true;
            }
        }
        return false;
    }

    public static boolean hasTriple(int[] arr, int sum){
        for(int i = 0; i < arr.length; i++){
            if(hasForTriple(arr, sum - arr[i],i+1) == true){
                return true;
            }
        }
        return false;
    }

}

