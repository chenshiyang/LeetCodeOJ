/**
* <p>Title: SameTree.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月26日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: SameTree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月26日
 * @time 下午4:11:24
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return same(p, q);
    }
    
    private boolean same(TreeNode left, TreeNode right){
    	if(null == left && null == right) return true;
    	if(null == left || null == right || left.val != right.val) return false;
    	
    	return same(left.left, right.left) && same(left.right, right.right);
    }
    
    public static void main(String[] args) {
		SameTree so = new SameTree();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n9;
		n4.right = n7;
		n6.left = n10;
		n6.right = n8;
		
		System.out.println(so.isSameTree(n1, n1) == true);
		System.out.println(so.isSameTree(null, null) == true);
		System.out.println(so.isSameTree(n1, n2) == false);
	}
}
