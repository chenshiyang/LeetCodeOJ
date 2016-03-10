/**
* <p>Title: PermutationsII.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 9, 2016
* @version version 1.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>Title: PermutationsII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 9, 2016
 * @time 9:18:44 PM
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(null == nums || nums.length < 1){
        	return res;
        }
    	Arrays.sort(nums);
        res.add(generateListFromArray(nums));
        while(hasNextPermutation(nums)){
        	res.add(generateListFromArray(nums));
        }
        return res;
    }
    
    private List<Integer> generateListFromArray(int[] nums){
    	List<Integer> res = new ArrayList<Integer>();
    	for(int i : nums){
    		res.add(i);
    	}
    	return res;
    }
    
	private boolean hasNextPermutation(int[] num){
		if(null == num || num.length <= 1){
			return false;
		}
		
		int i = num.length - 2;
		while(i >= 0 && num[i] >= num[i + 1]){
			i --;
		}
		//if all in order. has not next permutation, return false.
		if(i < 0){
			reverse(num, 0, num.length - 1);
			return false;
		}
		int j = i + 1;
		for(; j < num.length - 1; j ++){
			if(num[j] > num[i] && num[j + 1] <= num[i]){//deal with duplicate
				break;
			}
		}
		swap(num, i, j);
		reverse(num, i + 1, num.length - 1);
		return true;
	}
	
	private void reverse(int[] num, int l, int r){
		for(int i = 0; i < (r - l + 1) / 2; i ++){
			swap(num, l + i, r - i);
		}
	}
	
	private void swap(int[] num, int i, int j){
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
	
	public static void main(String[] args) {
		PermutationsII so = new PermutationsII();
		int[] test1 = {2, 1, 2, 3};
		System.out.println(so.permuteUnique(test1));
		int[] test2 = {2};
		System.out.println(so.permuteUnique(test2));
	}
}
