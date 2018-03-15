package sa.edu.yuc;
import java.util.Iterator;
import java.util.List;
public class BinarySearchTreeImpl<T extends Comparable<T>> implements BinarySearchTree<T>, Iterable<T>{
	private Node<T> root;
	public static int STATUS;
	@Override
	public boolean isEmpty() {
		return this.root == null;
	}
	@Override
	public boolean insert(T item) throws DuplicateItemException {
		Node<T> newNode = new Node<T>(item);
		if(isEmpty()){
			this.root = newNode;
			return true;
		}
		else{
				Node<T> current = this.root;
				while(current != null){
					if(item.compareTo(current.item) < 0){
						if(current.leftChild == null){
							current.leftChild = newNode;
							return true;
						}
						current = current.leftChild;
					}else if(item.compareTo(current.item) > 0){
						if(current.rightChild == null){
							current.rightChild = newNode;
							return true;
						}
						current = current.rightChild;
					}else{
						throw new DuplicateItemException("Item Already Exist");
					}
				}
			}
			return false;
		}
	@Override
	public T find(T item) {
		Node<T> current = this.root;
		T temp = null;
		while (current != null && temp == null) {
			if (current.item.compareTo(item) == 0) {
				temp = current.item;
			} else if (item.compareTo(current.item) < 0) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}
		}		
		return temp;
	}
	@Override
	public void inOrder() throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		root.inOrder();
	}
	@Override
	public void preOrder() throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		root.preOrder();
	}
	@Override
	public void postOrder() throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		root.postOrder();
	}
	@Override
	public void inOrder(List<T> list) throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		root.inOrder(list);
	}
	public void preOrder(List<T> list)throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		root.preOrder(list);
	}
	public void postOrder(List<T> list) throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		root.postOrder(list);
	}
	@Override
	public Iterator<T> iterator() {
		try {
			return new TreeIterator<T> (this, STATUS);
		} catch (TreeEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String toString(){
		String temp = "";
		Iterator iter = iterator();
		while(iter.hasNext()){
			temp += iter.next();
		}
		return temp;
	}
	@Override
	public T minimum() throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		Node<T> current = root;
	     while (current.leftChild != null) {
	    	 current = current.leftChild;
	     }
	     return(current.item);
	}
	@Override
	public T maximum() throws TreeEmptyException {
		if(isEmpty())
			throw new TreeEmptyException("Tree is Empty");
		Node<T> current = root;
	     while (current.rightChild != null) {
	    	 current = current.rightChild;
	     }
	     return (current.item);
	}
	
}