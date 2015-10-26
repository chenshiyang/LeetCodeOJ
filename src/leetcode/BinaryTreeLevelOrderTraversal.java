/**
* <p>Title: BinaryTreeLevelOrderTraversal.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月26日
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <p>Title: BinaryTreeLevelOrderTraversal</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月26日
 * @time 下午2:26:45
 */
public class BinaryTreeLevelOrderTraversal {
	
	//solution 1 : recursive.
	
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if(null == root) return lists;
        List<Integer> list = new ArrayList<Integer>();
        list.add(root.val);
        lists.add(list);
        lists = breadthFirstSearch(root, 1, lists);
        return lists;
    }
    
    /**
    * <p>Description: Assume that root's level is 1. root's children's level is 2. etc.</p>
    * @param root
    * @param level
    * @param lists
    * @return
    */
    private List<List<Integer>> breadthFirstSearch(TreeNode root, int level, List<List<Integer>> lists){
    	if(null == root || (null == root.left && null == root.right)) return lists;
    	if(lists.size() < level + 1){
    		List<Integer> list = new ArrayList<Integer>();
    		lists.add(list);
    	}
    	List<Integer> list = lists.get(level);//for the children
    	if(null != root.left) list.add(root.left.val);
    	if(null != root.right) list.add(root.right.val);
    	lists = breadthFirstSearch(root.left, level + 1, lists);
    	lists = breadthFirstSearch(root.right, level + 1, lists);
    	
    	return lists;
    }
    
    // solution 2 : iterative ,using a queue
    
    public List<List<Integer>> levelOrder2(TreeNode root){
        List<List<Integer>> nodes = new ArrayList<>();
        if(root==null){
            return nodes;
        }

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root);

        while(queue.size()!=0){

            int size = queue.size();
            List<Integer> layer_vals = new ArrayList<Integer>();

            while(size!=0){
                TreeNode temp = queue.poll();
                layer_vals.add(temp.val);

                if(temp.left!=null)queue.add(temp.left);
                if(temp.right!=null)queue.add(temp.right);

                size--;
            }
            nodes.add(layer_vals);
        }

        return nodes;
    }
    
    
    public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal so = new BinaryTreeLevelOrderTraversal();
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
		
		System.out.println(so.levelOrder2(n1));
		System.out.println(so.levelOrder2(null));
		System.out.println(so.levelOrder2(n2));
		System.out.println(so.levelOrder2(n3));
	}
}
