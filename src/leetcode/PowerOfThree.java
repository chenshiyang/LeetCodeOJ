/**
* <p>Title: PowerOfThree.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2016</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Jan 18, 2016
* @version jdk8.0
*/
package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: PowerOfThree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Jan 18, 2016
 * @time 11:02:23 AM
 */
public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        int[] powers = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 
        		59049, 177147, 531441, 1594323, 4782969, 14348907, 
        		43046721, 129140163, 387420489, 1162261467};
        int l = 0, r = powers.length - 1;
        int mid;
        while(l <= r){
        	mid = (l + r) / 2;
        	if(powers[mid] == n){
        		return true;
        	}
        	else if(powers[mid] < n){
        		l = mid + 1;
        	}
        	else{
        		r = mid - 1;
        	}
        }
        return false;
    }
    
    public boolean isPowerOfThree2(int n){
    	if(n < 1){
    		return false;
    	}
    	
    	double res = Math.log(n) / Math.log(3);
    	return Math.abs(res - Math.rint(res)) < 0.0000000000001;
    }
    
    public static void main(String[] args) {
    	PowerOfThree so = new PowerOfThree();
    	System.out.println(so.isPowerOfThree2(9));
    	System.out.println(so.isPowerOfThree2(243));
    	System.out.println(so.isPowerOfThree2(1));
	}
}
