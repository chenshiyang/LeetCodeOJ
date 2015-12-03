/**
* <p>Title: MaximumProductSubarray.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 2, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: MaximumProductSubarray</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 2, 2015
 * @time 10:18:44 PM
 */
public class MaximumProductSubarray {
    /**
    * <p>Description: 
    * 使用一个二维DP数组。
    * dptable[i][j]表示 从nums[i]到nums[j]的连乘积
    * 时间复杂度为O(n^2)
    * TLE了</p>
    * @param nums
    * @return
    */
    public int maxProduct(int[] nums) {
    	if(null == nums || 0 == nums.length) return 0;
    	if(nums.length == 1) return nums[0];
    	
        int[][] dptable = new int[nums.length][nums.length];
        
        //length == 1
        for(int i = 0; i < dptable.length; i ++){
        	dptable[i][i] = nums[i];
        }
        //length > 1
        for(int len = 2; len <= nums.length; len ++){
        	for(int left = 0; left < nums.length - len + 1; left ++){
        		dptable[left][left + len - 1] = dptable[left][left + len - 2] * nums[left + len - 1];
        	}
        }
        
        //find the maximum
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dptable.length; i ++){
        	for(int j = i; j < dptable[0].length; j ++){
        		if(dptable[i][j] > max){
        			max = dptable[i][j];
        		}
        	}
        }
        
        return max;
    }
    
    /**
    * <p>Description: 这个算法没完成。 在遇到以下：
    * {2, -2, 3, -4, -5, 1}
    * 会遭遇只能找到48，无法找到60的问题。 解决方法是反向再扫描一次。
    * 具体思路看算法3.</p>
    * @param nums
    * @return
    */
    public int maxProduct2(int[] nums) {
    	if(null == nums || 0 == nums.length) return 0;
    	if(1 == nums.length) return nums[0];
    	//last:有两层含义，当last < 0时，表示第2n(偶数)个负数与第2n+1(奇数)个负数之间的数(包括后面那个奇数)的连乘积。
    	//当last > 0时，表示前面正好有偶数个负数。
    	//product: 当成这个连续串的乘积
    	//max: 历史最大乘积
    	int last = 1, product = 1, max = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < nums.length; i ++){
    		if(nums[i] > 0){
    			product *= nums[i];
    			max = Math.max(product, max);
    		}
    		else if(nums[i] < 0){
    			if(last < 0){//说明在这之前有奇数个负数
    				product = last * product * nums[i];
    				max = Math.max(product, max);
    				last = 1;//加上现在这个负数，负数个数就是偶数了，所以last设为1.
    			}
    			else{//last = 1在这之前，有偶数个负数，加上这个就成奇数个了
    				last = product * nums[i];
    				max = Math.max(last, max);
    				product = 1;//product后从这个负数开始后，重新计算。
    			}
    		}
    		else{//nums[i] == 0
    			max = Math.max(max, 0);
    			product = 1;
    			last = 1;
    		}
    	}
    	return max;
    }
    
    /**
    * <p>Description: 前向和后向两次扫描，用来解决 {2, -2, 3, -4, -5, 1} 有奇数个负数的问题
    * 只用前向会找到48， 后向会找到60， 取最大为60</p>
    * @param nums
    * @return
    */
    public int maxProduct3(int[] nums) {
    	if(null == nums || 0 == nums.length) return 0;
    	if(1 == nums.length) return nums[0];
    	
    	boolean hasZero = false;
    	int max = Integer.MIN_VALUE, cur = 1;
    	//first scan, forward
    	for(int i = 0; i < nums.length; i ++){
    		if(0 == nums[i]){
    			hasZero = true;
    			cur = 1;
    		}
    		else{
    			cur *= nums[i];
    			max = Math.max(max, cur);
    		}
    	}
    	
    	//second scan, backward
    	cur = 1;
    	hasZero = false;
    	for(int i = nums.length - 1; i >= 0; i --){
    		if(0 == nums[i]){
    			hasZero = true;
    			cur = 1;
    		}
    		else{
    			cur *= nums[i];
    			max = Math.max(max, cur);
    		}
    	}
    	
    	if(hasZero && max < 0){
    		max = 0;
    	}
    	
    	return max;
    }
    
    /**
     * Solution 4
     * 
    * <p>Description: 采用DP算法
    * 对每个数nums[i]， 都记录以其结尾的子串的最大max和最小乘积min。
    * 若nums[i] > 0
    * 		则max = nums[i - 1]的max * nums[i] 和nums[i]的较大者
    * 		  min = nums[i - 1]的min * nums[i] 和nums[i]的较小者
    * 若nums[i] < 0
    * 		则max = nums[i - 1]的min * nums[i] 和nums[i]的较大者
    * 		  min = nums[i - 1]的max * nums[i] 和nums[i]的较小者</p>
    * 
    * 这个算法比算法3慢，用时4ms，算法3用时1ms。
    * @param nums
    * @return
    */
    public int maxProduct4(int[] nums) {
    	if(null == nums || 0 == nums.length) return 0;
    	//min:以nums[i]结尾的子串的最大乘积 
    	//max:以nums[i]结尾的子串的最小乘积 
    	//result:历史最大
    	int min = nums[0], max = nums[0], result = nums[0];
    	
    	for(int i = 1; i < nums.length; i ++){
    		if(nums[i] > 0){
    			max = Math.max(max * nums[i], nums[i]);
    			min = Math.min(min * nums[i], nums[i]);
    		}
    		else{//nums[i] <= 0
    			int lastMax = max;
    			max = Math.max(min * nums[i], nums[i]);
    			min = Math.min(lastMax * nums[i], nums[i]);
    		}
    		
    		result = Math.max(result, max);
    	}
    	return result;
    }
    
    public static void main(String[] args) {
		MaximumProductSubarray so = new MaximumProductSubarray();
		
		int[] test1 = {2, 3, -2, 4};//6
		int[] test2 = {2, 3, -2, -4};//48
		int[] test3 = {2, 3, 2};//12
		int[] test4 = {3};//3
		int[] test5 = {-2, 0, -1};//0
		int[] test6 = {-2};//-2
		int[] test7 = {2, -2, 3, -4, -5, 1};//60
		System.out.println(so.maxProduct(test1));
		System.out.println(so.maxProduct(test2));
		System.out.println(so.maxProduct(test3));
		System.out.println(so.maxProduct(test4));
		
		System.out.println(so.maxProduct2(test1));
		System.out.println(so.maxProduct2(test2));
		System.out.println(so.maxProduct2(test3));
		System.out.println(so.maxProduct2(test4));
		System.out.println(so.maxProduct2(test5));
		System.out.println(so.maxProduct2(test6));
		
		System.out.println("================================================");
		System.out.println(so.maxProduct3(test1));
		System.out.println(so.maxProduct3(test2));
		System.out.println(so.maxProduct3(test3));
		System.out.println(so.maxProduct3(test4));
		System.out.println(so.maxProduct3(test5));
		System.out.println(so.maxProduct3(test6));
		System.out.println(so.maxProduct3(test7));
		
		System.out.println("================================================");
		System.out.println(so.maxProduct4(test1));
		System.out.println(so.maxProduct4(test2));
		System.out.println(so.maxProduct4(test3));
		System.out.println(so.maxProduct4(test4));
		System.out.println(so.maxProduct4(test5));
		System.out.println(so.maxProduct4(test6));
		System.out.println(so.maxProduct4(test7));
		
	}
}
