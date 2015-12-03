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
    * ʹ��һ����άDP���顣
    * dptable[i][j]��ʾ ��nums[i]��nums[j]�����˻�
    * ʱ�临�Ӷ�ΪO(n^2)
    * TLE��</p>
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
    * <p>Description: ����㷨û��ɡ� ���������£�
    * {2, -2, 3, -4, -5, 1}
    * ������ֻ���ҵ�48���޷��ҵ�60�����⡣ ��������Ƿ�����ɨ��һ�Ρ�
    * ����˼·���㷨3.</p>
    * @param nums
    * @return
    */
    public int maxProduct2(int[] nums) {
    	if(null == nums || 0 == nums.length) return 0;
    	if(1 == nums.length) return nums[0];
    	//last:�����㺬�壬��last < 0ʱ����ʾ��2n(ż��)���������2n+1(����)������֮�����(���������Ǹ�����)�����˻���
    	//��last > 0ʱ����ʾǰ��������ż����������
    	//product: ��������������ĳ˻�
    	//max: ��ʷ���˻�
    	int last = 1, product = 1, max = Integer.MIN_VALUE;
    	
    	for(int i = 0; i < nums.length; i ++){
    		if(nums[i] > 0){
    			product *= nums[i];
    			max = Math.max(product, max);
    		}
    		else if(nums[i] < 0){
    			if(last < 0){//˵������֮ǰ������������
    				product = last * product * nums[i];
    				max = Math.max(product, max);
    				last = 1;//�����������������������������ż���ˣ�����last��Ϊ1.
    			}
    			else{//last = 1����֮ǰ����ż������������������ͳ���������
    				last = product * nums[i];
    				max = Math.max(last, max);
    				product = 1;//product������������ʼ�����¼��㡣
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
    * <p>Description: ǰ��ͺ�������ɨ�裬������� {2, -2, 3, -4, -5, 1} ������������������
    * ֻ��ǰ����ҵ�48�� ������ҵ�60�� ȡ���Ϊ60</p>
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
    * <p>Description: ����DP�㷨
    * ��ÿ����nums[i]�� ����¼�����β���Ӵ������max����С�˻�min��
    * ��nums[i] > 0
    * 		��max = nums[i - 1]��max * nums[i] ��nums[i]�Ľϴ���
    * 		  min = nums[i - 1]��min * nums[i] ��nums[i]�Ľ�С��
    * ��nums[i] < 0
    * 		��max = nums[i - 1]��min * nums[i] ��nums[i]�Ľϴ���
    * 		  min = nums[i - 1]��max * nums[i] ��nums[i]�Ľ�С��</p>
    * 
    * ����㷨���㷨3������ʱ4ms���㷨3��ʱ1ms��
    * @param nums
    * @return
    */
    public int maxProduct4(int[] nums) {
    	if(null == nums || 0 == nums.length) return 0;
    	//min:��nums[i]��β���Ӵ������˻� 
    	//max:��nums[i]��β���Ӵ�����С�˻� 
    	//result:��ʷ���
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
