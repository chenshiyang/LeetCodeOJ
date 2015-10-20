/**
* <p>Title: MajorityElement.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

import java.util.Arrays;

/**
 * <p>Title: MajorityElement</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午4:08:37
 */
public class MajorityElement {
	
	//Solution 1 : sort and check
	
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    
    //Solution 2 : Moore majority vote algorithm.
    //https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
    
    public int majorityElement2(int[] nums){
    	int count = 0, candidate = nums[0];
    	for(int i = 0; i < nums.length; i ++){
    		if(count == 0){
    			candidate = nums[i];
    			count = 1;
    		}
    		else{
    			count += candidate == nums[i] ? 1 : -1;
    		}
    	}
    	return candidate;
    }
    
    public static void main(String[] args) {
		MajorityElement so = new MajorityElement();
		int[] test1 = {1};
		int[] test2 = {1, 2, 2};
		int[] test3 = {1, 2, 2, 2};
		System.out.println(so.majorityElement2(test1));
		System.out.println(so.majorityElement2(test2));
		System.out.println(so.majorityElement2(test3));
		System.out.println(so.majorityElement(test1));
		System.out.println(so.majorityElement(test2));
		System.out.println(so.majorityElement(test3));
	}
}
