/**
* <p>Title: Solution3.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 25, 2015
* @version jdk8.0
*/
package longest_substring_without_repeating_characters;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: Solution3</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 25, 2015
 * @time 9:31:17 AM
 */
public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int currentLength = 0, maxLength = 0;
        int lastSmaller = 0;//��ʷ���ظ��Ӵ���������������ֵ��
        Map<Character,Integer> table = new HashMap<Character, Integer>();
        int[] locations = new int[256];
        for(int i = 0; i < locations.length; i ++){
        	locations[i] = -1;
        }
        
        for(int i = 0; i < s.length(); i ++){
        	if(locations[s.charAt(i)] == -1){//�����ǰ�Ӵ��в������ַ� s[i]
        		currentLength ++;//��ǰ�Ӵ����ȼ�1
        		locations[s.charAt(i)] = i;//��s[i]�������,����Ϊֵ
        	}
        	else{//s[i]�ڵ�ǰ�Ӵ����Ѿ����ֹ���
        		int lastIndex = locations[s.charAt(i)];
        		//��ǰ�Ӵ��ѵ���ͷ�����䳤�ȴ�����ʷ���ȣ������maxLength
        		maxLength = Math.max(maxLength, currentLength);
        		//���¿�ʼ�µ��Ӵ�, �Ӵ���lastSmaller ����һ���ַ���ʼ
        		lastSmaller = Math.max(lastSmaller, lastIndex);
        		currentLength = i - lastSmaller;
        		//����s[i]��table�е�����ֵ
        		locations[s.charAt(i)] = i;
        		
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
