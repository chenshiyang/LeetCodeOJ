/**
* <p>Title: ClimbingStairs.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��28��
* @version jdk8.0
*/
package leetcode;


/**
 * <p>Title: ClimbingStairs</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��28��
 * @time ����3:30:37
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        
        int n1 = 1, n2 = 2;
        int temp;
        for(int i = 3; i <= n ; i ++){
        	temp = n1;
        	n1 = n2;// i - 2 change to i - 1
        	n2 = temp + n2;//i - 1 change to i
        }
        return n2;
    }
    
    public static void main(String[] args) {
		ClimbingStairs cs = new ClimbingStairs();
		for(int i = 0; i < 10; i ++){
			System.out.println("stairs " +  i + ", means : " + cs.climbStairs(i));
		}
	}
    
    
    /*��ʷ���Ǿ��˵����ƣ���������9����ǰ������*/
    /**
     * 
     * ˼·��
     * ���е�A B C D E
     * ��D����߷� = ��B ��� ���� + ��C���С�� = ��B����߷� + ��C����߷���
     * ����Ҫע����Ǵ�B�㵽D��ֻ�ܴ�������С������ΪС���ᾭ��C�㣬�������߷��Ѿ�����C����߷����ˣ�������ظ�
     * 
     * �����ڷǲ��������У�������
     * 
     * @param n
     * @return
     */
/*    public int climbStairs(int n) {
        if(n == 1 || n == 2 || n == 0)
        	return n;
		int s1 = 1;
		int s2 = 2;
		int s = 0;
		for (int i = 3; i <= n; i++) {
			s = s1 + s2;
			s1 = s2;
			s2 = s;
		}
        return s;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		for(int i = 0 ; i < 10 ; i ++)
			System.out.println("����" + i + "�����У�  " + so.climbStairs(i));
	}*/
}
