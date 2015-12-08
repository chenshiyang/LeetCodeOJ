/**
* <p>Title: BestTimeToBuyAndSellStockWithCooldown.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 8, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: BestTimeToBuyAndSellStockWithCooldown</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 8, 2015
 * @time 5:33:43 PM
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    /**
     * The idea is as follows:

	First, think about what we can do on day i? You either have one stock or 
	you don't on day i. For each case, you have two options, making a total 
	of four possible actions on day i:

		you have 1 stock and you sell it
		you have 1 stock and you do nothing
		you have 0 stock and you buy stock i
		you have 0 stock and you do nothing
	 As you can imagine, these four actions are correlated between day i-1 and day i.
	 For example, if you take action 1 on day i, you then have either taken action 2 
	 or 3 on day i-1 but not 1 or 4. In precise, two consecutive days are related as follows:

		if you take action 1 on day i ==> you have either taken action 2 or 3 on day i-1
		if you take action 2 on day i ==> you have either taken action 2 or 3 on day i-1
		if you take action 3 on day i ==> you can only take action 4 on day i-1 (you can not sell on day i-1 due to cool down)
		if you take action 4 on day i ==> you have either taken action 1 or 4 on day i-1
    * <p>Description: </p>
    * @param prices
    * @return
    */
    public int maxProfit(int[] prices) {
    	if(null == prices|| 1 >= prices.length) return 0;
    	
    	int hasOneSell = 0;//has one and sell it.
    	int hasOneNothing = -prices[0];//has one and do nothing.
    	int hasZeroBuy = -prices[0];//has zero and buy one.
    	int hasZeroNothing = 0;//has zero and do nothing.
    	
    	for(int i = 1; i < prices.length; i ++){
    		int temp1 = hasOneSell;
    		hasOneSell = Math.max(hasOneNothing, hasZeroBuy) + prices[i];
    		hasOneNothing = Math.max(hasOneNothing, hasZeroBuy);
    		hasZeroBuy = hasZeroNothing - prices[i];//because cd
    		hasZeroNothing = Math.max(hasZeroNothing, temp1);
    	}
    	return Math.max(hasOneSell, hasZeroNothing);
    }
    
    /**
     * Solution 2 状态机
     * 参考这里：https://leetcode.com/discuss/72030/share-my-dp-solution-by-state-machine-thinking
     *  定义三个状态：
     *  s0 : 没有股票，并且可买
     *  s1 ：持有股票
     *  s2 : 没有股票，但不可买
     *  
     *  状态转化过程如下： s0->s1->2->s0, 每个状态都有一个环指向自身。
     * 
    * <p>Description: </p>
    * @param prices
    * @return
    */
    public int maxProfit2(int[] prices) {
    	if(null == prices|| 1 >= prices.length) return 0;
    	
    	int s0 = 0, s1 = -prices[0], s2 = 0;//对应3个状态时的profit
    	
    	for(int i = 1; i < prices.length; i ++){
    		int s0Temp = s0;
    		s0 = Math.max(s0, s2);
    		s2 = Math.max(s1 + prices[i], s2);
    		s1 = Math.max(s0Temp - prices[i], s1);
    	}
    	return Math.max(s0, s2);
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStockWithCooldown so = new BestTimeToBuyAndSellStockWithCooldown();
		
		int[] test1 = {};
		int[] test2 = {4};
		int[] test3 = null;
		int[] test4 = {8, 9, 8, 10, 11, 8, 9};
		int[] test5 = {1, 4, 2, 5, 3, 2, 4, 5, 3};
		int[] test6 = {2, 1};
		int[] test7 = {2, 1, 4};
		
		System.out.println(so.maxProfit2(test1));
		System.out.println(so.maxProfit2(test2));
		System.out.println(so.maxProfit2(test3));
		System.out.println(so.maxProfit2(test4));
		System.out.println(so.maxProfit2(test5));
		System.out.println(so.maxProfit2(test6));
		System.out.println(so.maxProfit2(test7));
	}
}
