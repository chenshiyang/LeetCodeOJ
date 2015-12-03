/**
* <p>Title: HouseRobberII.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 1, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: HouseRobberII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 1, 2015
 * @time 7:18:04 PM
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(null == nums || 0 == nums.length){
        	return 0;
        }
        
        if(1 == nums.length){
        	return nums[0];
        }
        
        if(2 == nums.length){
        	return nums[0] > nums[1]? nums[0] : nums[1];
        }
        
        int[] totalMoney = new int[nums.length];
        //there are two circumstances
        //the first one: rob the first house. Then we can't rob the last house.
        totalMoney[0] = nums[0];
        totalMoney[1] = nums[0];
        for(int i = 2; i < totalMoney.length - 1; i ++){
        	totalMoney[i] = Math.max(totalMoney[i - 2] + nums[i], totalMoney[i - 1]);
        }
        int max1 = totalMoney[totalMoney.length - 2];
        
        //the second one: don't rob the first house.
        totalMoney[0] = 0;
        totalMoney[1] = nums[1];
        for(int i = 2; i < totalMoney.length; i ++){
        	totalMoney[i] = Math.max(totalMoney[i - 2] + nums[i], totalMoney[i - 1]);
        }
        int max2 = totalMoney[totalMoney.length - 1];
        
        return Math.max(max1, max2);
    }
    
    public static void main(String[] args) {
		HouseRobberII so = new HouseRobberII();
		
		int[] test1 = {1};
		int[] test2 = {2, 3, 2};
		int[] test3 = {2, 4, 8, 4, 6, 5, 5};
		
		System.out.println(so.rob(test1));
		System.out.println(so.rob(test2));
		System.out.println(so.rob(test3));
	}
}
