/**
* <p>Title: CompareVersionNumbers.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月20日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: CompareVersionNumbers</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月20日
 * @time 下午5:02:38
 */
public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] sarry1 = version1.split("\\.");
        String[] sarry2 = version2.split("\\.");
        int i = 0;
        for(; i < sarry1.length && i < sarry2.length; i ++){
        	int num1 = Integer.parseInt(sarry1[i]);
        	int num2 = Integer.parseInt(sarry2[i]);
        	if(num1 < num2) return -1;
        	else if(num1 > num2) return 1;
        }
        for(; i < sarry1.length; i ++)
        	if(Integer.parseInt(sarry1[i]) != 0)
        		return 1;
        for(; i < sarry2.length; i ++)
        	if(Integer.parseInt(sarry2[i]) != 0)
        		return -1;
        return 0;
    }
    
    public static void main(String[] args) {
		CompareVersionNumbers so = new CompareVersionNumbers();
		String[] version1 = {"1", "1.1", "1.1.1", "1.2.12"};
		String[] version2 = {"1", "1.2", "1.1.1", "1.2.3"};
		for(int i = 0; i < version1.length; i ++){
			System.out.println(so.compareVersion(version1[i], version2[i]));
		}
	}
}
