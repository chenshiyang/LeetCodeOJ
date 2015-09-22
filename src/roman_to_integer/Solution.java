/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Sep 20, 2015
* @version jdk8.0
*/
package roman_to_integer;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Sep 20, 2015
 * @time 11:30:08 PM
 * Solution of problem: Roman to Integer.
 * Input is guaranteed to be within the range of 1 to 3999.
 */
public class Solution {
    public int romanToInt(String s) {
        char[] sarry= s.toCharArray();
        int i = 0;
        int value = 0;
        //����ǧλ
        while(i < sarry.length && sarry[i] == 'M'){
        	value += 1000;
        	i ++;
        }
        //�����λ
        while(i < sarry.length && sarry[i] == 'C'){
        	value += 100;
        	i ++;
        }
        //�ض�ΪCM +900 - 100 = +800,��Ϊ�����M ��ô�ڴ���ǧλ��ʱ��ͻ�������˵��Mǰ���и��ַ�����Ȼֻ����C��
        if(i < sarry.length && sarry[i] == 'M'){
        	value += 800;
        	i ++;
        }
        //ΪCD��D
        if(i < sarry.length && sarry[i] == 'D'){
        	if(i - 1 >= 0 && sarry[i - 1] == 'C'){
        		value += 300;
        	}
        	else{
        		value += 500;
        	}
        	i ++;
        }
        while(i < sarry.length && sarry[i] == 'C'){
        	value += 100;
        	i ++;
        }
        //����ʮλ
        while(i < sarry.length && sarry[i] == 'X'){
        	value += 10;
        	i ++;
        }
        //�ض�ΪXC 90 - 10  =80
        if(i < sarry.length && sarry[i] == 'C'){
        	value += 80;
        	i ++;
        }
        //ΪXL��L
        if(i < sarry.length && sarry[i] == 'L'){
        	if(i - 1 >= 0 && sarry[i - 1] == 'X'){
        		value += 30;
        	}
        	else{
        		value += 50;
        	}
        	i ++;
        }
        while(i < sarry.length && sarry[i] == 'X'){
        	value += 10;
        	i ++;
        }
        //�����λ
        while(i < sarry.length && sarry[i] == 'I'){
        	value += 1;
        	i ++;
        }
        //�ض�ΪIX
        if(i < sarry.length && sarry[i] == 'X'){
        	value += 8;
        	i ++;
        }
        //ΪIV ��V
        if(i < sarry.length && sarry[i] == 'V'){
        	if(i - 1 >= 0 && sarry[i - 1] == 'I'){
        		value += 3;
        	}
        	else{
        		value += 5;
        	}
        	i ++;
        }
        while(i < sarry.length && sarry[i] == 'I'){
        	value += 1;
        	i ++;
        }
        
        return value;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		String[] tests = {
				"MCMLIV",
				"MCMXC",
				"MMXIV",
				"MCMIV",
				"IV"
		};
		int[] ans = {
			1954,
			1990,
			2014,
			1904,
			4
		};
		for(int i = 0; i < tests.length; i ++){
			System.out.println(so.romanToInt(tests[i]) == ans[i]);
		}
	}
}
