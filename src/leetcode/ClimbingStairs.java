/**
* <p>Title: ClimbingStairs.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月28日
* @version jdk8.0
*/
package leetcode;


/**
 * <p>Title: ClimbingStairs</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月28日
 * @time 下午3:30:37
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
    
    
    /*历史总是惊人的相似，以下是我9个月前的做法*/
    /**
     * 
     * 思路：
     * 如有点A B C D E
     * 到D点的走法 = 到B 点后 大跳 + 到C点后小跳 = 到B点的走法 + 到C点的走法。
     * 这里要注意的是从B点到D点只能大跳不能小跳，因为小跳会经过C点，而这种走法已经算在C点的走法里了，会产生重复
     * 
     * 类似于非波拉契数列，生兔子
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
			System.out.println("到第" + i + "级，有：  " + so.climbStairs(i));
	}*/
}
