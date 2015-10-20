/**
* <p>Title: ContainsDuplicate.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

import java.util.HashMap;

/**
 * <p>Title: ContainsDuplicate</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 上午11:05:05
 */
public class ContainsDuplicate {
	//solution 1 : sort and check
/*    public boolean containsDuplicate(int[] nums) {
    	if(nums.length <= 1) return false;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i ++){
        	if(nums[i] == nums[i - 1])
        		return true;
        }
        return false;
    }*/
    
    //solution 2 : use hashmap
    public boolean containsDuplicate(int[] nums) {
    	if(nums.length <= 1) return false;
    	HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i ++){
    		if(table.get(nums[i]) != null)
    			return true;
    		else
    			table.put(nums[i], 0);
    	}
    	return false;
    }
    
    //solution 3 : 
/*    public boolean containsDuplicate(int[] nums) {
    	if(nums.length <= 1) return false;
    	HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
    	for(int i = 0; i < nums.length; i ++){
    		if(table.get(nums[i]) != null)
    			return true;
    		else
    			table.put(nums[i], 0);
    	}
    	return false;
    }*/
    
    public static void main(String[] args) {
		ContainsDuplicate cd = new ContainsDuplicate();
		int[] test1 = {};
		int[] test2 = {1};
		int[] test3 = {9, 8, 7, 6, 5};
		int[] test4 = {9, 8, 8, 7, 5};
		
		System.out.println(cd.containsDuplicate(test1));
		System.out.println(cd.containsDuplicate(test2));
		System.out.println(cd.containsDuplicate(test3));
		System.out.println(cd.containsDuplicate(test4));
	}
}
