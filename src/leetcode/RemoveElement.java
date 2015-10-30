/**
* <p>Title: RemoveElement.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月29日
* @version jdk8.0
*/
package leetcode;

import java.awt.DisplayMode;

/**
 * <p>Title: RemoveElement</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月29日
 * @time 上午10:12:02
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int actual = 0;//point to the next position of the actual array.
        int current = 0;// the current
        while(current < nums.length){
        	if(val != nums[current]){
        		if(nums[actual] != nums[current]) 
        			nums[actual] = nums[current];
        		actual ++;
        	}
        	current ++;
        }
        return actual;
    }
    
    public void display(int[] array, int length){
    	for(int i = 0; i < length; i ++)
    		System.out.print(array[i] + " ");
    	System.out.println();
    }
    
    public static void main(String[] args) {
		RemoveElement so = new RemoveElement();
		int[] test1 = {1, 1, 2, 3, 4, 2, 7, 5, 8, 8};
		System.out.println("Original array :");
		so.display(test1, test1.length);
		System.out.println("Remove 2");
		so.display(test1, so.removeElement(test1, 2));
		int[] test2 = {1, 1, 2, 3, 4, 2, 7, 5, 8, 8};
		System.out.println("Remove 1");
		so.display(test2, so.removeElement(test2, 1));
	}
}
