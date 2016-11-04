/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  
*/
The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
		
		public Node(int data){
			this.data = data;
			left = right = null;
		}
     }

    boolean checkBST(Node root) {
        if(root == null)
			return false;
			
		boolean result = false;
		result = checkBST(root.left);
		result = checkBST(root.right);
			
		//if left and rights are present then check if current nodes data > left and < right
		if(root.left!=null && root.right!=null){
			if((root.data>=root.left.data) && (root.data<=root.right.data))
				return true;
            return false;
               
		}
		//if left node is absent then check current node's data < right node
		if(root.left == null && root.right!=null){
			if(root.data <= root.right.data)
				return true;
            return false;
		}
		//if right node is absent then check current node's data > left node
		if(root.left != null && root.right==null){
			if(root.data >= root.left.data)
				return true;
            return false;
		}
		return result;
    }
