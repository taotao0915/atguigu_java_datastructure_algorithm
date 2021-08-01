import java.util.Arrays;

public class 选择排序算法 {
    public static void main(String[] args) {
        int[] arr = {101,34,119,1};
//        selectSortDecomposeDetail(arr);
        selectSort(arr);
        System.out.printf(Arrays.toString(arr));
    }

    /**
     * 选择排序算法的分解详情
     * @param arr:数组
     */
    public static void selectSortDecomposeDetail(int[] arr){
        // 101,34,119,1 具体的分解过程
        //第一趟排序 排序前->101,34,119,1 排序后->1,34,119,101
        int minIndex = 0;//假设最小值的下标是0
        int minData = arr[0];
        for (int j=0+1;j<arr.length;j++){
            if(minData>arr[j]){
                minIndex = j;
                minData = arr[j];
            }
        }
        arr[minIndex] = arr[0];
        arr[0] = minData;

        //第二趟排序 排序前->1,34,119,101 排序后->1,34,119,101 没有进行实际排序
        minIndex = 1;//假设最小值的下标是1
        minData = arr[1];
        for (int j=0+2;j<arr.length;j++){
            if(minData>arr[j]){
                minIndex = j;
                minData = arr[j];
            }
        }
        arr[minIndex] = arr[1];
        arr[1] = minData;

        //第三趟排序  排序前->1,34,119,101 排序后->1,34,101,119
        minIndex = 2;//假设最小值的下标是2
        minData = arr[2];
        for (int j=0+3;j<arr.length;j++){
            if(arr[minIndex]>arr[j]){
                minIndex = j;
                minData = arr[j];
            }
        }
        arr[minIndex] = arr[2];
        arr[2] = minData;
    }

    /**
     * 选择排序算法
     * @param arr:数组
     */
    public static void selectSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;//假设最小值的下标是i
            int minData = arr[i];
            boolean flag = false;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minIndex]>arr[j]){
                    minIndex = j;
                    minData = arr[j];
                    flag = true;
                }
            }
            //防止没有发生实际排序的情况，可提升性能
            if(flag){
                arr[minIndex] = arr[i];
                arr[i] = minData;
            }

        }
    }
}
