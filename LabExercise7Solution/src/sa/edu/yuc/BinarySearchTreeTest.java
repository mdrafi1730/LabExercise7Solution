package sa.edu.yuc;
import java.util.Iterator;
import java.util.Scanner;
public class BinarySearchTreeTest {
	public static void main(String[] args) {
		BinarySearchTree<Account> bst = new BinarySearchTreeImpl<Account>();
		Scanner input = new Scanner(System.in);
		int choice;
		do{
			menu();
			System.out.print("Enter choice of operation = ");
			choice = input.nextInt();
			switch(choice){
				case 1:
						System.out.println("Tree is Empty ? " + bst.isEmpty());
						break;
				case 2:
						try{
							Account acc = Account.getAccount();
							System.out.println(bst.insert(acc));
						}catch(DuplicateItemException de){
							System.out.println(de.getMessage());
						}
						
						break;
				case 3:
						System.out.print("Enter the account no =  ");
						int id = input.nextInt();
						Account temp = bst.find(new Account(id, "", 0.0));
						if(temp != null)
							System.out.println(temp);
						else
							System.out.println("Account not found");
						break;
				case 4:
					BinarySearchTreeImpl.STATUS = 1;
					System.out.println("InOrder Traversal");
					System.out.println(bst);
					break;
			case 5:
					BinarySearchTreeImpl.STATUS = 2;
					System.out.println("PreOrder Traversal");
					System.out.println(bst);
					break;
			case 6:
					BinarySearchTreeImpl.STATUS = 3;
					System.out.println("PostOrder Traversal");
					System.out.println(bst);
					break;
			case 7:
					try{
						System.out.print("Minimum = " + bst.minimum());
					}catch(TreeEmptyException tee){
						System.out.println(tee.getMessage());
					}
					break;
			case 8:
					try{
						System.out.print("Minimum = " + bst.maximum());
					}catch(TreeEmptyException tee){
						System.out.println(tee.getMessage());
					}
					break;
			case 9:
					System.out.println("Thank you for using this program !!!");
					break;
			default:
					System.out.println("Invalid option");
					
		}
	}while(choice != 9);
}
public static void menu(){
	System.out.println("Binary Search Tree Operations\n1. IsEmpty()\n2. Insert"
		+ "\n3. Find"
		+ "\n4. InOrder"
		+ "\n5. PreOrder"
		+ "\n6. PostOrder"
		+ "\n7. Minimum"
		+ "\n8. Maximum"
		+ "\n9. Exit");
}
}