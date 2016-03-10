/**
* <p>Title: Permutations.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 7, 2016
* @version version 1.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Permutations</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 7, 2016
 * @time 4:44:35 PM
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        boolean[] used = new boolean[len];
        ArrayList<Integer> seq = new ArrayList<Integer>();
        permuteHelper(res, seq, used, nums);
        return res;
    }
    
    private void permuteHelper(List<List<Integer>> res, ArrayList<Integer> seq, boolean[] used, int[] nums){
    	if(seq.size() == nums.length){
    		List<Integer> seqs = new ArrayList<Integer>(seq);
    		res.add(seqs);
    		return;
    	}
    	else{
    		for(int i = 0; i < used.length; i ++){
    			if(!used[i]){
    				used[i] = true;
    				seq.add(nums[i]);
    				permuteHelper(res, seq, used, nums);
    				used[i] = false;
    				seq.remove(seq.size() - 1);
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
		Permutations so = new Permutations();
		int[] nums = {1, 2, 3};
		System.out.println(so.permute(nums));
	}
}
