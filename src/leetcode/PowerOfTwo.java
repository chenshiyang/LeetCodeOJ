/**
* <p>Title: PowerOfTwo.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��17��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: PowerOfTwo</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��17��
 * @time ����12:34:32
 */
public class PowerOfTwo {
	//solution 1: һֱ��2��ֱ�����ܱ�2������ ����Ϊ1������2���������ݣ������ǡ�
/*    public boolean isPowerOfTwo(int n) {
    	if(n < 1) return false;
        while(n % 2 == 0){
        	n /= 2;
        }
        if(n == 1)
        	return true;
        else
        	return false;
    }*/
    
    //solution 2: ��n��2���������ݣ���n�Ķ����Ʊ�ʾֻ�����λΪ1������λΪ0��
    //��n - 1�Ķ����Ʊ�ʾǡ���෴�����λΪ0������λΪ1.
    // �� n & (n - 1) == 0, n > 0
    public boolean isPowerOfTwo(int n){
    	return (n > 0 && ((n & (n - 1)) == 0));
    }
    
    public static void main(String[] args) {
		PowerOfTwo pot = new PowerOfTwo();
		for(int i = -100; i < 10000; i ++){
			if(pot.isPowerOfTwo(i))
				System.out.println(i + " is power of two. ");
		}
	}
}
