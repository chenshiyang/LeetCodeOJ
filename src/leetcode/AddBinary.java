/**
* <p>Title: AddBinary.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月28日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: AddBinary</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月28日
 * @time 下午3:51:10
 */
public class AddBinary {
	
    public String addBinary(String a, String b) {
    	char[] buffer = new char[Math.max(a.length(), b.length()) + 1];
        int i = buffer.length - 1, ai = a.length() - 1, bi = b.length() - 1;
        int extra = 0;
        while (extra != 0 || ai >= 0 || bi >= 0) {
            int ca = (ai >= 0 && a.charAt(ai--) == '1') ? 1 : 0;
            int cb = (bi >= 0 && b.charAt(bi--) == '1') ? 1 : 0;
            int sum = extra + ca + cb;
            buffer[i--] = (sum % 2 == 1) ? '1' : '0';
            extra = sum >> 1;
        }
        return new String(buffer, i + 1, buffer.length - i - 1);
    }

    public static void main(String[] args) {
		AddBinary so = new AddBinary();
		
		String s1 = "1111111111111111111000011";
		String s2 = "101010011110011000111";
		String s3 = "00000111111";
		String s4 = "100000000";
		System.out.println(so.addBinary(s3, s4));
	}
}
