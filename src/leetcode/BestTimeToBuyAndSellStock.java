/**
* <p>Title: BestTimeToBuyAndSellStock.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 8, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: BestTimeToBuyAndSellStock</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 8, 2015
 * @time 3:44:57 PM
 */
public class BestTimeToBuyAndSellStock {
    /**
     * Solution 1
     * DP
     * space: O(n)
     * time: O(n)
     * 
    * <p>Description: </p>
    * @param prices
    * @return
    */
    public int maxProfit(int[] prices) {
        if(null == prices || 1 >= prices.length) return 0;
        
        int[] profits = new int[prices.length];//��¼�ڵ�i������ʱ��������档
        //int [] buy = new int[prices.length]//���Ҫ֪�����ֵ����ôȡ�õģ�����ʹ��������飬����¼
        //��profits[i]ȡ�����ֵʱ�����Ӧ�Ĺ������ڡ�
        int maxProfit = prices[1] - prices[0];
        
        for(int i = 1; i < profits.length; i ++){
        	profits[i] = profits[i - 1] > 0? profits[i - 1] + prices[i] - prices[i - 1] : prices[i] - prices[i - 1];
        	maxProfit = profits[i] > maxProfit? profits[i] : maxProfit;
        }
        
        return maxProfit >= 0? maxProfit : 0;
    }
    
    /**
     * solution 2:  improvement of Solution 1
     * DP
     * time: O(n)
     * space: O(1)
     * 
    * <p>Description: </p>
    * @param prices
    * @return
    */
    public int maxProfit2(int[] prices){
        if(null == prices || 1 >= prices.length) return 0;
        
        int last = 0, current = 0, maxProfit = prices[1] - prices[0];
        
        for(int i = 1; i < prices.length; i ++){
        	current = last > 0? last + prices[i] - prices[i - 1] : prices[i] - prices[i - 1];
        	maxProfit = current > maxProfit? current : maxProfit;
        	last = current;
        }
        
        return maxProfit >= 0? maxProfit : 0;//0��ʾ����
    }
    
    public static void main(String[] args) {
		BestTimeToBuyAndSellStock so = new BestTimeToBuyAndSellStock();
		
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
