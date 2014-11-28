/**
 * @author liming
 * @date 14-11-28 下午2:12
 * <p/>
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p/>
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * <p/>
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RemoveDuplicatesFromSortedArrayII {

	public static int[] removeDuplicates(int[] arr, int n) {

		if (arr.length <= n) {
			return arr;
		}
		int idx = 0;
		int count = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == arr[idx]) {
				count++;
			} else {
				count = 0;
			}
			if(count < n){
				idx++;
			}
			arr[idx] = arr[i];
		}
		if(idx+1 == arr.length)
			return arr;
		else {
			int[] rst = new int[idx + 1];
			System.arraycopy(arr,0,rst,0,idx+1);
			return rst;
		}
	}

	public static void main(String[] args) {
		int[] a =  {1,1,1,1,2,2,2,2,3};
		int[] rst = removeDuplicates(a, 2);
		for(int i : rst) {
			System.out.println(i);
		}
	}
}
