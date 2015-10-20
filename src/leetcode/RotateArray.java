/**
* <p>Title: RotateArray.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: RotateArray</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午2:49:31
 */
public class RotateArray {
	//Solution 1 : time O(n), space O(k)
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if(k == 0) return;
        int[] backup = new int[k];
        for(int i = 1; i <= k; i ++){
        	backup[backup.length - i] = nums[nums.length - i]; 
        }
        int c = nums.length - k;
        for(int i = c - 1; i >= 0; i --){
        	if(nums[i] != nums[i + k]) nums[i + k] = nums[i];
        }
        for(int i = 0; i < k; i ++)
        	nums[i] = backup[i];
    }
    
    //Solution 2 : 
    public void rotate2(int[] nums, int k) {

        if(nums == null || nums.length < 2){
            return;
        }

        k = k % nums.length;
        reverse(nums, 0, nums.length - k - 1);
        reverse(nums, nums.length - k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);

    }

    private void reverse(int[] nums, int i, int j){
        int tmp = 0;       
        while(i < j){
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
    
    public void display(int[] nums){
    	for(int i = 0; i < nums.length; i ++){
    		System.out.print(nums[i] + "\t");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		RotateArray so = new RotateArray();
		int[] test1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		so.display(test1);
		so.rotate(test1, 1);
		so.display(test1);
		so.rotate(test1, 4);
		so.display(test1);
		so.rotate(test1, 20);
		so.display(test1);
	}
}
