/**
* <p>Title: PascalsTriangleII.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: PascalsTriangleII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午9:21:00
 */
public class PascalsTriangleII {
	
	//solution 1 :
	
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex < 0) return null;
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(1);
        
        for(int i = 0; i < rowIndex; i ++){
        	ArrayList<Integer> res = new ArrayList<Integer>();
        	res.add(1);
        	for(int j = 0; j < last.size() - 1; j ++){
        		res.add(last.get(j) + last.get(j + 1));
        	}
        	res.add(1);
        	last = res;
        }
        
        return last;
    }
    
    //solution 2 : using dp
    public List<Integer> getRow2(int rowIndex) {
        Integer dp[] = new Integer[rowIndex + 1];       
        for (int i = 0; i < rowIndex + 1; i++) 
            for (int j = i; j >= 0; j--) 
                dp[j] = (j == 0 || j == i) ? 1 : (dp[j-1] + dp[j]);
        return Arrays.asList(dp);
    }
    
    public static void main(String[] args) {
		PascalsTriangleII so = new PascalsTriangleII();
		System.out.println(so.getRow(6));
	}
}
