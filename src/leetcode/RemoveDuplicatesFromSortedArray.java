/**
* <p>Title: RemoveDuplicatesFromSortedArray.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: RemoveDuplicatesFromSortedArray</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 上午10:41:43
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
    	if(nums.length < 2) return nums.length;
        //use two pointers.
    	int l = 0, r = 0;//l表示已去重的最后一个元素，r表示当前指针
    	
    	while(r < nums.length){
    		if(nums[l] != nums[r]){//如果不重复，需要复制到前面
    			if( ++ l != r)//如果指向的不是同一个位置就复制，是同一个位置就省得复制
    				nums[l] = nums[r];//
    		}
    		r ++;
    	}
    	return l + 1;
    }
    
    public static void main(String[] args) {
		RemoveDuplicatesFromSortedArray so = new RemoveDuplicatesFromSortedArray();
		int[] test1 = {1, 1, 3, 3, 4, 4, 5, 6};
		int[] test2 = {1, 2, 3};
		int[] test3 = {};
		int[] test4 = {2};
		int[] test5 = {1, 1};
		System.out.println(so.removeDuplicates(test1));
		System.out.println(so.removeDuplicates(test2));
		System.out.println(so.removeDuplicates(test3));
		System.out.println(so.removeDuplicates(test4));
		System.out.println(so.removeDuplicates(test5));
		
	}
}
