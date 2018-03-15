package sa.edu.yuc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class TreeIterator<T extends Comparable<T>> implements Iterator<T> {
	private Iterator<T> iter;
	public TreeIterator(BinarySearchTreeImpl<T> tree, int status) throws TreeEmptyException {
		List<T> list = new ArrayList<>();
		List <T>list1 = new ArrayList<>();
		List<T> list2 = new ArrayList<>();
		if(status == 1){
			tree.inOrder(list);
			iter = list.iterator();
		}else if(status == 2){
			tree.preOrder(list1);
			iter = list1.iterator();
		}else{
			tree.postOrder(list2);
			iter = list2.iterator();
		}
	}
	@Override
	public boolean hasNext() {
		return iter.hasNext();
	}
	@Override
	public T next() {
		return iter.next();
	}
}
