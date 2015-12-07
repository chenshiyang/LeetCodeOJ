/**
* <p>Title: LongestIncreasingSubsequence.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 7, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: LongestIncreasingSubsequence</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 7, 2015
 * @time 10:08:36 AM
 */
public class LongestIncreasingSubsequence {
    /**
     * Solution 1 : DP
     * 
    * <p>Description: </p>
    * @param nums
    * @return
    */
    public int lengthOfLIS(int[] nums) {
        if(null == nums || 0 == nums.length) return 0;
        
        if(1 == nums.length) return 1;
        
        int[] dptable = new int[nums.length];
        dptable[0] = 1;
        int longest = 1;
        
        for(int i = 1; i < nums.length; i ++){
        	int len = 1;
        	for(int j = 0; j < i; j ++){
        		if(nums[j] < nums[i]){
        			len = len < dptable[j] + 1? dptable[j] + 1 : len;
        		}
        	}
        	dptable[i] = len;
        	longest = longest < len? len : longest;
        }
        
        return longest;
    }
    
    /**
     * Solution 2
     * 
    * <p>Description: </p>
    * @param nums
    * @return
    */
    public int lengthOfLIS2(int[] nums) {
    	if(null == nums || 0 == nums.length) return 0;
    	if(1 == nums.length) return 1;
    	
    	//��¼���㳤��Ϊi�ĵ��������������һ��Ԫ��Ϊ��С�� Ԫ������
    	int[] mintable = new int[nums.length];
    	for(int i = 0; i < mintable.length; i ++){
    		mintable[i] = Integer.MAX_VALUE;
    	}
    	
    	mintable[0] = 0;
    	int curLen = 1;//mintable�ĵ�ǰʵ�ʳ���
    	
    	for(int i = 1; i < nums.length; i ++){
    		//���mintable�е�һ��Ԫ��(������Ϊ1��LIS�����һ�� Ԫ��) ��nums[i]�󣬾͸���֮
    		if(nums[mintable[0]] > nums[i]){
    			mintable[0] = i;
    		}
    		//���mintable�����һ��Ԫ��(������ΪcurLen��LIS�����һ��Ԫ��)��nums[i]С��
    		//�Ϳ���ֱ�Ӱ�nums[i]���뵽mintable�����curlen ��1
    		else if(nums[mintable[curLen - 1]] < nums[i]){
    			mintable[curLen ++] = i;
    		}
    		//
    		else{
    			int index = binarySearch(nums, mintable, 0, curLen, nums[i]) + 1;
    			mintable[index] = i;
    		}
    	}
    	return curLen;
    }
    
    /**
     * Binary Search
     * ��table[start, end]���ҵ������Ǹ�����nums[table[i]] <= target ��Ԫ�أ�����i
     * table�д������Ԫ����nums�е������� ��ЩԪ��������ġ�
    * <p>Description: </p>
    * @param table
    * @param start
    * @param end
    * @param target
    * @return
    */
    private int binarySearch(int[] nums, int[] table, int start, int end, int target){
    	while(start <= end){
    		int mid = (start + end) / 2;
    		if(target > nums[table[mid]] && target <= nums[table[mid + 1]]){
    			return mid;
    		}
    		else if(target > nums[table[mid]]){// target > nums[table[mid + 1]]
    			start = mid + 1;
    		}
    		else{// target <= nums[table[mid]]
    			end = mid - 1;
    		}
    	}
    	return 0;
    }
    
    public static void main(String[] args) {
		LongestIncreasingSubsequence so = new LongestIncreasingSubsequence();
		
		int[] test1 = null;
		int[] test2 = {};
		int[] test3 = {2};
		int[] test4 = {10, 9, 2, 5, 3, 7, 101, 18};
		int[] test5 = {2, 2};
		int[] test6 = {10, 9, 3, 4, 6, 3, 5, 9, 4, 12};
		int[] test7 = {10, 22, 9, 33, 21, 50, 41, 60, 80};
		
		System.out.println(so.lengthOfLIS(test1));
		System.out.println(so.lengthOfLIS(test2));
		System.out.println(so.lengthOfLIS(test3));
		System.out.println(so.lengthOfLIS(test4));
		System.out.println(so.lengthOfLIS(test5));
		
		System.out.println("====================================================");
		System.out.println(so.lengthOfLIS2(test1));
		System.out.println(so.lengthOfLIS2(test2));
		System.out.println(so.lengthOfLIS2(test3));
		System.out.println(so.lengthOfLIS2(test4));
		System.out.println(so.lengthOfLIS2(test5));
		System.out.println(so.lengthOfLIS2(test6));
		System.out.println(so.lengthOfLIS2(test7));
	}
}
