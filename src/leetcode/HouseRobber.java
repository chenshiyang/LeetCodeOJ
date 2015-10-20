/**
* <p>Title: HouseRobber.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��20��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: HouseRobber</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��20��
 * @time ����11:21:08
 */
public class HouseRobber {
	
    /**
    * <p>Description: Solution 1 : Dynamic Programming.</p>
    * @param nums
    * @return
    */
    public int rob(int[] nums) {
    	//��ʵ������Խ�totalMoney�ĳ������nums.length + 2, ����ʡ��ǰ���2�� if��䡣
    	//���Խ�һ���ֻ��� space Ϊ O(1).
    	if(null == nums || 0 == nums.length) return 0;
    	else if(nums.length == 1) return nums[0];
    	else if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
    	
    	int[] totalMoney = new int[nums.length];
    	totalMoney[0] = nums[0];
    	totalMoney[1] = nums[0] > nums[1] ? nums[0] : nums[1];
    	
    	for(int i = 2; i < totalMoney.length; i ++){
    		totalMoney[i] = Math.max(totalMoney[i - 2] + nums[i], totalMoney[i - 1]);
    	}
    	
    	return totalMoney[totalMoney.length - 1];
    }
    
    public static void main(String[] args) {
		HouseRobber so = new HouseRobber();
		int[] test1 = {1};
		int[] test2 = {2, 3, 2};
		int[] test3 = {2, 4, 8, 4, 6, 5, 5};
		
		System.out.println(so.rob(test1));
		System.out.println(so.rob(test2));
		System.out.println(so.rob(test3));
	}
}
