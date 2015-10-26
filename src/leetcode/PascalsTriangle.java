/**
* <p>Title: PascalsTriangle.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: PascalsTriangle</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午8:51:24
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(numRows < 1) return result;
        ArrayList<Integer> last = new ArrayList<Integer>();
        last.add(1);
        result.add(last);
        
        for(int i = 1; i < numRows; i ++){
        	ArrayList<Integer> res = new ArrayList<Integer>();
        	res.add(1);
        	for(int j = 0; j < last.size() - 1; j ++){
        		res.add(last.get(j) + last.get(j + 1));
        	}
        	res.add(1);
        	result.add(res);
        	last = res;
        }
        
        return result;
    }
    
    public static void main(String[] args) {
		PascalsTriangle so = new PascalsTriangle();
		System.out.println(so.generate(7));
	}
}
