/**
* <p>Title: SearchA2DMatrixII.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Nov 30, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: SearchA2DMatrixII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Nov 30, 2015
 * @time 9:15:20 PM
 */
public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = matrix.length;
        int columnNum = matrix[0].length;
        
        int row = 0, column = columnNum - 1;
        while(row <= rowNum - 1 && column >= 0){
        	if(matrix[row][column] == target){
        		return true;
        	}
        	else if(matrix[row][column] < target){//then row number increase
        		row ++;
        	}
        	else{//matrix[row][column] > target, column numer decrease
        		column --;
        	}
        }
        return false;
    }
    
    public static void main(String[] args) {
		int[][] test = {
				{1, 3, 4},
				{2, 4, 6},
				{5, 6, 9}
				};
		
		SearchA2DMatrixII so = new SearchA2DMatrixII();
		System.out.println(so.searchMatrix(test, 1) == true);
		System.out.println(so.searchMatrix(test, 7) == false);
		System.out.println(so.searchMatrix(test, 4) == true);
		System.out.println(so.searchMatrix(test, 0) == false);
		System.out.println(so.searchMatrix(test, 5) == true);
		System.out.println(so.searchMatrix(test, 8) == false);
		System.out.println(so.searchMatrix(test, 9) == true);
	}
}
