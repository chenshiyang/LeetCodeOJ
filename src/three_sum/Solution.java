/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 28, 2015
* @version jdk8.0
*/
package three_sum;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 28, 2015
 * @time 7:46:08 PM
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
    	ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	int target = 0;
        if(nums == null || nums.length < 3){
        	return res;
        }
        //sort the nums.
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i ++){
        	if(i > 0 && nums[i] == nums[i - 1]){//skip duplicates
        		continue;
        	}
        	
        	for(int l = i + 1, r = nums.length - 1; l < r; ){
        		if(nums[i] + nums[l] + nums[r] == target){
        			ArrayList<Integer> ans = new ArrayList<Integer>();
        			ans.add(nums[i]);
        			ans.add(nums[l]);
        			ans.add(nums[r]);
        			res.add(ans);
        			while( ++ l < r && nums[l] == nums[l - 1]){//skip duplicates
        				continue;
        			}
        			while( -- r > l && nums[r] == nums[r + 1]){//skip duplicates
        				continue;
        			}
        		}
        		else if(nums[i] + nums[l] + nums[r] < target){
        			l ++;
        		}
        		else{
        			r --;
        		}
        	}
        }
        return res;
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
			System.out.println(so.threeSum(test[i]));
		}
	}
}
