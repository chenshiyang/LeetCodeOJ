/**
* <p>Title: BurstBalloons.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 1, 2015
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: BurstBalloons</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 1, 2015
 * @time 8:58:13 AM
 */
public class BurstBalloons {
    /**
    * <p>Description: 方法一</p>
    * @param nums
    * @return
    */
    public int maxCoins(int[] nums) {
        return burstHelper(nums);
    }
    
    /**
     * 
     * 
    * <p>Description: 递归回溯的思想。
    * 每次从当前未刺穿的气球中（假设有N个），刺破一个，然后递归。
    * N个气球有N种刺法，选择使得收益最大的刺法。
    * 很可惜的是，这个方法不出意外地TLE了</p>
    * @param nums
    * @return
    */
    private int burstHelper(int[] nums){
    	int curMax = 0;
//    	int bestChoice = -1;
    	for(int i = 0; i < nums.length; i ++){
    		if(nums[i] >= 0){//means have not been bursted yet.
    			//burst it.
    			int tempMoney = getCoin(nums, i);//the money we get when we burst balloon i.
    			int tempValue = nums[i];
    			nums[i] = -1;
    			int money = tempMoney + burstHelper(nums);
    			
    			//recover the balloon.
    			nums[i] = tempValue;
    			if(money > curMax){
//    				bestChoice = i;
    				curMax = money;
    			}
    		}
    	}
/*    	if(bestChoice >= 0)
    		System.out.println("刺破第 " + bestChoice + "个球，其值为 " + nums[bestChoice]);*/
    	return curMax;
    }
    
    /**
    * <p>Description: 返回扎破给定气球后获得的钱数。</p>
    * @param nums 气球数组
    * @param pos 需要扎的气球位置
    * @return
    */
    private int getCoin(int[] nums, int pos){
    	int leftCoin = 1, rightCoin = 1;
    	for(int i = pos - 1; i >= 0; i --){//find left coin.
    		if(nums[i] >= 0){
    			leftCoin = nums[i];
    			break;
    		}
    	}
    	for(int i = pos + 1; i < nums.length; i ++){//find right coin.
    		if(nums[i] >= 0 ){
    			rightCoin = nums[i];
    			break;
    		}
    	}
    	//get money.
    	return leftCoin * nums[pos] * rightCoin;
    }
    
    /**
    * <p>Description: 方法二
    * 采用DP
    * DP表的第[i][j]项 表示只考虑[i, j]的气球获得的money。</p>
    * 不变式为
    * dptable[i][j] = max(k){dptable[i][k - 1] + dptable[k + 1][j] + getMoney(k)}.
    * k表示在[i][j]范围内最后刺破的为气球k。
    * @param nums
    * @return
    */
    public int maxCoins2(int[] nums) {
        if(null == nums || 0 == nums.length) return 0;
        
        int[][] dptable = new int[nums.length][nums.length];
        
        for(int len = 0; len < nums.length; len ++){//区间长度
        	for(int start = 0; start < nums.length - len; start ++){
        		int end = start + len;
        		int cur = 0;
        		for(int k = start; k <= end; k ++){//k is the last the burst in range(start, end).
        			cur = nums[k] * getValue(nums, start - 1) * getValue(nums, end + 1);
        			cur += (k - 1 < start)? 0 : dptable[start][k - 1];//k - 1 < start, means there is no range to the left of k.
        			cur += (k + 1 > end)? 0 : dptable[k + 1][end];//k + 1 > end, means there is no range to the right of k.
            		dptable[start][end] = Math.max(dptable[start][end], cur);
        		}
        	}
        }        
        return dptable[0][nums.length - 1];
    }
    
    private int getValue(int[]nums, int pos){
    	//dptable[i][k - 1] + dptable[k + 1][j]
    	if(pos < 0 || pos >= nums.length){
    		return 1;
    	}
    	else{
    		return nums[pos];
    	}
    }
    
    public static void main(String[] args) {
		BurstBalloons so = new BurstBalloons();
		int[] test1 = {3, 1, 5, 8};
		int[] test2 = {3, 5, 8};
		int[] test3 = {};
		int[] test4 = {1};
		int[] test5 = {1, 2};
		int[] test6 = {7, 9, 8, 0, 7, 1, 3, 5, 5, 2, 3};
		System.out.println(so.maxCoins(test1));
		System.out.println(so.maxCoins(test2));
		System.out.println(so.maxCoins(test3));
		System.out.println(so.maxCoins(test4));
		System.out.println(so.maxCoins(test5));
		System.out.println(so.maxCoins(test6));
		System.out.println("======================================");
		System.out.println(so.maxCoins2(test1));
		System.out.println(so.maxCoins2(test2));
		System.out.println(so.maxCoins2(test3));
		System.out.println(so.maxCoins2(test4));
		System.out.println(so.maxCoins2(test5));
		System.out.println(so.maxCoins2(test6));
	}
}
