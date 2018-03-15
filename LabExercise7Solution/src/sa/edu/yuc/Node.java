package sa.edu.yuc;
import java.util.List;
public class Node<T>{
	T item;
	Node leftChild;
	Node rightChild;
	public Node(T item){
		this.item = item;
	}
	public void preOrder(){
		System.out.print(item);
		if (leftChild != null) 
			leftChild.preOrder();
		if (rightChild != null) 
			rightChild.preOrder();
	}
	public void postOrder() {
		if (leftChild != null) 
			leftChild.postOrder();
		if (rightChild != null) 
			rightChild.postOrder();
		System.out.print(item);
	}
	public void inOrder(){
		if(leftChild != null)
			this.leftChild.inOrder();
		System.out.print(item);
		if(rightChild != null)
			this.rightChild.inOrder();
	}
	public void preOrder(List<T> list) {
		list.add(item);
		if (leftChild != null) leftChild.preOrder(list);
		if (rightChild != null) rightChild.preOrder(list);
	}
	public void inOrder(List<T> list) {
		if (leftChild != null) leftChild.inOrder(list);
		list.add(item);
		if (rightChild != null) rightChild.inOrder(list);
	}
	public void postOrder(List<T> list) {
		if (leftChild != null) leftChild.postOrder(list);
		if (rightChild != null) rightChild.postOrder(list);
		list.add(item);
	}
	
}
