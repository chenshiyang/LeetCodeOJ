/**
* <p>Title: SummaryRanges.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月17日
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: SummaryRanges</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月17日
 * @time 下午11:32:05
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
    	ArrayList<String> ranges = new ArrayList<String>();
    	
    	if(nums == null || nums.length == 0) return ranges;
    	if(nums.length == 1){
    		ranges.add(nums[0] + "");
    		return ranges;
    	}
    	int start = 0;
    	int end = 0;
    	
    	for(int i = 1; i < nums.length; i ++ ){
    		while(i < nums.length && nums[i] == nums[i - 1] + 1){
    			i ++;
    			end ++;
    		}
    		// nums[i] != nums[i - 1] || i = nums.length
    		ranges.add(generateRange(start, end, nums));
    		start = i;
    		end = i;
    		if(i == nums.length - 1)//如果i是最后一个，需要在这里特殊处理，否则到for循环后i又加1，就会漏算最后一个。
    			ranges.add(generateRange(start, end, nums));
    	}
    	return ranges;
    }
    
    private String generateRange(int start, int end, int[] nums){
    	if(start == end)
    		return nums[start] + "";
    	else
    		return nums[start] + "->" + nums[end];
    }
    
    public static void main(String[] args) {
		SummaryRanges sr = new SummaryRanges();
		int[] test0 = null;
		int[] test1 = {};
		int[] test2 = {1};
		int[] test3 = {1, 2, 3};
		int[] test4 = {1, 3, 4, 5, 6, 8, 9, 10, 11, 13};
		
		System.out.println(sr.summaryRanges(test0));
		System.out.println(sr.summaryRanges(test1));
		System.out.println(sr.summaryRanges(test2));
		System.out.println(sr.summaryRanges(test3));
		System.out.println(sr.summaryRanges(test4));
	}
}
