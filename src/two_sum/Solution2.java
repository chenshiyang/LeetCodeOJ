/**
* <p>Title: Solution2.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 22, 2015
* @version jdk8.0
*/
package two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Solution2</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 22, 2015
 * @time 2:49:31 PM
 * 
 * ��һ�ֽⷨ��
 * ���ȣ��������飬ʹ������ʱ�临�Ӷ�ΪO(nlogn).
 * Ȼ����������˿�ʼƥ�䡣
 * �������֮�͵���target. bingo,�ҵ���
 * �������֮�ʹ���target.���Ҷ�����һλ
 * �������֮��С��target�����������һλ��
 * 
 * ƥ����ʱO(n)��
 * �㷨����ʱΪO(nlogn)��
 * 
 * �����㷨�ľ�������Ҫ�������в�������ͬ��Ԫ�أ������ڽ�����ϣ��ʱ���Ḳ��ǰһ����ͬԪ��
 * �ĵ�ַ��
 * ��Input: [0, 4, 3, 0] 0
 * Output: [4, 4]
 * Expected: [1, 4]
 * 
 * ����㷨��leetcode��û��ͨ��������Ϊһ��˼·��
 */
public class Solution2 {
	public int[] twoSum(int[] numbers, int target){
		if(numbers == null || numbers.length < 2)
			return null;
		//==������һ����ϣ���סÿ��Ԫ���������е�λ��
		Map<Integer, Integer> table = new HashMap<Integer, Integer>();
		for(int i = 0; i < numbers.length; i ++){
			table.put(numbers[i], i);
		}
		int[] res = new int[2];
		int left = 0, right = numbers.length - 1;
		Arrays.sort(numbers);
		while(left < right){
			if(numbers[left] + numbers[right] == target){
				res[0] = table.get(numbers[left]) + 1;
				res[1] = table.get(numbers[right]) + 1;
				if(res[0] > res[1]){
					res[0] ^= res[1] ^= res[0] ^= res[1];//swap res[0] and res[1]
				}
				return res;
			}
			else if(numbers[left] + numbers[right] > target){
				right --;
			}
			else {
				left ++;
			}
		}
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
	    	Solution2 s = new Solution2();
	    	int[] r1 = s.twoSum(a1, 102);
	    	System.out.println(s.showResult(r1));
	    	s.showResult(r1);
	    	
	    	int[] r2 = s.twoSum(a2, 99);
	    	System.out.println(s.showResult(r2));
	    }
}
