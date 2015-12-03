/**
* <p>Title: MaximalSquare.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 3, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: MaximalSquare</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 3, 2015
 * @time 11:05:36 AM
 */
public class MaximalSquare {
    /**
     * Solution 1
     * DP 
     * time: O(n^3)
     * space: O(n^2), 可以优化到O(n)
     * 最优子结构为：
     * dptable[i][j]：以[i][j]为右下角的正方形的边长
     * 	= [i- 1][j- 1]的边长 + 1： 当满足matrix[i][j] == '1' 且点[i][j]的左边和上边都为'1'
    * <p>Description: </p>
    * @param matrix
    * @return
    */
    public int maximalSquare(char[][] matrix) {
    	if(null == matrix || 0 == matrix.length) return 0;
    	
    	int m = matrix.length, n = matrix[0].length;
    	//dptable[i][j] 表示以matrix[i][j]为右下角的正方形的最大边长
    	int[][] dptable = new int[m][n];
    	int maxLen = 0;
    	
    	for(int i = 0; i < m; i ++){
    		for(int j = 0; j < n; j ++){
    			if('0' == matrix[i][j]){
    				dptable[i][j] = 0;
    				continue;
    			}
    			//else dptable[i][j] == '1'
    			if(0 == i || 0 == j){
    				dptable[i][j] = 1;
    			}
    			else{
    				int lastLen = dptable[i - 1][j - 1];// lastLen >= 0
    				int curLen = 1;;
    				for(int k = 1; k <= lastLen; k ++){
    					if('1' == matrix[i - k][j] && '1' == matrix[i][j - k]){//如果maxtirx[i][j]的左边或上边为1
    						curLen ++;
    					}
    					else{
    						break;
    					}
    				}
    				dptable[i][j] = curLen;
    			}
				maxLen = Math.max(maxLen, dptable[i][j]);
    		}
    	}
    	
/*    	for(int i = 0; i < dptable.length; i ++){
    		for(int j = 0; j < dptable[0].length; j ++){
    			maxLen = Math.max(maxLen, dptable[i][j]);
    		}
    	}*/
    	return maxLen * maxLen;
    }
    
    /**
     * Solution 2
     * DP
     * 
    * <p>Description: </p>
    * @param matrix
    * @return
    */
    public int maximalSquare2(char[][] matrix) {
    	if(null == matrix || 0 == matrix.length) return 0;
    	
    	int m = matrix.length, n = matrix[0].length;
    	//dptable[i][j] 表示以matrix[i][j]为右下角的正方形的最大边长
    	int[][] dptable = new int[m][n];
    	int maxLen = 0;
    	
    	for(int i = 0; i < m; i ++){
    		for(int j = 0; j < n; j ++){
    			if('0' == matrix[i][j]){
    				dptable[i][j] = 0;
    				continue;
    			}
    			//else dptable[i][j] == '1'
    			if(0 == i || 0 == j){
    				dptable[i][j] = 1;
    			}
    			else{
    				int tempMin = Math.min(dptable[i - 1][j], dptable[i][j - 1]);
    				dptable[i][j] = Math.min(tempMin, dptable[i - 1][j - 1]) + 1;
    			}
				maxLen = Math.max(maxLen, dptable[i][j]);
    		}
    	}
    	
    	return maxLen * maxLen;
    }
    
    public static void main(String[] args) {
		MaximalSquare so = new MaximalSquare();
		char[][] test1 = null;
		char[][] test2 = {};
		char[][] test3 = {
				"10100".toCharArray(),
				"10111".toCharArray(),
				"11111".toCharArray(),
				"10010".toCharArray()
		};
		char[][] test4 = {"1".toCharArray()};
		char[][] test5 = {"0".toCharArray()};
		char[][] test6 = {
				"101001".toCharArray(),
				"101111".toCharArray(),
				"111111".toCharArray(),
				"100101".toCharArray()
		};
		char[][] test7 = {
				"0001".toCharArray(),
				"1101".toCharArray(),
				"1111".toCharArray(),
				"0111".toCharArray(),
				"0111".toCharArray()
				
		};
		System.out.println(so.maximalSquare2(test1));
		System.out.println(so.maximalSquare2(test2));
		System.out.println(so.maximalSquare2(test3));
		System.out.println(so.maximalSquare2(test4));
		System.out.println(so.maximalSquare2(test5));
		System.out.println(so.maximalSquare2(test6));
		System.out.println(so.maximalSquare2(test7));
	}
}
