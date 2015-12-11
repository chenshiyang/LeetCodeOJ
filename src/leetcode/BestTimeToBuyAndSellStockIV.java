/**
* <p>Title: BestTimeToBuyAndSellStockIV.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 11, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: BestTimeToBuyAndSellStockIV</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 11, 2015
 * @time 3:25:26 PM
 */
public class BestTimeToBuyAndSellStockIV {
    /**
     * Solution 1
     * DP
     * 
    * <p>Description: </p>
    * @param k
    * @param prices
    * @return
    */
    public int maxProfit(int k, int[] prices) {
    	if(null == prices || prices.length <= 1){
    		return 0;
    	}
    	
    	//happy case.
        if(k * 2 >= prices.length){
        	int profit = 0;
        	for(int i = 1; i < prices.length; i ++){
        		profit += prices[i] > prices[i - 1]? prices[i] - prices[i - 1] : 0;
        	}
        	return profit;
        }
        
        int[] lowestPrices = new int[k + 1];//the ith element means the lowest buying price of the ith transaction
        for(int i = 0; i < lowestPrices.length; i ++){
        	lowestPrices[i] = Integer.MAX_VALUE;
        }
        int[] profit = new int[k + 1];//the ith element means the maximum profit after the ith transaction
        for(int i = 0; i < prices.length; i ++){
        	for(int j = 1; j < lowestPrices.length; j ++){
        		lowestPrices[j] = Math.min(lowestPrices[j], prices[i] - profit[j - 1]);
        		profit[j] = Math.max(profit[j], prices[i] - lowestPrices[j]);
        	}
        }
        return profit[k];
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStockIV so = new BestTimeToBuyAndSellStockIV();
		int[] test1 = null;
		int[] test2 = {};
		int[] test3 = {3};
		int[] test4 = {2, 1};
		int[] test5 = {1, 2, 4, 2, 5, 7, 2, 4, 9, 0};
		
		System.out.println(so.maxProfit(3, test1));
		System.out.println(so.maxProfit(3, test2));
		System.out.println(so.maxProfit(3, test3));
		System.out.println(so.maxProfit(3, test4));
		System.out.println(so.maxProfit(1, test5));
		System.out.println(so.maxProfit(2, test5));
		System.out.println(so.maxProfit(3, test5));
		System.out.println(so.maxProfit(4, test5));
		System.out.println(so.maxProfit(5, test5));
	}
}
