/**
* <p>Title: Solution.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��14��
* @version jdk8.0
*/
package first_bad_version;

/**
 * <p>Title: Solution</p>
 * <p>Description: Recursive implementation for Fist Bad Version.</p>
 * @author chenshiyang
 * @date 2015��10��14��
 * @time ����11:37:32
 */
public class Solution {
	/* The isBadVersion API is defined in the parent class VersionControl.
    boolean isBadVersion(int version); */
	private int[] versions;
	
    public int firstBadVersion(int n) {
        return find(1, n);
    }
    
    private int find(int first, int last){
    	int mid = first + (last - first) / 2;//�����������������������������mid��������ܷ���int����� �� mid = (first + last) / 2;
    	if(first == last)
    		return first;
    	else if(isBadVersion(mid)){
    		return find(first, mid);
    	}
    	else{
    		return find(mid + 1, last);
    	}
    }
    
    private boolean isBadVersion(int n){
    	return versions[n] >= 1;
    }
    
    public static void main(String[] args) {
		Solution so = new Solution();
		int[] array = {0, 1, 2, 3, 4, 5};
		so.versions = array;
		System.out.println(so.firstBadVersion(5));
	}
}
