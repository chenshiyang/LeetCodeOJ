/**
* <p>Title: PathSum.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月21日
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: PathSum</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月21日
 * @time 上午9:16:48
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null == root) return false;
        int current = 0;
        
        return depthFirstSearch(root, current, sum);       
    }
    
    private boolean depthFirstSearch(TreeNode node, int current, int sum){
    	
    	//if leaf and current + node.val == sum
    	if(node.left == null && node.right == null && current + node.val == sum)
    		return true;

    	if(node.left != null){
    		if(depthFirstSearch(node.left, current + node.val, sum))
    			return true;
    	}
    	if(node.right != null)
    		return depthFirstSearch(node.right, current + node.val, sum);
    	//leaf, but current + node.val != sum
    	return false;
    }
    
    public static void main(String[] args) {
		PathSum so = new PathSum();
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
		
		System.out.println(so.hasPathSum(n1, 10));
		System.out.println(so.hasPathSum(n1, 8));
		System.out.println(so.hasPathSum(n1, 16));
		System.out.println(so.hasPathSum(null, 0));
		System.out.println(so.hasPathSum(n1, 7));
		System.out.println(so.hasPathSum(n1, 4));
		System.out.println(so.hasPathSum(n11, -5));
	}
}
