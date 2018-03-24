package sa.edu.yuc;
import java.util.List;
public interface BinarySearchTree<T> {
	public boolean isEmpty();
	public boolean insert(T item) throws DuplicateItemException;
	public T find(T item);
	public void inOrder() throws TreeEmptyException;
	public void preOrder() throws TreeEmptyException;
	public void postOrder() throws TreeEmptyException;
	public void inOrder(List<T> list) throws TreeEmptyException;
	public void preOrder(List<T> list) throws TreeEmptyException;
	public void postOrder(List<T> list) throws TreeEmptyException;
	public T minimum() throws TreeEmptyException;
	public T maximum() throws TreeEmptyException;
	public T maximumBalance() throws TreeEmptyException;
	public T minimumBalance() throws TreeEmptyException;
}