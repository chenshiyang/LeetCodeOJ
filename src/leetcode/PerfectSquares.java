/**
* <p>Title: PerfectSquares.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date Dec 7, 2015
* @version jdk8.0
*/
package leetcode;

import java.util.Stack;

/**
 * <p>Title: PerfectSquares</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Dec 7, 2015
 * @time 3:09:35 PM
 */
public class PerfectSquares {
    /**
     * Solution 1
     * DP
     * 
    * <p>Description: </p>
    * @param n
    * @return
    */
    public int numSquares(int n) {
        int[] dptable = new int[n + 1];//dptable[0] should be 0.
        for(int i = 1; i < dptable.length; i ++){
        	dptable[i] = i;//initialize
        	for(int j = 1; j * j <= i; j ++){
        		if(dptable[i] > dptable[i - j * j] + 1){
        			dptable[i] = dptable[i - j * j] + 1;
        		}
        	}
        }
        return dptable[n];
    }
    
    /**
     * Í¬Solution1, ´ø»ØËÝ¡£
     * 
    * <p>Description: </p>
    * @param n
    * @return
    */
    public int numSquares2(int n){
    	int[] dptable = new int[n + 1];
    	Stack<Integer> stack = new Stack<Integer>();
    	int[] maxUsed = new int[n + 1];
    	for(int i = 1; i < dptable.length; i ++){
    		dptable[i] = i;
    		maxUsed[i] = 1;
    		for(int j = 1; j * j <= i; j ++){
    			if(dptable[i - j * j] + 1 < dptable[i]){
    				dptable[i] = dptable[i - j * j] + 1;
    				maxUsed[i] = j;
    			}
    		}
    	}
    	for(int k = n; k > 0; ){
    		stack.push(maxUsed[k]);
    		k = k - maxUsed[k] * maxUsed[k];
    	}
    	System.out.print(n + " = ");
    	while(! stack.isEmpty()){
    		int i = stack.pop();
    		System.out.print(i + " * " + i );
    		if(! stack.isEmpty()){
    			System.out.print(" + ");
    		}
    	}
    	System.out.println();
    	return dptable[n];
    }
    
   /**
    * Solution 2
    * 
* <p>Description: </p>
* @param n
* @return
*/
public int numSquares3(int n) {
        while (n % 4 == 0)    n /= 4;
        if (n % 8 == 7)    return 4;
        int m = (int)Math.sqrt(n);
        if (m * m == n)    return 1;
        if (n % 2 == 0)    n >>= 1;
        if (n % 4 == 3)    return 3;
        for (int i = 3; i * i < n; i += 4)
            if (n % i == 0) {
                boolean odd = true;
                n /= i;
                while (n % i == 0) {
                    odd = !odd;
                    n /= i;
                }
                if (odd)    return 3;
            }
        return 2;
    }
    
   /**
    * Solution 3:
    * Count down from high roots to small roots using Math.sqrt(int) as a starting point.
	* Check if the root is evenly divisible with the left over of the number, if so do integer division.
	* Check if we can do better than the best answer already found before recursing.
    * https://leetcode.com/discuss/63101/java-4ms-runtime-solution
* <p>Description: </p>
* @param n
* @return
*/
public int numSquares4(int n) {
	    if (n < 1) return 0;
	    return squares(n,(int)Math.sqrt(n),0,Integer.MAX_VALUE);
	}
   
   private int squares(int n, int root,int count,int sqmin) {

   if (count>=sqmin) {
       return sqmin;
   }
   int min=0;
   for(;root>0;root--) {
       int sqr=(root*root);
       if (n < sqr) { 
           continue;
       }
       else if (n%sqr==0) { 
           min= count+ (n/sqr);
       } else {
           min= squares(n-sqr,root,count + 1,sqmin);
       }
       if (min < sqmin) {
           sqmin=min;
       }
   }
   return sqmin;
}
   
    public static void main(String[] args) {
		PerfectSquares so = new PerfectSquares();
		
		int test = 10;
		for(int i = 0; i < test; i ++){
			System.out.println(so.numSquares2(i));
		}
		
		System.out.println(so.numSquares2(63));
		System.out.println(so.numSquares3(63));
		System.out.println(so.numSquares4(63));
	}
}
