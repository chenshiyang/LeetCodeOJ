/**
* <p>Title: PalindromeNumber.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��29��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: PalindromeNumber</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��29��
 * @time ����5:29:23
 */
public class PalindromeNumber {
    /**
     * 
     * ˼·�� ��������Ұ�ߣ��������߱Ƚϡ� ��Ϊֻ����һ�룬���Ծ��Բ������
     * 
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if(x < 0 ||(x % 10 ==0 && x != 0)){
        	return false;
        }      
        int i = 0 ;
        while( i < x){
        	i = i * 10 + x % 10;
        	x /=10;//����
        }
        if(x == i || i / 10 == x){// i/ 10 �ǿ��ǵ�����������λ
        	return true;
        }
        return false;
    }
}
