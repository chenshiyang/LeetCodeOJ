/**
* <p>Title: MinimumDepthOfBinaryTree.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月21日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: MinimumDepthOfBinaryTree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月21日
 * @time 上午10:17:19
 */
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if(null == root) return 0;
        int currentDepth = 0, min = Integer.MAX_VALUE;
        return depthFirstSearch(root, currentDepth, min);
    }
    
    private int depthFirstSearch(TreeNode node, int currentDepth, int min){
    	currentDepth += 1;
    	if(currentDepth > min) return min;
    	//if leaf
    	if(null == node.left && null == node.right)
    		return currentDepth < min ? currentDepth : min;
    	if(null != node.left){
    		min = Math.min(min, depthFirstSearch(node.left, currentDepth, min));
    	}
    	if(null != node.right){
    		min = Math.min(min, depthFirstSearch(node.right, currentDepth, min));
    	}
    	return min;
    }
    
    public static void main(String[] args) {
		MinimumDepthOfBinaryTree so = new MinimumDepthOfBinaryTree();
		
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
		
		TreeNode n11 = new TreeNode(-2);
		TreeNode n12 = new TreeNode(-3);
		n11.right = n12;
		
		System.out.println(so.minDepth(null));
	}
}
