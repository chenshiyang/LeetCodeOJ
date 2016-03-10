package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
	//recursive
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(result, root);
        return result;
    }
    
    public void inorder(List<Integer> result , TreeNode root){
    	if(root == null)
    		return;
    	inorder(result , root.left);
    	result.add(root.val);
    	inorder(result, root.right);
    }
    
    //iterative, not recommend
    public List<Integer> inorderTraversal2(TreeNode root){
    	List<Integer> result = new ArrayList<Integer>();
    	if(root == null) return result;
    	Stack<TreeNode> nStack = new Stack<TreeNode>();
    	nStack.push(root);
    	while( ! nStack.isEmpty()){
			while (root != null && root.left != null) {
				nStack.push(root.left);
				root = root.left;
			}
			TreeNode node = nStack.peek();
			result.add(node.val);
			nStack.pop();
			if (node.right != null) {
				root = node.right;
				nStack.push(root);
			}
    	}
    	return result;
    }
    
    //iterative, recommend.
    public List<Integer> inorderTraversal3(TreeNode root){
    	List<Integer> result = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while(!stack.isEmpty() || root != null){
    		while(root != null){
    			stack.push(root);
    			root = root.left;
    		}
    		TreeNode node = stack.pop();
    		result.add(node.val);
    		
    		root = node.right;
    	}     	
    	return result;
    }
    
    public static void main(String[] args) {
		BinaryTreeInorderTraversal so = new BinaryTreeInorderTraversal();
		
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
		
		System.out.println(so.inorderTraversal2(n1));
		System.out.println(so.inorderTraversal3(n1));
	}
}