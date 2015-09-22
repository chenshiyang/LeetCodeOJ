/**
* <p>Title: Solution2.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 21, 2015
* @version jdk8.0
*/
package integer_to_roman;

/**
 * <p>Title: Solution2</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 21, 2015
 * @time 9:20:06 AM
 */
public class Solution {
		String[][] digitTable= {
				{"I", "V"},
				{"X", "L"},
				{"C", "D"},
				{"M", ""}
				
		};
    public String intToRoman(int num) {
    	int digit = num % 10;
    	int i = 0;
    	String numStr = "";
    	while(i < 4){//��ൽǧλ����Ӧ4
    		numStr = digitHelper(i, digit, numStr);
    		i ++;//������һλ
    		num /= 10;
    		digit = num % 10;//ȡ��һλ
    	}
    	return numStr;
    }
    
    /**
    * <p>Description: </p>
    * @param i ��ǰ�����λ���� 0 ��ʾ��λ�� 1��ʾʮλ���������ơ�
    * @param digit ��λ�ϵ����֣�ȡֵΪ0 - 9.
    * @param numStr �����ɵ��ַ���
    * @return ���ϸ�λ����ַ���
    */
    String digitHelper(int i, int digit, String numStr){
    	if(digit <= 3){//0, 1, 2, 3
    		numStr = multiplyString(digit, digitTable[i][0]).concat(numStr);
    	}
    	else if(digit == 4){//4
    		numStr = digitTable[i][0] + digitTable [i][1] + numStr;
    	}
    	else if(digit < 9){//5, 6, 7, 8
    		numStr = digitTable[i][1] + multiplyString(digit - 5, digitTable[i][0]) + numStr;
    	}
    	else{//9
    		numStr = digitTable[i][0] + digitTable[i + 1][0] + numStr;
    	}
    	return numStr;
    }
    
    /**
    * <p>Description: generate repetioning string</p>
    * @param n number of repition times.
    * @param s the string to be repeated.
    * @return
    */
    String multiplyString(int n, String s){
    	String res = "";
    	while(n > 0){
    		res += s;
    		n --;
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		int[] test = {1 ,2 ,3 ,4, 5, 6, 7, 8, 9, 10,
				14,29,34,55,65,99,499,999,1666,
				1888,1984};
		String[] ans = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
						"XIV", "XXIX", "XXXIV", "LV", "LXV", "XCIX", "CDXCIX",
						"CMXCIX", "MDCLXVI", "MDCCCLXXXVIII", "MCMLXXXIV"
		};
		int l = test.length;
		for(int i = 0 ; i < l ; i ++){
//			System.out.println(test[i] +"  :  "  + so.intToRoman(test[i]));
			System.out.println(so.intToRoman(test[i]).equals(ans[i]));
		}
	}
}
