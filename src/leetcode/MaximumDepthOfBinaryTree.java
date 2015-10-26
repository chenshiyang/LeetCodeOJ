/**
* <p>Title: MaximumDepthOfBinaryTree.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月26日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: MaximumDepthOfBinaryTree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月26日
 * @time 上午11:27:33
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
    	int depth = 0;
    	if(null == root) return depth;
    	depth = Math.max(depthFirtstSearch(root.left), depthFirtstSearch(root.right)) + 1;
    	return depth;
    }
    
    private int depthFirtstSearch(TreeNode root){
    	if(null == root) return 0;
    	return Math.max(depthFirtstSearch(root.left), depthFirtstSearch(root.right)) + 1;
    }
    
    public static void main(String[] args) {
		MaximumDepthOfBinaryTree so = new MaximumDepthOfBinaryTree();
		
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
		
		System.out.println(so.maxDepth(n1) == 4);
		System.out.println(so.maxDepth(n2) == 3);
		System.out.println(so.maxDepth(n6) == 2);
		System.out.println(so.maxDepth(n5) == 1);
		System.out.println(so.maxDepth(null) == 0);
	}
}
