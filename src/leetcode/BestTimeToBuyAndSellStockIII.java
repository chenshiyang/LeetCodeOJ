/**
* <p>Title: BestTimeToBuyAndSellStockIII.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 10, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: BestTimeToBuyAndSellStockIII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 10, 2015
 * @time 3:15:05 PM
 */
public class BestTimeToBuyAndSellStockIII {
/*    public int maxProfit(int[] prices) {
    	if(null == prices || prices.length <= 1){
    		return 0;
    	}
    	
        int[] diff = new int[prices.length];
        for(int i = 1; i < diff.length; i ++){
        	diff[i] = prices[i] - prices[i - 1];
        }
        
        int[] first = new int[prices.length];//first transaction, first[i] means  [0, i]
        int[] second = new int[prices.length];//second transaction, second [i] means [i, prices.length - 1]
        
        for(int i = 1; i < first.length; i ++){//first[0] should be 0
        	first[i] = first[i - 1] > 0? first[i - 1] + diff[i] : diff[i];
        }
        for(int i = second.length - 2; i > 0; i --){//second[second.length -1] should be 0
        	second[i] = second
        }
    }*/
    
    public int maxProfit(int[] prices) {
    	if(null == prices || prices.length <= 1){
    		return 0;
    	}
    	
    	//forward pass
    	int[] forward1 = new int[prices.length];//forward1[i]记录在第i天卖掉的最大收益
    	int min = prices[0];
    	for(int i = 1; i < forward1.length; i ++){
    		forward1[i] = prices[i] - min;
    		min = Math.min(min, prices[i]);
    	}
    	int[] forward2 = new int[prices.length];//forward2[i]记录在第i天及之前卖掉的最大收益
    	for(int i = 1; i < forward2.length; i ++){
    		forward2[i] = Math.max(forward2[i - 1], forward1[i]);
    	}
    	
    	//backward pass
    	int[] backward1 = new int[prices.length];//backward[i]记录在第i天买入的最大收益
    	int max = prices[prices.length - 1];
    	for(int i = backward1.length - 2; i >= 0; i --){
    		backward1[i] = max - prices[i];
    		max = Math.max(max, prices[i]);
    	}
    	int[] backward2 = new int[prices.length];//backward2[i]记录在第i天及之后买入的最大收益
    	for(int i = backward2.length - 2; i >= 0; i --){
    		backward2[i] = Math.max(backward2[i + 1], backward1[i]);
    	}
    	
    	//get max combination
    	int maxProfit = forward2[forward2.length - 1];//initialize as only one transaction.
    	for(int i = 0; i < forward1.length - 1; i ++){
    		maxProfit = Math.max(maxProfit, forward2[i] + backward2[i + 1]);
    	}
    	return maxProfit;
    }
    
    /**
     * Solution 2
     * 
    * <p>Description: </p>
    * @param prices
    * @return
    */
    public int maxProfit2(int[] prices) {
    	if(null == prices || prices.length <= 1){
    		return 0;
    	}
    	
    	int profit1 = 0;//profit after buying and selling the first stock.
    	int	profit2 = 0;//After selling the second tock, the money left.
    	int lowest = Integer.MAX_VALUE;//the lowest price of the first stock.
    	int moneyLeft = Integer.MIN_VALUE;//largest money left after buying the second stock.
    	
    	for(int i = 0; i < prices.length; i ++){
    		profit1 = Math.max(profit1, prices[i] - lowest);
    		lowest = Math.min(lowest, prices[i]);
    		moneyLeft = Math.max(moneyLeft, profit1 - prices[i]);
    		profit2 = Math.max(profit2, prices[i] + moneyLeft);
    	}
    	
    	return profit2;
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStockIII so = new BestTimeToBuyAndSellStockIII();
		int[] test1 = null;
		int[] test2 = {3};
		int[] test3 = {2, 1};
		int[] test4 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
		
		System.out.println(so.maxProfit(test1));
		System.out.println(so.maxProfit(test2));
		System.out.println(so.maxProfit(test3));
		System.out.println(so.maxProfit(test4));
	}
}
