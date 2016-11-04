import java.io.PrintStream;

public class MinimalBST
{
  static class TreeNode
  {
    int data;
    TreeNode left;
    TreeNode right;
    TreeNode parent;
    
    public TreeNode(int paramInt)
    {
      this.data = paramInt;
      this.left = (this.right = this.parent = null);
    }
  }
  /****
  * Given a sorted array with unique elements write an algorithm to 
  * to create a binary search tree with minimal height
  * paramInt1 = start (0 )
  * paramInt2 = end(array length -1)
  ****/
  public static MinimalBST.TreeNode createMinimalBST(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
	
    if (paramInt2 < paramInt1) {
      return null;
    }
    int i = (paramInt1 + paramInt2) / 2;
    //Create node 
    MinimalBST.TreeNode localTreeNode = new MinimalBST.TreeNode(paramArrayOfInt[i]);
	//recursive call going left with 0 to mid-1
    localTreeNode.left = createMinimalBST(paramArrayOfInt, paramInt1, i - 1);
    if ((localTreeNode != null) && (localTreeNode.left != null)) {
      localTreeNode.left.parent = localTreeNode;
    }
	//recursive call going mid+1 to end
    localTreeNode.right = createMinimalBST(paramArrayOfInt, i + 1, paramInt2);
    if ((localTreeNode != null) && (localTreeNode.right != null)) {
      localTreeNode.right.parent = localTreeNode;
    }
	//return node in the middle. At the end of the call this will be pointing to the root of the BST
    return localTreeNode;
  }
/****
* Given the root get the height of a tree.
*
*****/

  public static int getHeight(MinimalBST.TreeNode paramTreeNode)
  {
    if (paramTreeNode == null) {
      return -1;
    }
    return Math.max(getHeight(paramTreeNode.left), getHeight(paramTreeNode.right)) + 1;
  }
  /*****
  * check if a Tree is balanced. if the height diff between right and left node is >1 then it is not balanced
  *
  *****/
  public static int getHeight2(MinimalBST.TreeNode paramTreeNode)
  {
    if (paramTreeNode == null) {
      return -1;
    }
    int i = getHeight2(paramTreeNode.left);
    if (i == Integer.MIN_VALUE) {
      return i;
    }
    int j = getHeight2(paramTreeNode.right);
    if (j == Integer.MIN_VALUE) {
      return j;
    }
    if (Math.abs(i - j) > 1) {
      return Integer.MIN_VALUE;
    }
    return Math.max(i, j) + 1;
  }
  
  public static boolean checkBalanced(MinimalBST.TreeNode paramTreeNode)
  {
    return getHeight2(paramTreeNode) != Integer.MIN_VALUE;
  }
  
  public static void printTree(MinimalBST.TreeNode paramTreeNode)
  {
    if (paramTreeNode == null) {
      return;
    }
    if (paramTreeNode.left != null) {
      printTree(paramTreeNode.left);
    } else if (paramTreeNode.right != null) {
      printTree(paramTreeNode.right);
    } else {
      System.out.println("leaf node" + paramTreeNode.data);
    }
  }
  
  /****
  * Validate ig a given tree is a BST. That is left < current < right.
  *
  *
  ******/
  
  public static boolean validateBST(MinimalBST.TreeNode paramTreeNode)
  {
    boolean bool = false;
    if (paramTreeNode == null) {
      return false;
    }
    System.out.println("t.data " + paramTreeNode.data);
    bool = validateBST(paramTreeNode.left);
    bool = validateBST(paramTreeNode.right);
	//if given node has non-null left and right nodes
    if ((paramTreeNode.left != null) && (paramTreeNode.right != null))
    {
      System.out.println("left " + paramTreeNode.left.data + " , parent , " + paramTreeNode.data + " , right " + paramTreeNode.right.data);
      if ((paramTreeNode.data > paramTreeNode.left.data) && (paramTreeNode.data <= paramTreeNode.right.data)) {
        return true;
      }
      return false;
    }
	//if given node has only right node
    if ((paramTreeNode.left == null) && (paramTreeNode.right != null))
    {
      System.out.println("parent , " + paramTreeNode.data + " , right " + paramTreeNode.right.data);
      if (paramTreeNode.data <= paramTreeNode.right.data) {
        return true;
      }
      return false;
    }
	//if given node has only left node
    if ((paramTreeNode.left != null) && (paramTreeNode.right == null))
    {
      System.out.println("left " + paramTreeNode.left.data + " , parent , " + paramTreeNode.data);
      if (paramTreeNode.data > paramTreeNode.left.data) {
        return true;
      }
      return false;
    }
    return bool;
  }
  
  /****
  * Given a node get the next node to process assuming in -order traversing. If the given node has a right node that has a left node then 
  *
  *****/
  public static MinimalBST.TreeNode getNextNode(MinimalBST.TreeNode paramTreeNode)
  {
    if (paramTreeNode == null) {
      return paramTreeNode;
    }
    MinimalBST.TreeNode localTreeNode = null;
    if (paramTreeNode.right != null) {
      localTreeNode = getLeftMostNode(paramTreeNode.right);
    }
    if (paramTreeNode.parent != null) {
      localTreeNode = paramTreeNode.parent;
    }
    return localTreeNode;
  }
  // get the left most node in the tree given a node
  public static MinimalBST.TreeNode getLeftMostNode(MinimalBST.TreeNode paramTreeNode)
  {
    if (paramTreeNode == null) {
      return null;
    }
    while (paramTreeNode.left != null) {
      paramTreeNode = paramTreeNode.left;
    }
    return paramTreeNode;
  }
  
  public static boolean isNodeInTree(MinimalBST.TreeNode paramTreeNode1, MinimalBST.TreeNode paramTreeNode2, boolean paramBoolean)
  {
    MinimalBST.TreeNode localTreeNode = paramTreeNode1;
    
    System.out.println("root.data " + paramTreeNode1.data + ", q.data " + paramTreeNode2.data + ", " + paramBoolean);
    if ((paramTreeNode1 == null) || (paramTreeNode2 == null)) {
      return false;
    }
    if (paramTreeNode1 == paramTreeNode2) {
      return true;
    }
    if (paramTreeNode1.left != null) {
      paramBoolean = isNodeInTree(paramTreeNode1.left, paramTreeNode2, paramBoolean);
    }
    if (paramTreeNode1.right != null) {
      paramBoolean = isNodeInTree(paramTreeNode1.right, paramTreeNode2, paramBoolean);
    }
    return paramBoolean;
  }
  
  public static MinimalBST.TreeNode getCommonAncestor(MinimalBST.TreeNode paramTreeNode1, MinimalBST.TreeNode paramTreeNode2, MinimalBST.TreeNode paramTreeNode3)
  {
    MinimalBST.TreeNode localTreeNode = null;
    localTreeNode = getCommonAncestor(paramTreeNode1, paramTreeNode2, paramTreeNode3, localTreeNode);
    return localTreeNode;
  }
  
  public static MinimalBST.TreeNode getCommonAncestor(MinimalBST.TreeNode paramTreeNode1, MinimalBST.TreeNode paramTreeNode2, MinimalBST.TreeNode paramTreeNode3, MinimalBST.TreeNode paramTreeNode4)
  {
    if ((paramTreeNode1 == null) || (paramTreeNode2 == null) || (paramTreeNode3 == null)) {
      return null;
    }
    if (paramTreeNode2 == paramTreeNode3) {
      return paramTreeNode2;
    }
    System.out.println("root.data " + paramTreeNode1.data + ", q.data " + paramTreeNode3.data + ", p.data " + paramTreeNode2.data);
    if (paramTreeNode2 == paramTreeNode1) {
      if (isNodeInTree(paramTreeNode1, paramTreeNode3, false)) {
        return paramTreeNode2;
      }
    }
    if (paramTreeNode3 == paramTreeNode1) {
      if (isNodeInTree(paramTreeNode1, paramTreeNode2, false)) {
        return paramTreeNode3;
      }
    }
    if ((paramTreeNode2 != paramTreeNode1) && (paramTreeNode3 != paramTreeNode1))
    {
      if (paramTreeNode2.parent == paramTreeNode3.parent) {
        return paramTreeNode2.parent;
      }
      if ((isNodeInTree(paramTreeNode1, paramTreeNode3, false)) && (isNodeInTree(paramTreeNode1, paramTreeNode2, false))) {
        return paramTreeNode1;
      }
    }
    if (paramTreeNode1.left != null) {
      paramTreeNode4 = getCommonAncestor(paramTreeNode1.left, paramTreeNode2, paramTreeNode3, paramTreeNode4);
    }
    if (paramTreeNode1.right != null) {
      paramTreeNode4 = getCommonAncestor(paramTreeNode1.right, paramTreeNode2, paramTreeNode3, paramTreeNode4);
    }
    return paramTreeNode4;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    int[] arrayOfInt = new int[10];
    for (int i = 0; i < arrayOfInt.length; i++) {
      arrayOfInt[i] = (i + 1);
    }
    MinimalBST.TreeNode localTreeNode1 = new MinimalBST.TreeNode(8);
    MinimalBST.TreeNode localTreeNode2 = new MinimalBST.TreeNode(9);
    MinimalBST.TreeNode localTreeNode3 = new MinimalBST.TreeNode(5);
    MinimalBST.TreeNode localTreeNode4 = new MinimalBST.TreeNode(3);
    MinimalBST.TreeNode localTreeNode5 = new MinimalBST.TreeNode(2);
    MinimalBST.TreeNode localTreeNode6 = new MinimalBST.TreeNode(1);
    MinimalBST.TreeNode localTreeNode7 = new MinimalBST.TreeNode(4);
    MinimalBST.TreeNode localTreeNode8 = new MinimalBST.TreeNode(7);
    MinimalBST.TreeNode localTreeNode9 = new MinimalBST.TreeNode(12);
    MinimalBST.TreeNode localTreeNode10 = new MinimalBST.TreeNode(11);
    MinimalBST.TreeNode localTreeNode11 = new MinimalBST.TreeNode(15);
    MinimalBST.TreeNode localTreeNode12 = new MinimalBST.TreeNode(16);
    
    localTreeNode1.left = localTreeNode2;
    localTreeNode2.parent = localTreeNode1;
    localTreeNode1.right = localTreeNode3;
    localTreeNode3.parent = localTreeNode1;
    localTreeNode2.left = localTreeNode4;
    localTreeNode4.parent = localTreeNode2;
    localTreeNode2.right = localTreeNode5;
    localTreeNode5.parent = localTreeNode2;
    localTreeNode5.left = localTreeNode9;
    localTreeNode9.parent = localTreeNode5;
    localTreeNode5.right = localTreeNode10;
    localTreeNode10.parent = localTreeNode5;
    localTreeNode9.left = localTreeNode11;
    localTreeNode11.parent = localTreeNode9;
    localTreeNode9.right = localTreeNode12;
    localTreeNode12.parent = localTreeNode9;
    
    localTreeNode3.left = localTreeNode6;
    localTreeNode6.parent = localTreeNode3;
    localTreeNode3.right = localTreeNode7;
    localTreeNode7.parent = localTreeNode3;
    localTreeNode7.right = localTreeNode8;
    localTreeNode8.parent = localTreeNode7;
    
    MinimalBST.TreeNode localTreeNode13 = getCommonAncestor(localTreeNode1, localTreeNode10, localTreeNode11);
    System.out.println(localTreeNode13.data);
  }
}
