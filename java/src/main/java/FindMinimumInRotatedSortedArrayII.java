/*Suppose a sorted array is rotated at some pivot unknown to you beforehand.

        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

        Find the minimum element.

        The array contain duplicates.
*/
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] arrs) {

        int start = 0;
        int end = arrs.length - 1;
        int mid;
        while(start < end){
            System.out.println(start+","+end);
            mid = (start+end) /2;
            if(arrs[mid] < arrs[end]){
                end = mid;
            }
            else if(arrs[mid] > arrs[end]){
                start = mid + 1;
            }
            else{
                if(arrs[start] < arrs[end]){
                    return arrs[start];
                }
                else if(arrs[start] ==  arrs[end]){
                    start++;
                    end--;
                }
                else{
                    end = mid;
                }
            }
        }
        return arrs[start];
    }

    public static void main(String[] args) {
        int[] a = {1,1,2,2,2,4,4,4,4,1,1,1,1,1,1,1,1,1,1,1,1,1};
        FindMinimumInRotatedSortedArrayII aa = new FindMinimumInRotatedSortedArrayII();
        System.out.println(aa.findMin(a));
    }
}
