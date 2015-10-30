/**
* <p>Title: ZigZagConversion.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��29��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ZigZagConversion</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��29��
 * @time ����9:29:24
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if(1 == numRows) return s;
        StringBuilder sb = new StringBuilder();
        
        int pageSize = 2 * numRows - 2;//һҳ ��ʾһ����ֱ�мӺ���ļ���б��
        int pageCount = s.length() / pageSize + 1;//���һҳ���ܲ���
        int slen = s.length();
    	for(int j = 0; j < numRows; j ++){
    		for(int i = 0; i < pageCount; i ++){  			
        		int index = j + i * pageSize;
        		if(index < slen)
        			sb.append(s.charAt(index));
        		if(0 != j && numRows - 1 != j){//������ǵ�һ�к����һ�У���Ҫд������
        			int idx = pageSize - j  + i * pageSize;
        			if(idx < slen)
        				sb.append(s.charAt(idx));        			
        		}
        	}
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
		ZigZagConversion so = new ZigZagConversion();
		String s1 = "PAYPALISHIRING";
		String s2= "";
		
		System.out.println(so.convert(s1, 3).equals("PAHNAPLSIIGYIR"));
		System.out.println(so.convert(s1, 3));
		System.out.println(so.convert(s1, 2).equals("PYAIHRNAPLSIIG"));
		System.out.println(so.convert(s1, 1).equals(s1));
	}
}
