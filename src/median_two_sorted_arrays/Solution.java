/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 10, 2015
* @version jdk8.0
*/
package median_two_sorted_arrays;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 10, 2015
 * @time 10:01:08 AM
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	//check null
    	if(nums1.length == 0 && nums2.length == 0){
    		return 0;
    	}
    	else if(nums1.length == 0 && nums1.length > 0){
    		nums1 = new int[0];
    	}
    	else if(nums1.length > 0 && nums2.length == 0){
    		nums2 = new int[0];
    	}
        double median = 0;
        median = findMedian(nums1, nums2);
        return median;
    }
    
    /**
    * <p>Description: 
    * 时间复杂度为O(log(m + n))</p>
    * @param nums1
    * @param nums2
    * @return
    */
    public double findMedian(int[] nums1, int[] nums2){
    	int total = nums1.length + nums2.length;
    	if(total % 2 == 1){
    		return findKthElement(nums1, 0, nums2, 0, total / 2 + 1);
    	}
    	else{
    		return (findKthElement(nums1, 0, nums2, 0, total / 2) + findKthElement(nums1, 0, nums2, 0, total / 2 + 1)) / 2;
    	}
    }
    
    /**
    * <p>Description: </p>
    * @param nums1 the first array
    * @param discard1 number of elements discarded in array nums1
    * @param nums2 the second array
    * @param discard2 number of elements discarded in array nums2
    * @param k the kth element.
    * @return
    */
    private double findKthElement(int[] nums1, int discard1, int[] nums2, int discard2, int k){
    	//always assume that nums1.length is equal to or smaller than nums2.length.
    	if(nums1.length - discard1 > nums2.length - discard2){
    		return findKthElement(nums2, discard2, nums1, discard1, k);
    	}
    	//base condition
    	if(nums1.length - discard1 == 0){
    		return nums2[discard2 + k - 1];
    	}
    	if(k == 1){
    		return Math.min(nums1[discard1], nums2[discard2]);
    	}
    	
    	//divide k into two parts.
    	int p1 = Math.min(k / 2, nums1.length - discard1);
    	int p2 = k - p1;
    	
    	if(nums1[discard1 + p1 - 1] < nums2[discard2 + p2 - 1]){
    		return findKthElement(nums1, discard1 + p1, nums2, discard2, k - p1);
    	}
    	else if(nums1[discard1 + p1 - 1] > nums2[discard2 + p2 - 1]){
    		return findKthElement(nums1, discard1, nums2, discard2 + p2, k - p2);
    	}
    	else{
    		return nums1[discard1 + p1 - 1];
    	}
    }
    
    public static void main(String[] args) {
		int[] n1 = {1, 2, 3, 5, 8};
		int[] n2 = {0, 4, 5, 9, 12};
		Solution sol = new Solution();
		System.out.println(sol.findMedianSortedArrays(n1, n2));
		
		int[] n3 = {0, 7};
		int[] n4 = {1, 2, 3};
		int[] n5 = {1, 2, 3, 4};
		System.out.println(sol.findMedianSortedArrays(n5, n3));
	}
}
