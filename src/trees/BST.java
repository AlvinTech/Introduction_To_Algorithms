package trees;

public class BST {

	public static void inorderTreeWalk(Node node){
		if(node != null){
			inorderTreeWalk(node.left);
			System.out.print(node.key+" ");
			inorderTreeWalk(node.right);
		}
	}
	
	public static void preorderTreeWalk(Node node){
		if(node != null){
			
			System.out.print(node.key+" ");
			preorderTreeWalk(node.left);
			preorderTreeWalk(node.right);
		}
	}
	
	public static void postorderTreeWalk(Node node){
		if(node != null){
			postorderTreeWalk(node.left);
			postorderTreeWalk(node.right);
			System.out.print(node.key+" ");
		}
		
	}
	
	public static Node treeSearch(Node root, int key){
		if(root == null || key == root.key){
			return root;
		}
		if(key < root.key)
			return treeSearch(root.left,key);
		else
			return treeSearch(root.right,key);
	}
	
	public static Node treeSearch2(Node root,int key){
		while(root != null && root.key != key){
			if(key < root.key)
				root = root.left;
			else 
				root = root.right;
		}
		return root;
	}
	
	public static Node minimum(Node root){
		while(root.left != null)
			root = root.left;
		return root;
	}
	
	public static Node maximum(Node root){
		while(root.right != null)
			root  = root.right;
		return root;
	}
	
	public static Node  successor(Node node){
		if(node.right != null)
			return minimum(node.right);
		Node y = node.p;
		while(y != null && node == y.right){
			node = y;
			y = y.p;
		}
		return y;
		
	}
	
	public static Node treeInsert(Node root,int key){
		Node y =null;
		Node z = new Node(key);
		Node x = root;
		while(x != null){
			y = x;
			if(x.key > z.key)
				x = x.left;
			else
				x = x.right;
		}
		
		z.p = y;
		if(y == null){
			root  = z;
		}
		else if(z.key <y.key){
			y.left = z;
		}
		else 
			y.right = z;
		return root;
	}
	
	public static Node  transplant(Node root,Node u, Node v){
		if(u.p == null){
			root = v;
		}
		else if(u == u.p.left)
			u.p.left = v;
		else
			u.p.right = v;
		if(v != null)
			v.p = u.p;
		return root;
	}
	
	public static Node treeDelete(Node root,Node z){
		if(z.left == null){
			root = transplant(root,z,z.right);
		}
		else if(z.right == null){
			root = transplant(root,z,z.left);
		}
		else{ 
			Node  y = minimum(z.right);
			if( y.p != z){
				root = transplant(root,y,y.right);
				y.right = z.right;
				y.right.p = y;
			}
			root = transplant(root,z,y);
			y.left = z.left;
			y.left.p = y;
		}
		return root;
	}
	public static void main(String[] args) {
		int[] array = {1,5,10,8,2,6,7,4,9,3};
		Node root = null;
		for(int i =0;i<10;i++){
			root = treeInsert(root,array[i]);
		}
		System.out.println("************ Inorder Tree walk ************");
		inorderTreeWalk(root);
		System.out.println();
		System.out.println("************ Inorder Tree walk ************");
		root = treeDelete(root,treeSearch(root,8));
		inorderTreeWalk(root);
		System.out.println();
		System.out.println("************ Preorder Tree walk ************");
		preorderTreeWalk(root);
		System.out.println();
		System.out.println("************ Postorder Tree walk ************");
		postorderTreeWalk(root);
		System.out.println();
		System.out.println();
		System.out.println(maximum(root).key);
		System.out.println(minimum(root).key);
		Node node  = treeSearch(root,-1);
		if(node != null)
			System.out.println(node.key);
		else
			System.out.println("no element.");
		
	}

}
