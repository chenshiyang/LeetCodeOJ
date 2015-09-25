/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 24, 2015
* @version jdk8.0
*/
package longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;


/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
	 * �㷨:
	 * ��������ַ�����ת�����ַ�����
	 * 1.����һ���ַ�
	 * 2.�����ַ�û�г�����hashmap�У�����ַ����µģ�
	 * 	����ǰ���ȼ�1���������ַ�ֵ������������hashmap��
	 *   �����ַ�������hashmap�У�˵�����ַ���ǰ����ֹ�����Ҫ����
	 *   	������ʷ������ȣ�
	 *   	���㵱ǰ�µĳ��ȣ����㷽�����£�
	 *   	ͨ�����뷨���õ�ǰ�������ַ���������ȥ���ַ�����һ��������������hashmap�е�ֵ������
	 *   	�����뷨�������⡣���ַ�����lksdj;a;hj;l���������ǵڶ��ζ��� j��ʱ����j�ĵ�ǰ����9 -j��hashmap
	 *   	�е�ֵ4 ����5�������Ǵ�ģ���Ϊ����j�м������һ����;�����ظ��Ӵ��������;�����������أ�����Ҫע�⵽
	 *   	����ظ��ġ�;����ʵ����һ�ε� ������ַ�(�ڶ���";")������hashmap��(map�е��ǵ�һ��";")�������������ģ�������ǿ�����ÿ�ζ���
	 *   	�ַ��������ַ�������hashmap�У������ǵڶ���if����������ͼ�������hashmap��ֵ�������Ľ�С���Ǹ�
	 *   	������������������һ��lastSmaller ����¼(last duplicate char's smaller index)��lastSmaller ������һ�ν�С����˼��
	 *   	������¼��һ�γ����ظ����Ǹ��ַ��Ľ�С��������������ַ���Ϊ������;����lastSmaller
	 *   	Ϊ5��ע���ˣ���Ϊ5>4��4Ϊj��hashmapֵ�������ǵĵ�ǰ�Ӵ����Ȳ�ӦΪ9-4����ӦΪ9-5�����ܱ�֤j�ͣ���
	 *   	�����ظ������ǣ���lastSmaller<4�أ� ����ע�⵽��ʱ�򣻶�j���Ӵ�����û��Ӱ�죬����ǰ�Ӵ�����Ϊ9-4=5.����
	 *   	�ǣ���ΪlastSmaller<4����������Ҫ����lastSmaller,ʹ�ñ�֤lastSmaller��**��ʷ��**�ظ��Ӵ����С�����е�**���ֵ**��
	 *   	�����굱ǰ�µ��Ӵ����Ⱥ����ǻ���Ҫ����hashmap������ǰ�ַ��ľ�������������������
	 * 3.�����ʷ���Ⱥ͵�ǰ���ȣ������е����ֵ��Ϊ�����
	 * 
	 * ����㷨�����solution2���ŵ��ǣ�����ÿ����һ���ַ����͸���maxLength������ҪС��**Ƕ���ظ�**�����塣
	 * �����ٶȱ�solution2������hashmap����array���ٶȾͱ�solution2���ˣ���solution3�� ʹ��hashmap��Ӱ���ٶȣ����
	 * ����֡�
 * @author chenshiyang
 * @date Sep 24, 2015
 * @time 10:53:46 PM
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int currentLength = 0, maxLength = 0;
        int lastSmaller = 0;//��ʷ���ظ��Ӵ���������������ֵ��
        Map<Character,Integer> table = new HashMap<Character, Integer>();
        
        for(int i = 0; i < s.length(); i ++){
        	if(table.get(s.charAt(i)) == null){//�����ǰ�Ӵ��в������ַ� s[i]
        		currentLength ++;//��ǰ�Ӵ����ȼ�1
        		table.put(s.charAt(i), i);//��s[i]������У��ַ�Ϊ��������Ϊֵ
        	}
        	else{//s[i]�ڵ�ǰ�Ӵ����Ѿ����ֹ���
        		int lastIndex = table.get(s.charAt(i));
        		//��ǰ�Ӵ��ѵ���ͷ�����䳤�ȴ�����ʷ���ȣ������maxLength
        		maxLength = Math.max(maxLength, currentLength);
        		//���¿�ʼ�µ��Ӵ�, �Ӵ���lastSmaller ����һ���ַ���ʼ
        		lastSmaller = Math.max(lastSmaller, lastIndex);
        		currentLength = i - lastSmaller;
        		//����s[i]��table�е�����ֵ
        		table.put(s.charAt(i), i);
        		
        	}
        }
        maxLength = Math.max(maxLength, currentLength);
    	return maxLength;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		String[] s1 ={ "",
		 "a",
		"ab",
		 "aba",
		 "aa",
		"lksdj;a;hj;lkdfsj;erugahflhlkjdfha",
		"abcdefghijklmnopqrstuvwxyzal;kjgaerghkjdsghlkdsgjh",
		"abcdaefghi",
		";jglkjdg;ai jt;iajmndkfj ghqqqqwertyuiopasdfghjkllllll"};
		long current = System.currentTimeMillis();
		for(int i = 0 ; i < 9 ; i ++){
			System.out.println(so.lengthOfLongestSubstring(s1[i]));
		}
		System.out.println("time used : " + (System.currentTimeMillis() - current));
	}
}
