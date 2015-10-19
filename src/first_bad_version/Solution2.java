/**
* <p>Title: Solution2.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月15日
* @version jdk8.0
*/
package first_bad_version;

/**
 * <p>Title: Solution2</p>
 * <p>Description:  Iterative implementation for First Bad Version.</p>
 * @author chenshiyang
 * @date 2015年10月15日
 * @time 上午8:34:47
 */
public class Solution2 {
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	int[] versions;
	
    public int firstBadVersion(int n) {
        int first = 1;
        int last = n;
        while(first < last){
        	int mid = first + (last - first) / 2;
        	if(isBadVersion(mid))
        		last = mid;
        	else
        		first = mid + 1;
        }
        return first;
    }
    
    private boolean isBadVersion(int n){
    	return versions[n] >= 1;
    }
    
    public static void main(String[] args) {
		Solution2 so = new Solution2();
		int[] array = {0, 1, 2, 3, 4, 5};
		so.versions = array;
		System.out.println(so.firstBadVersion(5));
	}
}
