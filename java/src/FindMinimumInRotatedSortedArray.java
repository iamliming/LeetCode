public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] arrs) {
        int start = 0;
        int end = arrs.length - 1;
        int mid;
        while(start < end){
            System.out.println(start+","+end);
            if(arrs[start] < arrs[end]){
                    return arrs[start];
            }
            mid = (start+end) /2;
            if(arrs[start] <= arrs[mid]){
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return arrs[start];
    }

    public static void main(String[] args) {
        int[] a = {11,21,22,23,44,45,1,2,3,4,5,6,7,8,9,10};
        FindMinimumInRotatedSortedArray aa = new FindMinimumInRotatedSortedArray();
        System.out.println(aa.findMin(a));
    }
}
