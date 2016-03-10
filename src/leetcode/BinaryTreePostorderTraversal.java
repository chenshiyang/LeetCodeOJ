/**
* <p>Title: BinaryTreePostorderTraversal.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Mar 1, 2016
* @version version 1.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * <p>Title: BinaryTreePostorderTraversal</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 1, 2016
 * @time 11:29:10 AM
 */
public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        postorderRecursive(res, root);
        return res;
    }
    
    private void postorderRecursive(List<Integer> res, TreeNode root){
    	if(null == root){
    		return;
    	}
    	postorderRecursive(res, root.left);
    	postorderRecursive(res, root.right);
    	res.add(root.val);
    }
    
    public List<Integer> postorderTraversal2(TreeNode root){
    	List<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode node = root;
    	TreeNode prev = null;//the last visited node
    	while(node != null || !stack.isEmpty()){
    		while(node != null){
    			stack.push(node);
    			node = node.left;
    		}
    		node = stack.peek();
    		if(node.right == prev || node.right == null){//node's right child has been visited
    			res.add(node.val);
    			stack.pop();
    			prev = node;
    			node = null;
    		}
    		else{
    			node = node.right;
    		}
    	}
    	return res;
    }
    
    public static void main(String[] args) {
		BinaryTreePostorderTraversal so = new BinaryTreePostorderTraversal();
		
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n7.right = n9;
		
		System.out.println(so.postorderTraversal(n1));
		System.out.println(so.postorderTraversal2(n1));
	}
}
