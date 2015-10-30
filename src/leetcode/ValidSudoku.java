/**
* <p>Title: ValidSudoku.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月28日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: ValidSudoku</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月28日
 * @time 下午10:16:49
 */
public class ValidSudoku {
	private final int BASE = 48;// '1' - 48 = 1
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkColumn(board) && checkSquare(board);
    }
    
    /**
    * <p>Description: Check if the rows satisfy sudoku's property. Ruturn true if satisfy, otherwise false</p>
    * @param board
    * @return
    */
    private boolean checkRow(char[][] board){
    	for(int i = 0; i < board.length; i ++){
    		int[] table = new int[10];//here table's type can change to boolean.
    		for(int j = 0; j < board[i].length; j ++){
    			if(board[i][j] == '.') continue;
    			if(1 == table[board[i][j] - BASE]){
    				return false;
    			} else{
    				table[board[i][j] - BASE] ++;
    			}
    		}
    	}
    	return true;
    }
    
    /**
    * <p>Description: Check if the columns satisfy sudoku's property. Ruturn true if satisfy, otherwise false</p>
    * @param board
    * @return
    */
    private boolean checkColumn(char[][] board){
    	for(int i = 0; i < board[0].length; i ++){
    		int[] table = new int[10];
    		for(int j = 0; j < board.length; j ++){
    			if(board[j][i] == '.') continue;
    			if(1 == table[board[j][i] - BASE]){
    				return false;
    			} else{
    				table[board[j][i] - BASE] ++;
    			}
    		}
    	}
    	return true;
    }
    
    private boolean checkSquare(char[][] board){
    	for(int i = 1; i < board.length; i += 3){
    		for(int j = 1; j < board.length; j += 3){
    			int[] table = new int[10];
    			for(int k = -1; k < 2; k ++){
    				for(int m = -1; m < 2; m ++){
    	    			if(board[i + k][j + m] == '.') continue;
    					if(1 == table[board[i + k][j + m] - BASE]){
    						return false;
    					} else{
    						table[board[i + k][j + m] - BASE] ++;
    					}
    				}
    			}
    		}
    	}
    	return true;
    }
    public static void main(String[] args) {
    	ValidSudoku so = new ValidSudoku();
		char[][] test = {".87654321".toCharArray(),"2........".toCharArray(),"3........".toCharArray(),
                "4........".toCharArray(),"5........".toCharArray(),"6........".toCharArray(),
                "7........".toCharArray(),"8........".toCharArray(),"9........".toCharArray()};
		char[][] test2 = {"..5.....6".toCharArray(),"....14...".toCharArray(),".........".toCharArray(),
				".....92..".toCharArray(),"5....2...".toCharArray(),".......3.".toCharArray(),
				"...54....".toCharArray(),"3.....42.".toCharArray(),"...27.6..".toCharArray()};
		char[][] test3 = {"....5..1.".toCharArray(),".4.3.....".toCharArray(),".....3..1".toCharArray(),
				"8......2.".toCharArray(),"..2.7....".toCharArray(),".15......".toCharArray(),
				".....2...".toCharArray(),".2.9.....".toCharArray(),"..4......".toCharArray()};
		char[][] test4 = {"..4...63.".toCharArray(), ".........".toCharArray(), "5......9.".toCharArray(), "...56....".toCharArray(), "4.3.....1".toCharArray(), "...7.....".toCharArray(), "...5.....".toCharArray(), ".........".toCharArray(), ".........".toCharArray()};
		System.out.println(so.isValidSudoku(test));
		System.out.println(so.isValidSudoku(test2));
		System.out.println(so.isValidSudoku(test3));
		System.out.println(so.isValidSudoku(test4));
	}
    
}
