/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��14��
* @version jdk8.0
*/
package move_zeroes;

/**
 * <p>Title: Solution</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��14��
 * @time ����7:04:10
 */
public class Solution {
    public void moveZeroes(int[] nums) {
    	if(nums == null)
    		return;
        int zeroPos = -1;//�Ѿ��������ķ���Ԫ�غ�ĵ�һ����λ
        int current = 0;
        int zeroCount = 0;
        for(; current < nums.length; current ++){
        	if(zeroPos < current){
        		//move current element into zeroPos
        		if(nums[current] != 0){
        			if(zeroPos >= 0){
               			nums[zeroPos] = nums[current];
               			zeroPos ++;
        			}
        		}
        		else{//nums[current] == 0
        			zeroCount ++;
        			if(zeroPos < 0){
        				zeroPos = current;
        			}
        		}
        	}
        }
        for(int i = 0; i < zeroCount; i ++){
        	nums[nums.length - 1 - i] = 0;
        }
        return;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		int[] test1 = {0, 1, 0, 2, 3, 0, 4, 5, 6};
		int[] test2 = {};
		int[] test3 = {0, 1};
		int[] test4 = {0, 1, 0, 3, 12};
		so.moveZeroes(test4);
		for(int i = 0; i < test4.length; i ++){
			System.out.println(test4[i]);
		}
	}
}
