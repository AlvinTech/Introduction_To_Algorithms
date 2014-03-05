package trees;

public class Node {
	public int key;
	public Node left;
	public Node right;
	public Node p;
	public Node(){
		left = null;
		right = null;
		p = null;
	}
	public Node(int key){
		this.key = key;
	}

}
