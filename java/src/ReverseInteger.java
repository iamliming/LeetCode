/**
 * Reverse digits of an integer.
 * <p/>
 * Example1: x = 124, return 421
 * Example2: x = -123, return -321
 *
 * @author liming
 * @date 14-11-26 下午2:04
 */
public class ReverseInteger {
	public static int reverseA(int in){
		int rst = 0;
		int x = in<0?-in:in;
		while(x/10 > 0){
			rst = rst*10 + x%10;
			x = x/10;
		}
		rst = rst*10 + x;
		return in<0?-rst:rst;
	}

	public static int reverse(int x) {
		String str = String.valueOf(x);
		int end = str.length() - 1;
		int indx = 0;
		int start = 0;
		char[] chars = str.toCharArray();
		char[] rstChars = new char[str.length()];
		if(chars[0] == '-'){
			rstChars[0] = '-';
			indx = 1;
			start= 1;
		}

		for(;end >=start ;indx++,end--){
			rstChars[indx] = chars[end];
		}
		System.out.println(Integer.parseInt(new String(rstChars)));
		return Integer.parseInt(new String(rstChars));
	}

	public static void main(String[] args) {

		System.out.println(reverseA(-102601));
	}
}
