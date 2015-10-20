/**
* <p>Title: ExcelSheetColumnTitle.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��20��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ExcelSheetColumnTitle excel�еı�ʾ������0�� ���Ҫ�ر��ǡ�</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��20��
 * @time ����4:22:49
 */
public class ExcelSheetColumnTitle {
	private final int ZERO = 64;
    public String convertToTitle(int n) {
        if(n <= 0) return "";
        
        String result = "";
        while(n > 0){
        	int digit = n % 26;
        	n /= 26;
        	if(digit == 0){//������λ��0�� ��Ϊ0û�ж�Ӧ����ĸ�����Ը�λ��1�� ��λ����26.
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
