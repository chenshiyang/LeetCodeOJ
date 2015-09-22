package two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chenshiyang
 * ʹ��һ����ϣ������������Ԫ�ص�������һ����ֵ����<element_value, element_index>���ɡ�
 * �������顣��һ��Ԫ��numbers[i], �����ϣ���д����ż�Ϊtarget - numbers[i]�ļ�ֵ�ԣ�
 * ����ҳɹ���
 * ʱ�临�Ӷ�Ϊ�� O(n).
 */
public class Solution {
    
    public int[] twoSum(int[] numbers, int target) {
    	//check null and length == 1
    	if(numbers == null || numbers.length < 2)
    		return null;
    	int[] res = new int[2];
    	Map<Integer, Integer> table = new HashMap<Integer, Integer>();
    	
    	for(int i = 0; i < numbers.length; i ++){
    		if(table.get(target - numbers[i]) != null){
    			res[0] = table.get(target - numbers[i]) + 1;//index is 1-based
    			res[1] = i + 1;
    			return res;
    		}
    		table.put(numbers[i], i);//the value as key, and the index as value.
    	}
    	//else, no satisfactory pairs.
    	return null;
    }
    
    public String showResult(int[] res){
    	if(res == null)
    		return "no satisfactory pairs.\n";
    	StringBuffer sb = new StringBuffer();
    	for(int i = 0; i < res.length; i ++){
    		sb.append(res[i]);
    		sb.append("\t");
    	}
    	sb.append("\n");
    	return sb.toString();
    }
    
    //===============test for two sum====================//
    public static void main(String[] args){
    	//test array
    	int[] a1 = { 3, 6, 4,8,99,76,33,23,65};
    	int[] a2 = {1,2,3,4,5,6,7,8,9,44,33,22};
    	Solution s = new Solution();
    	int[] r1 = s.twoSum(a1, 102);
    	System.out.println(s.showResult(r1));
    	s.showResult(r1);
    	
    	int[] r2 = s.twoSum(a2, 99);
    	System.out.println(s.showResult(r2));
    }
}
    