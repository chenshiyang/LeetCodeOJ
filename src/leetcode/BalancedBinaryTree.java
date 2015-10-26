/**
* <p>Title: BalancedBinaryTree.java</p>
* <p>Description: </p>
* <p>Copyright: Copyright (c) 2015</p>
* <p>Company: CSY</p>
* @author chenshiyang
* @date 2015��10��21��
* @version jdk8.0
*/
package leetcode;

/**
 * <p>Title: BalancedBinaryTree</p>
 * <p>Description: </p>
 * @author chenshiyang
 * @date 2015��10��21��
 * @time ����11:00:38
 */
public class BalancedBinaryTree {
	
	//1.˼·1. �ȸ���һ�����������������ԭʼ��������޸ģ�Ȼ����õݹ�dfs�� ÿ��node��val������¼�Ըõ�Ϊ���������ĸ߶�
	//��������ɺ󣬸߶�Ҳ��¼��ϡ� Ȼ���ٴα������Ƶ�������ÿ���㣬�Ƚ��������������ӽڵ�ĸ߶Ȳ�����ڸ߶Ȳ����1�ģ�
	//����false�� �������շ���true��
	
/*    public boolean isBalanced(TreeNode root) {   	
    	TreeNode croot = getCopyTree(root);
    	//�ݹ�Ƚϸ߶Ȳ�
    	//unimplemented
    } */  
    
    private TreeNode getCopyTree(TreeNode root){
    	if(null == root) return null;
    	//copy root.
    	TreeNode croot = new TreeNode(1);
    	//copy left subtree.
    	croot.left = getCopyTree(root.left);
    	//copy right subtree
    	croot.right = getCopyTree(root.right);
    	//set root's height.
    	croot.val = getHeight(croot);
    	//return croot.
    	return croot;
    }
    
    /**
    * <p>Description: Here the height is defined as 1 + max(root's left subtree's height, root's right subtree's height)
    * That's to say.  root.val records the height of the tree rooted at root. </p>
    * @param root
    * @return
    */
    private int getHeight(TreeNode root){
    	if(null == root) return 0;
    	if(null == root.left && null == root.right) return 1;
    	if(null != root.left) return root.left.val + 1;
    	if(null != root.right) return root.right.val + 1;
    	return Math.max(root.left.val, root.right.val) + 1;
    }
    
    //˼·2. ��˼·1�Ļ���ͬ���Ǹ���һ���������Ե����Ϸ��صĹ����м��Ƚ��������������ĸ߶Ȳ
    
    class TreeNode2{
    	private TreeNode2 left;
    	private TreeNode2 right;
    	private int height;
    	private boolean isBalanced;
    	
        private TreeNode2(int value){
        	height = value;
        }
        
        private void setHeight(){
        	if(null == this.left && null == this.right) this.height = 1;
        	else if(null == this.right) this.height =  this.left.height + 1;
        	else if(null == this.left) this.height = this.right.height + 1;
        	else this.height = Math.max(this.left.height, this.right.height) + 1;
        	return;
        }
        
        public String toString(){
        	return this.height + "," + this.isBalanced;
        }
    }
    
    public boolean isBalanced(TreeNode root){
    	TreeNode2 croot = copyTree(root);
    	return null == croot ? true : croot.isBalanced;
    }
    
    private TreeNode2 copyTree(TreeNode root){
    	if(null == root) return null;
    	//copy root
    	TreeNode2 croot = new TreeNode2(1);
    	//copy left subtree.
    	croot.left = copyTree(root.left);
    	//check whether left tree is balanced, if left tree is unbanlanced ,then return directly.
    	if(null != croot.left && ! croot.left.isBalanced){
    		croot.isBalanced = false;
    		return croot;
    	}
    	//copy right subtree
    	croot.right = copyTree(root.right);
    	if(null != croot.right && ! croot.right.isBalanced){
    		croot.isBalanced = false;
    		return croot;
    	}
    	int leftHeight = null == croot.left ? 0 : croot.left.height;
    	int rightHeight = null == croot.right ? 0 : croot.right.height;
    	if(Math.abs(leftHeight - rightHeight) > 1){
    		croot.isBalanced = false;
    	}
    	else{
    		croot.isBalanced = true;
    	}
    	croot.setHeight();
    	return croot;
    }
    
/*    private boolean balanced(TreeNode root){
    	if(null == root) return true;
    	if(null == root.left && root.right.val > 1) return false;
    	if(null == root.right && root.left.val > 1) return false;
    	
    }*/
    
    private boolean isLeaf(TreeNode node){
    	return null == node.left && null == node.right;
    }
    
    public static void main(String[] args) {
		BalancedBinaryTree so = new BalancedBinaryTree();
		
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
		
		System.out.println(so.isBalanced(n1) == false);
		System.out.println(so.isBalanced(n6) == true);
		System.out.println(so.isBalanced(n2) == true);
		System.out.println(so.isBalanced(n3) == false);
		System.out.println(so.isBalanced(null));
		
		
		TreeNode t1 = new TreeNode(2);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(4);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(1);
		TreeNode t8 = new TreeNode(1);
		
		t1.left = t2;
		t1.right = t3;
		t3.left = t4;
		t3.right = t5;
		t5.right = t6;
		
		System.out.println(so.isBalanced(t1));
	}
}
