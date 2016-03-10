/**
* <p>Title: FirstBadVersion.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 10, 2016
* @version version 1.0
*/
package leetcode;

import first_bad_version.Solution2;

/**
 * <p>Title: FirstBadVersion</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 10, 2016
 * @time 10:35:37 AM
 */
public class FirstBadVersion {
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
		FirstBadVersion so = new FirstBadVersion();
		int[] array = {0, 1, 2, 3, 4, 5};
		so.versions = array;
		System.out.println(so.firstBadVersion(5));
	}
}
