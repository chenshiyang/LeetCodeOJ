/**
* <p>Title: ContainsDuplicateII.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <p>Title: ContainsDuplicateII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 上午11:42:06
 */
public class ContainsDuplicateII {
	//solution 1 : time limit exceed
/*    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return false;
        
        for(int i = 1; i < nums.length; i ++){
        	int low = Math.max(0, i - k); int high = Math.min(nums.length - 1, i + k);
        	for(int j = low; j <= high; j ++){
        		if(nums[j] == nums[i] && j != i)
        			return true;
        	}
        }
        return false;
    }*/
    
    //solution 2 : use a hashmap, time limit exceed..
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return false;

        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i ++){
        	if(table.containsKey(nums[i]) && table.get(nums[i]) - i <= k)
        		return true;
        	else
        		table.put(nums[i], i);
        }
        return false;
    }
    
    //solution3 : use a slide window and a set. time limit exceed.
/*    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) return false;

        Set<Integer> windowNum  = new HashSet<Integer>();
        int start = 0; int end = 0;
        
        for(int i = 0; i < nums.length; i ++){
        	if(! windowNum.contains(nums[i])){
        		windowNum.add(nums[i]);
        		end ++;
        	}
        	else
        		return true;
        	
        	if(end - start > k){
        		windowNum.remove(nums[start]);
        		start ++;
        	}
        }
        return false;
    }*/
    
    public static void main(String[] args) {
		ContainsDuplicateII cd = new ContainsDuplicateII();
		int[] test1 = {};
		int[] test2 = {1};
		int[] test3 = {9, 8, 7, 6, 5};
		int[] test4 = {9, 8, 8, 7, 5};
		
		System.out.println(cd.containsNearbyDuplicate(test1, 0));
		System.out.println(cd.containsNearbyDuplicate(test2, 0));
		System.out.println(cd.containsNearbyDuplicate(test3, 1));
		System.out.println(cd.containsNearbyDuplicate(test4, 1));
	}
}
