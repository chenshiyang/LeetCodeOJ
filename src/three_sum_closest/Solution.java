/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 29, 2015
* @version jdk8.0
*/
package three_sum_closest;

import java.util.Arrays;

/**
 * <p>Title: Solution</p>
 * <p>Description: Use two pointers</p>
 * @author chenshiyang
 * @date Sep 29, 2015
 * @time 9:37:40 AM
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE;
        int res = nums[0] + nums[1] + nums[2];
        
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length; i ++){
        	for(int l = i + 1, r = nums.length - 1; l < r;){
        		int sum = nums[i] + nums[l] + nums[r];
        		if(sum == target)
        			return sum;
        		int diff = Math.abs(target - sum);
        		if(diff < closest){
        			closest = diff;
        			res = sum;
        		}
        		if(sum < target){
        			l ++;
        		}
        		if(sum > target){
        			r --;
        		}
        	}
        }
        return res;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		int[][] tests = {
				{1,1,1,1,1,1,1,1,1,1},
				{1,2,3,4,5,6,7,8,9,0},
				{-1,-1,-1,-1,-1,-1,-1,-1},
				{0,0,0,0,0,0,0,0},
				{6,6,5,23,9,46,34,8,4,9},
				{-5,-4,-3,-2,-1,0,1,2,3,4,5}
		};
		int[] target = {0,1,2,3,4,5,6,7,8,9,20};
		for(int i = 0 ; i < tests.length ; i ++){
			for (int j = 0 ; j < target.length ; j ++){
				int temp = so.threeSumClosest(tests[i], target[j]);
				System.out.print(temp + "\t");
			}
			System.out.println();
		}
		long current = System.currentTimeMillis();
		int[] test = {-43,57,-71,47,3,30,-85,6,60,-59,0,-46,-40,-73,53,68,-82,-54,88,73,20,-89,-22,39,55,-26,95,-87,-57,-86,28,-37,43,-27,-24,-88,-35,82,-3,39,-85,-46,37,45,-24,35,-49,-27,-96,89,87,-62,85,-44,64,78,14,59,-55,-10,0,98,50,-75,11,97,-72,85,-68,-76,44,-12,76,76,8,-75,-64,-57,29,-24,27,-3,-45,-87,48,10,-13,17,94,-85,11,-42,-98,89,97,-66,66,88,-89,90,-68,-62,-21,2,37,-15,-13,-24,-23,3,-58,-9,-71,0,37,-28,22,52,-34,24,-8,-20,29,-98,55,4,36,-3,-9,98,-26,17,82,23,56,54,53,51,-50,0,-15,-50,84,-90,90,72,-46,-96,-56,-76,-32,-8,-69,-32,-41,-56,69,-40,-25,-44,49,-62,36,-55,41,36,-60,90,37,13,87,66,-40,40,-35,-11,31,-45,-62,92,96,8,-4,-50,87,-17,-64,95,-89,68,-51,-40,-85,15,50,-15,0,-67,-55,45,11,-80,-45,-10,-8,90,-23,-41,80,19,29,7};
		System.out.println(so.threeSumClosest(test, 255));
		long cur1 = System.currentTimeMillis();
		System.out.println(cur1 - current);
		int[] test2 = {0, 1, 2};
		System.out.println(so.threeSumClosest(test2, 0));
	}
}
