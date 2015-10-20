/**
* <p>Title: CountPrimes.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月19日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: CountPrimes</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月19日
 * @time 下午4:32:41
 */
public class CountPrimes {
	//solution 1 :
/*    public int countPrimes(int n) {
        if(n < 3) return 0;
        int count = 1;//n >= 3, at least have 2 as odd.
        for(int i = 1; i < n; i += 2){//only check odd.
        	if(isPrime(i))
        		count ++;
        }
        return count;
    }
    
    private boolean isPrime(int x){
    	if(x < 2) return false;
    	for(int i = 2; i * i <= x; i ++){
    		if(x % i == 0)
    			return false;
    	}
    	return true;
    }*/
    
	//solution 2 :
	public int countPrimes(int n) {
		   boolean[] isPrime = new boolean[n];
		   for (int i = 2; i < n; i++) {
		      isPrime[i] = true;
		   }
		   // Loop's ending condition is i * i < n instead of i < sqrt(n)
		   // to avoid repeatedly calling an expensive function sqrt().
		   for (int i = 2; i * i < n; i++) {
		      if (!isPrime[i]) continue;
		      for (int j = i * i; j < n; j += i) {
		         isPrime[j] = false;
		      }
		   }
		   int count = 0;
		   for (int i = 2; i < n; i++) {
		      if (isPrime[i]) count++;
		   }
		   return count;
		}
	
    public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		for(int i = 0; i < 20; i ++){
			System.out.println(i + " " + cp.countPrimes(i));
		}
	}
}
