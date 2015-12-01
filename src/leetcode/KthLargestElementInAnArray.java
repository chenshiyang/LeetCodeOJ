/**
* <p>Title: KthLargestElementInAnArray.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Nov 30, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: KthLargestElementInAnArray</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Nov 30, 2015
 * @time 4:58:40 PM
 */
public class KthLargestElementInAnArray {
    /**
    * <p>Description: Divide and Conquer.
    * 采用类似快排的思想。</p>
    * @param nums
    * @param k
    * @return
    */
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);// the kth largest is in fact the 
        //(nums.length - k)th(0base) element in the sorted array.
    }
    
    private int quickSelect(int[] nums, int start, int end, int k){
    	int pivot = start;
    	int left = start + 1;
    	int right = end;
    	
    	//left pointer walks to the first element that >= pivot.
    	while(left <= end && nums[left] < nums[pivot]){
    		left ++;
    	}
    	//partition. from right to left.
    	while(left < right ){
    		if(nums[right] < nums[pivot]){
    			swap(nums, left, right);
    	    	//left pointer continues to walk to the element that >= pivot. THIS IS VERY INPORTANT!
    	    	while(left <= end && nums[left] < nums[pivot]){
    	    		left ++;
    	    	}
    		}
    		right --;
    	}
    	//swap the pivot to its place.
    	swap(nums, pivot, left - 1);
    	pivot = left - 1;
    	if(pivot == k){
    		return nums[pivot];
    	}
    	else if(pivot < k){
    		return quickSelect(nums, pivot + 1, end, k);
    	}
    	else{
    		return quickSelect(nums, start, pivot - 1, k);
    	}
    }
    
    private void swap(int[] nums, int a, int b){
    	int temp = nums[a];
    	nums[a] = nums[b];
    	nums[b] = temp;
    }
    
    public static void main(String[] args) {
		KthLargestElementInAnArray so = new KthLargestElementInAnArray();
		int[] test1 = {3, 2, 1, 5, 6, 4};
		System.out.println(so.findKthLargest(test1, 1));
		System.out.println(so.findKthLargest(test1, 2));
		System.out.println(so.findKthLargest(test1, 3));
		System.out.println(so.findKthLargest(test1, 4));
		System.out.println(so.findKthLargest(test1, 5));
		System.out.println(so.findKthLargest(test1, 6));
		
		System.out.println("====================================");
		int[] test2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
/*		for(int i = 1; i <= test2.length; i ++)
			System.out.println(so.findKthLargest(test2, i));*/
		System.out.println(so.findKthLargest(test2, 1));
	}
}
