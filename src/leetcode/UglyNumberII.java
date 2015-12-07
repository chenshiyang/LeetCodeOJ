/**
* <p>Title: UglyNumberII.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 4, 2015
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * <p>Title: UglyNumberII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 4, 2015
 * @time 4:56:29 PM
 */
public class UglyNumberII {
    /**Solution 1
    * 利用一个DP表来寻找ugly number
    * <p>Description: </p>
    * @param n
    * @return
    */
    public int nthUglyNumber(int n) {
    	if(n == 1) return 1;
    	
    	int tableLen = 10000;
    	boolean[] table = new boolean[tableLen];
    	table[0] = true;//1为ugly number.
    	int count = 1;//记录有多少个ugly number
    	int i = 1;
    	
    	while(count < n){
    		i ++;
			boolean isUgly = false;
    		if(i <= tableLen){
    			if(0 == i % 5){
    				isUgly = isUgly(table, i / 5);
    			}
    			else if(0 == i % 3){
    				isUgly = isUgly(table, i / 3);
    			}
    			else if(0 == i % 2){
    				isUgly = isUgly(table, i / 2);
    			}
    			table[i - 1] = isUgly;//记录
    		}
    		else{
    			isUgly = isUgly(table, i);
    		}
    		if(isUgly){
    			count ++;
    		}
    	}
        return i;
    }
    
    private boolean isUgly(boolean[] table, int i){
    	if(i <= table.length){
    		return table[i - 1];
    	}
    	else{
    		if(0 == i % 5){
    			return isUgly(table, i / 5);
    		}
    		else if(0 == i % 3){
    			return isUgly(table, i / 3);
    		}
    		else if(0 == i % 2){
    			return isUgly(table, i / 2);
    		}
    		else{
    			return false;
    		}
    	}
    }
    
    /**
     * Solution 2
     * 产生ugly number
     * 
     * 参考： https://leetcode.com/discuss/58186/elegant-c-solution-o-n-space-time-with-detailed-explanation
    * <p>Description: 
    * 我们所需要的下一个ugly number 都是从现有的数乘上2或3或5得到的。
    * 它同时还要满足：
    * 大于当前的最大ugly number,又尽量地小。</p>
    * @param n
    * @return
    */
    public int nthUglyNumber2(int n) {
    	if(n < 1) return -1;
    	
    	int[] result = new int[n];
    	result[0] = 1;
    	int x2 = 0, x3 = 0, x5 = 0;
    	int count = 1;
    	
    	while(count < n){
    		int nextUgly = Math.min(Math.min(result[x2] * 2, result[x3] * 3), result[x5] * 5);
    		result[count ++] = nextUgly;
    		if(result[x2] * 2 == nextUgly){
    			x2 ++;
    		}
    		if(result[x3] * 3 == nextUgly){
    			x3 ++;
    		}
    		if(result[x5] * 5 == nextUgly){
    			x5 ++;
    		}
    	}
    	
    	return result[n - 1];
    }
    
    public static void main(String[] args) {
		UglyNumberII so = new UglyNumberII();
		
		int[] tests = {999, 205, 9, 5, 6, 7, 8};
		int n = 20;
		
		for(int i = 1; i < n; i ++){
			System.out.println("The " + i + " unly number is " + so.nthUglyNumber2(i));
		}
		
		for(int i = 0; i < tests.length; i ++){
			System.out.println("The " + tests[i] + " unly number is " + so.nthUglyNumber2(tests[i]));
		}
	}
}
