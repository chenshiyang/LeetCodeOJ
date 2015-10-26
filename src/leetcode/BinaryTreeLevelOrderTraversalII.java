/**
* <p>Title: BinaryTreeLevelOrderTraversalII.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015年10月22日
* @version jdk8.0
*/
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: BinaryTreeLevelOrderTraversalII</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015年10月22日
 * @time 下午4:55:03
 */
public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<List<Integer>> lists = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(null == root)
        	return lists;
        list.add(root.val);
        lists.add(list);
        lists = breadthFirstSearch(root, 1, lists);
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i = lists.size() - 1; i >= 0; i --){
        	result.add(lists.get(i));
        }
        return result;
    }
    
    private ArrayList<List<Integer>> breadthFirstSearch(TreeNode root, int level, ArrayList<List<Integer>> lists){
    	if(null == root.left && null == root.right) return lists;
    	
    	if(lists.size() < level + 1){//如果root的孩子的这一层还没遍历过
    		ArrayList<Integer> list = new ArrayList<Integer>();
    		lists.add(list);
    	}
    	List<Integer> list = lists.get(level);//树的level + 1层对应lists的第level个元素
    	if(null != root.left)
    		list.add(root.left.val);
    	if(null != root.right)
    		list.add(root.right.val);
    	
    	if(null != root.left)
    		lists = breadthFirstSearch(root.left, level + 1, lists);
    	if(null != root.right)
    		lists = breadthFirstSearch(root.right, level + 1, lists);
    	
    	return lists;
    }
    
    public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII so = new BinaryTreeLevelOrderTraversalII();
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
		
		System.out.println(so.levelOrderBottom(n1));
		System.out.println(so.levelOrderBottom(null));
		System.out.println(so.levelOrderBottom(n2));
		System.out.println(so.levelOrderBottom(n3));
	}
}
