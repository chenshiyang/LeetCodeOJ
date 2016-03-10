/**
* <p>Title: BinaryTreePreorderTraversal.java</p>
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
 * <p>Title: BinaryTreePreorderTraversal</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Mar 1, 2016
 * @time 11:16:39 AM
 */
public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(root != null || !stack.isEmpty()){
        	while(root != null){
        		res.add(root.val);
        		stack.push(root);
        		root = root.left;
        	}
        	root = stack.pop().right;
        }
        return res;
    }
    
    public List<Integer> preorderTraversal2(TreeNode root){
    	List<Integer> res = new ArrayList<Integer>();
    	preorderRecursive(res, root);
    	return res;
    }
    
    private void preorderRecursive(List<Integer> res, TreeNode root){
    	if(null == root){
    		return;
    	}
    	res.add(root.val);
    	preorderRecursive(res, root.left);
    	preorderRecursive(res, root.right);
    }
    
    public static void main(String[] args){
    	BinaryTreePreorderTraversal so = new BinaryTreePreorderTraversal();
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
		
		System.out.println(so.preorderTraversal(n1));
		System.out.println(so.preorderTraversal2(n1));
    }
}
