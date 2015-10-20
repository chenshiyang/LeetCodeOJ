/**
* <p>Title: ExcelSheetColumnNumber.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ExcelSheetColumnNumber</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午3:34:10
 */
public class ExcelSheetColumnNumber {
    public int titleToNumber(String s) {
    	if(null == s || s.length() == 0) return 0;
    	s = s.toUpperCase();
        int num = 0;
        int init = s.length() - 1;
        for(int i = init; i >= 0; i --){
        	int power = init - i;
        	char c = s.charAt(i);
        	num += (c - 64) * Math.pow(26, power);// c- 65 means cast from char to int. 'A' 's asicc code is 65.
        }
        return num;
    }
    
    //Solution 2 :
    public int titleToNumber2(String s) 
    {
        int sum = 0;
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++)
        {
            sum = 26 * sum + (s.charAt(i) - 64);
        }
        return sum;
    }
    
    public static void main(String[] args) {
//		System.out.println('A' - 65);
		ExcelSheetColumnNumber so = new ExcelSheetColumnNumber();
		System.out.println(so.titleToNumber("A") == 1);
		System.out.println(so.titleToNumber("B") == 2);
		System.out.println(so.titleToNumber("Z") == 26);
		System.out.println(so.titleToNumber("AB") == 28);
		System.out.println(so.titleToNumber("AAA") == 26 * 26 + 26 + 1);
		System.out.println(so.titleToNumber("AZ") == 52);
	}
}
