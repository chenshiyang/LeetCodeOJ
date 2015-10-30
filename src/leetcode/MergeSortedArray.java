/**
* <p>Title: MergeSortedArray.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月26日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: MergeSortedArray</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月26日
 * @time 下午5:32:09
 */
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	if(n == 0) return;
        //nums1 has enough space to hold elements from nums2.
    	int index = m + n;
    	int index1 = m - 1, index2 = n - 1;
    	while(-- index >= 0 && index1 >= 0 && index2 >= 0){
    		if(nums1[index1] > nums2[index2]){
    			if(nums1[index] != nums1[index1])
    				nums1[index] = nums1[index1];
    			index1 --;
    		}
    		else{
    			if(nums1[index] != nums2[index2])
    				nums1[index] = nums2[index2];
    			index2 --;
    		}
    	}
    	while(index >= 0 && index1 >= 0){
			if(nums1[index] != nums1[index1])
				nums1[index] = nums1[index1];
			index1 --;
			index --;
    	}
    	while(index >= 0 && index2 >= 0){
			if(nums1[index] != nums2[index2])
				nums1[index] = nums2[index2];
			index2 --;
			index --;
    	}
    }
    
    public static void main(String[] args) {
		MergeSortedArray so = new MergeSortedArray();
		int[] nums1 = new int[15];
		for(int i = 0; i < 7; i ++){
			nums1[i] = 2 * i;
		}
		int[] nums2 = {3, 5, 7, 9, 11};
		
		for(int i = 0; i < nums1.length; i ++){
			System.out.print(nums1[i] + "\t");
		}
		System.out.println();
		
		so.merge(nums1, 7, nums2, 5);
		
		for(int i = 0; i < nums1.length; i ++){
			System.out.print(nums1[i] + "\t");
		}
		System.out.println();
	}
}
