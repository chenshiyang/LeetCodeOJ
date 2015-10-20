/**
* <p>Title: ExcelSheetColumnTitle.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ExcelSheetColumnTitle excel中的表示不存在0， 因此要特别考虑。</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午4:22:49
 */
public class ExcelSheetColumnTitle {
	private final int ZERO = 64;
    public String convertToTitle(int n) {
        if(n <= 0) return "";
        
        String result = "";
        while(n > 0){
        	int digit = n % 26;
        	n /= 26;
        	if(digit == 0){//如果这个位是0， 因为0没有对应的字母，所以高位退1， 低位补成26.
        		digit = 26;
        		n --;
        	}
        	result = (char)(digit + ZERO) + result;
        }
        return result;
    }
    
    public static void main(String[] args) {
		ExcelSheetColumnTitle so = new ExcelSheetColumnTitle();
		for(int i = 0; i < 100; i ++){
			System.out.println(i + " " + so.convertToTitle(i));
		}
		System.out.println(703 + " " + so.convertToTitle(703));
	}
}
