/**
* <p>Title: ValidateBinarySearchTree.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 22, 2016
* @version version 1.0
*/
package leetcode;

import java.util.Stack;

/**
 * <p>Title: ValidateBinarySearchTree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Feb 22, 2016
 * @time 11:04:04 AM
 */
public class ValidateBinarySearchTree {
	public static long lastVal = Long.MIN_VALUE;
    /**
    * <p>Description: solution 1. Inorder traverse.</p>
    * @param root
    * @return
    */
    public boolean isValidBST(TreeNode root) {
    	lastVal = Long.MIN_VALUE;
        if(null == root){
        	return true;
        }
        
        if(! isValid(root.left)){//check left
        	return false;
        }
        
        if(lastVal >= root.val){//check current
        	return false;
        }
        lastVal = root.val;//opdate last visit node's val
        
        if(! isValid(root.right)){//check right
        	return false;
        }
        
        return true;//all good.       
    }
    
    private boolean isValid(TreeNode root){
        if(null == root){
        	return true;
        }
        
        if(! isValid(root.left)){//check left
        	return false;
        }
        
        if(lastVal >= root.val){//check current
        	return false;
        }
        lastVal = root.val;//opdate last visit node's val
        
        if(! isValid(root.right)){//check right
        	return false;
        }
        
        return true;//all good. 
    }
    
    /**
    * <p>Description: iterative version of solution 1.</p>
    * @param root
    * @return
    */
    public boolean isValidBST2(TreeNode root){
    	long last = Long.MIN_VALUE;
    	if(null == root){
    		return true;
    	}
    	
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	
    	while(!stack.isEmpty() || null != root){
    		if(null != root){
    			stack.push(root);
    			root = root.left;
    		}
    		else{
    			root = stack.pop();
    			if(last >= root.val){
    				return false;
    			}
    			else{
    				last = root.val;
    			}
    			root = root.right;
    		}
    	}
    	
    	return true;
    }
    
    /**
    * <p>Description: Solution 3. Using max,min range.</p>
    * @param root
    * @return
    */
    public boolean isValidBST3(TreeNode root){
    	long minVal = Long.MIN_VALUE;
    	long maxVal = Long.MAX_VALUE;
    	
    	return validateBST(root, minVal, maxVal);
    }
    
    private boolean validateBST(TreeNode root, long minVal, long maxVal){
    	if(null == root){
    		return true;
    	}
    	
    	if(minVal >= root.val || maxVal <= root.val){
    		return false;
    	}
    	
    	return validateBST(root.left, minVal, root.val) && validateBST(root.right, root.val, maxVal);
    }
    
    public static void main(String[] args){
    	ValidateBinarySearchTree so = new ValidateBinarySearchTree();
    	
		TreeNode n1 = new TreeNode(-2147483648);
		TreeNode n2 = new TreeNode(1);
		TreeNode n3 = new TreeNode(8);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(7);
		TreeNode n7 = new TreeNode(9);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(10);

//		n1.left = n2;
		n1.right = null;
		n2.left = null;
		n2.right = null;
/*		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n3.right = n7;
		n4.left = n8;
		n7.right = n9;*/
		
		System.out.println(so.isValidBST(n1));
		System.out.println(so.isValidBST(n2));
		
		System.out.println(so.isValidBST2(n1));
		System.out.println(so.isValidBST2(n2));
    }
}
