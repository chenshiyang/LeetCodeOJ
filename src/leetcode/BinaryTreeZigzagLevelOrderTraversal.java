/**
* <p>Title: BinaryTreeZigzagLevelOrderTraversal.java</p>
* <p>Description: </p>
* @author chenshiyang
* @date Feb 22, 2016
* @version version 1.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: BinaryTreeZigzagLevelOrderTraversal</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date Feb 22, 2016
 * @time 3:47:28 PM
 */
public class BinaryTreeZigzagLevelOrderTraversal{
    /**
    * <p>Description: Solution 1. BFS</p>
    * @param root
    * @return
    */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(null == root){
        	return result;
        }
        
        List<TreeNode> startLevelNode = new ArrayList<TreeNode>();
        startLevelNode.add(root);
        List<Integer> startLevel = new ArrayList<Integer>();
        startLevel.add(root.val);
        result.add(startLevel);
        
        levelTraversal(result, startLevelNode, 1);
        
        return result;
    }
    
    private void levelTraversal(List<List<Integer>> result, List<TreeNode> lastLevelNode, int level){

    	List<Integer> currentLevel = new ArrayList<Integer>();
    	List<TreeNode> currentLevelNode = new ArrayList<TreeNode>();

    	if(level % 2 == 1){//odd
    		for(int i = lastLevelNode.size() - 1; i >= 0; i --){
    			TreeNode node = lastLevelNode.get(i);
    			if(null != node){
    				if(null != node.right){
    					currentLevel.add(node.right.val);
    					currentLevelNode.add(node.right);
    				}
    				if(null != node.left){
    					currentLevel.add(node.left.val);
    					currentLevelNode.add(node.left);
    				}
    			}
    		}
    	}
    	else{//even
    		for(int i = lastLevelNode.size() - 1; i >= 0; i --){
    			TreeNode node = lastLevelNode.get(i);
    			if(null != node){
    				if(null != node.left){
    					currentLevel.add(node.left.val);
    					currentLevelNode.add(node.left);
    				}
    				if(null != node.right){
    					currentLevel.add(node.right.val);
    					currentLevelNode.add(node.right);
    				}
    			}
    		}
    	}
    	
    	if(currentLevel.size() > 0){
        	result.add(currentLevel);
        	levelTraversal(result, currentLevelNode, level + 1);
    	}

    }
    
    /**
    * <p>Description: Solution 2. DFS</p>
    * @param root
    * @return
    */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();    	
    	traverseHelper(root, result, 0);   	
    	return result;
    }
    
    private void traverseHelper(TreeNode root, List<List<Integer>> result, int level){
    	if(null == root){
    		return;
    	}
    	
    	LinkedList list = null;
    	if(result.size() <= level){
    		list = new LinkedList<Integer>();
    		result.add(list);
    	}
    	else{
    		list = (LinkedList)result.get(level);
    	}
    	
    	if(level % 2 == 1){
    		list.addFirst(root.val);
    	}
    	else{
    		list.add(root.val);
    	}
    	
    	traverseHelper(root.left, result, level + 1);
    	traverseHelper(root.right, result, level + 1);
    }
    
    public static void main(String[] args){
    	BinaryTreeZigzagLevelOrderTraversal so = new BinaryTreeZigzagLevelOrderTraversal();
    	
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
		
		System.out.println(so.zigzagLevelOrder(n1));
		System.out.println(so.zigzagLevelOrder2(n1));
    }
}
