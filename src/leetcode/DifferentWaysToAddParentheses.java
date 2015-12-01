/**
* <p>Title: DifferentWaysToAddParentheses.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Nov 30, 2015
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: DifferentWaysToAddParentheses
 * 使用动态规划解决这个问题</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Nov 30, 2015
 * @time 11:29:16 PM
 */
public class DifferentWaysToAddParentheses {
	List<Integer> numbers = new ArrayList<Integer>();
	List<Character> operators = new ArrayList<Character>();
    List<List<List<Integer>>> dptable = new ArrayList<List<List<Integer>>>();
	
    public List<Integer> diffWaysToCompute(String input) {
    	numbers = new ArrayList<Integer>();
    	operators = new ArrayList<Character>();
        dptable = new ArrayList<List<List<Integer>>>();
    	//first, parse the input string.
    	parseString(input);
    	
    	System.out.println("numbers is " + numbers);
    	System.out.println("operators is " + operators);
    	
    	if(1 == numbers.size()){
    		return numbers;
    	}  	
    	//initialize the list.
        for(int i = 0; i < numbers.size(); i ++){
        	List<List<Integer>> row = new ArrayList<List<Integer>>();{
        		for(int j = 0; j < numbers.size(); j ++){
        			List<Integer> column = new ArrayList<Integer>();
        			row.add(column);
        		}
        	}
        	dptable.add(row);
        }
        //caculate.
        caculateAll();
        return dptable.get(0).get(numbers.size() - 1);
    }
    
    private void caculateAll(){
    	for(int dist = 0; dist < numbers.size(); dist ++){
    		for(int i = 0; i < numbers.size() - dist; i ++){
    			if(0 == dist){
    				dptable.get(i).get(i + dist).add(numbers.get(i));
    			}
    			else{
    				for(int j = 0; j < dist; j ++){
    					mergeResult(dptable.get(i).get(i + j), dptable.get(i + j + 1).get(i + dist), operators.get(i + j), i, dist);
    				}
    			}
    		}
    	}
    }
    
    private void mergeResult(List<Integer> nums1, List<Integer> nums2, char op, int pos, int dist){
    	for(int i = 0; i < nums1.size(); i ++){
    		for(int j = 0; j < nums2.size(); j ++){
    			int res = caculate(nums1.get(i), nums2.get(j), op);
    			dptable.get(pos).get(pos + dist).add(res);
    		}
    	}
    }
    
    private int caculate(int num1, int num2, char op){
    	if('+' == op){
    		return num1 + num2;
    	}
    	else if('-' == op){
    		return num1 - num2;
    	}
    	else{
    		return num1 * num2;
    	}
    }
    
    private void parseString(String input){
    	int pre = 0, cur = 0;
    	
    	while(cur < input.length()){
    		char c = input.charAt(cur);
    		if(c == '+' || c == '-' || c == '*'){
    			numbers.add(Integer.parseInt(input.substring(pre, cur)));
    			operators.add(c);
    			pre = cur + 1;
    		}
    		cur ++;
    	}
    	//add the last number
    	numbers.add(Integer.parseInt(input.substring(pre, cur)));
    }
    
    public static void main(String[] args) {
		DifferentWaysToAddParentheses so = new DifferentWaysToAddParentheses();
		String test1 = "2-1-1";
		String test2 = "2*3-4*5";
		String test3 = "123";
		
		System.out.println(so.diffWaysToCompute(test1));
		System.out.println(so.diffWaysToCompute(test2));
		System.out.println(so.diffWaysToCompute(test3));
	}
}
