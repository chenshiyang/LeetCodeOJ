/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 29, 2015
* @version jdk8.0
*/
package four_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 29, 2015
 * @time 10:08:48 AM
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4)
        	return result;
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i ++){
        	if(i > 0 && nums[i] == nums[i - 1])
        		continue;
        	for(int j = i + 1; j < nums.length; j ++){
    			if((j > i + 1) && nums[j] == nums[j - 1])
    				continue;
        		for(int l = j + 1, r = nums.length - 1; l < r;){
        			int sum = nums[i] + nums[j] + nums[l] + nums[r];
        			if(sum == target){
        				List<Integer> ans = new ArrayList<Integer>();
        				ans.add(nums[i]);
        				ans.add(nums[j]);
        				ans.add(nums[l]);
        				ans.add(nums[r]);
        				result.add(ans);
        				while(++ l < r && nums[l] == nums[l - 1])
        					;
        				while(-- r > l && nums[r] == nums[r + 1])
        					;
        				
        			}
        			else if(sum < target){
        				l ++;
        			}
        			else{
        				r --;
        			}
        		}
        	}
        }
        return result;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		int[][] test = {
				{0 ,0, 0, 0, 0, 0},
				{-2, -2,-1,-1,0,0,1,1,2,2,3,3},
				{-5,-4,-4,-3,0,3,6,7,43},
				{6,8,3,5,11,9,54,34,-34,-11,-12,23}
		};
		for(int i = 0 ; i < test.length ; i ++){
			System.out.println(so.fourSum(test[i], 0));
		}
	}
}
