import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class SMS {
    Scanner input = new Scanner(System.in);
    class Node{
        int data;
        Node next;
    }Node top;

    class Node1{
        String cname;
        Node1 next1;

        Node1()
        {

        }
    }
    Node1 front = null;
    Node1 rear  = null;
    int i=1;
    void push(int data)
    {
        Node temp;
        temp = new Node();

        if(temp == null){
            System.out.println("\nHeap overflow");
            return;
        }
        temp.data = data;
        temp.next = top;
        top = temp;
    }

    boolean isEmpty()
    {
        return top == null;
    }

    int peek()
    {
        if(!isEmpty())
        {
            return top.data;
        }
        else
        {
            System.out.println("\nStack is empty.");
            return -1;
        }
    }

    void Npop()
    {
        Node temp;
        if(top == null)
        {
            System.out.println("\nStack underflow");
            System.exit(1);
        }
        else
        {
            temp = top;
            top = top.next;
            temp.next = null;
        }
        System.out.println("Your trolly number is " + top.data);
        System.out.println("                               ___");
        System.out.println("                              /  |");
        System.out.println("               ______________/   --");
        System.out.println("              |___/__ /___/_|     ");
        System.out.println("              |__/___/___/__|     ");
        System.out.println("              |_/___/___/___|     ");
        System.out.println("                 _______/         ");
        System.out.println("                  O   O           ");

    }

    void  Ndisplay()
    {
        Node temp;

        if(top == null)
        {
            System.out.println("\n Stack underflow");
            System.exit(1);
        }
        else
        {
            temp = top;
            while (temp != null)
            {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    boolean isEmptyq()
    {
        if(front == null && rear == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    void Enqueue(String name)
    {
        Node1 newNode = new Node1();
        newNode.cname = name;
        newNode.next1 = null;

        if(front == null)
        {
            front = newNode;
            rear = newNode;
        }
        else
        {
            rear.next1 = newNode;
            rear = newNode;
        }
    }

    void dequeue()
    {
        if(isEmptyq())
        {
            System.out.println("\nQueue is empty.");
        }
        else
        {
            if(front == rear)
            {
                front = rear = null;
            }
            else
            {
                Node1 ptr = front;
                front = front.next1;
            }
        }
    }

    void showFront()
    {
        if(isEmptyq())
        {
            System.out.println("Queue is empty.");
        }
        else
        {
            System.out.println("Element in front is :"+ front.cname);
        }
    }

    void displayqueue()
    {
        if(isEmptyq())
        {
            System.out.println("Queue is empty");
        }
        else
        {
            Node1 ptr = front;
            while (ptr != null)
            {
                System.out.println(ptr.cname);
                ptr = ptr.next1;
            }
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }


    // Admin
    class Node2{
        int ID;
        String prename;
        double prePrice;
        int Quantity;
        Node2 next2;
    }
    Node2 head2 = null;

    void beg(){
        int id;
        int quantity;
        String name;
        double preprice;
        Node2 t = new Node2();

        if(head2 == null)
        {
            //System.out.println("Enter product ID :");
            //id = input.nextInt();
            t.ID = i++;
            System.out.println("Enter product name :");
            name = input.next();
            t.prename = name;
            System.out.println("Enter product price :");
            preprice = input.nextInt();
            t.prePrice = preprice;
            System.out.println("Enter product quantity :");
            quantity = input.nextInt();
            t.Quantity = quantity;
            t.next2 = head2;
            head2 = t;
        }
        else
        {
            //System.out.println("Enter product ID :");
            //id = input.nextInt();
            t.ID = i++;
            System.out.println("Enter product name :");
            name = input.next();
            t.prename = name;
            System.out.println("Enter product price :");
            preprice = input.nextInt();
            t.prePrice = preprice;
            System.out.println("Enter product quantity :");
            quantity = input.nextInt();
            t.Quantity = quantity;
            Node2 p = head2;
            while (p.next2!=null)
            {
                p = p.next2;
            }
            p.next2 = t;
            t.next2 = null;
        }
        clearScreen();
        System.out.println("\nThis product is inserted\n");
    }

    int search(int id)
    {
        int count = 1;
        Node2 p = head2;
        while (p!=null)
        {
            if(p.ID == id)
            {
                break;
            }
            else
            {
                count++;
                p=p.next2;
            }
        }
        return count;
    }

    int hash(int x, int mod)
    {
        return x%mod;
    }

    int display()
    {
        clearScreen();
        int c = 0;
        Node2 p = head2;
        System.out.println("Available Products list :");
        System.out.println("ID     Product Name      Price      \n");
        System.out.println("_____________________________________\n");
        while (p!=null)
        {
            System.out.println(p.ID+"\t\t"+p.prename+"\t\t"+p.prePrice+"\t\t");
            p = p.next2;
            c = c+1;
        }
        System.out.println("Total number of product in store are :"+c);
        return c;
    }

    String check(int quant)
    {
        int a = quant;

        String quantity = Integer.toString(a);
        if(quant<=0)
            return "Out of stock";
        else return quantity;
    }

    void delete()
    {
        clearScreen();
        display();
        Node2 current = head2;
        Node2 pre = head2;
        System.out.println("Enter product ID to delete :");
        int id = input.nextInt();
        if(head2 == null)
        {
            clearScreen();
            System.out.println("List is empty.");
        }

        int pos = 0;
        int count = display();
        pos  = search(id);
        if(id==1)
        {
            head2 = head2.next2;
        }
        else if(pos<=count)
        {
            while (current.ID != id)
            {
                pre = current;
                current = current.next2;
            }
            pre.next2 = current.next2;
            current = null;
            clearScreen();
            System.out.println("Item is deleted.");
        }
        else
        {
            System.out.println("Item not found");
        }
    }

    void modify()
    {
        int id;
        double nprice;
        String pname;
        int nid;
        int nq;
        if(head2 == null)
        {
            clearScreen();
            System.out.println("List is empty.");
        }
        else
        {
            display();
            System.out.println("Enter id to modify price and name :");
            id = input.nextInt();
            Node2 current = head2;
            int pos = 0;
            int count = display();
            pos = search(id);

            if(pos<=count)
            {
                while (current.ID != id)
                {
                    current = current.next2;
                }
                System.out.println("Old Id :"+current.ID);
                System.out.println("Old name :"+current.prename);
                System.out.println("Old price :"+current.prePrice);
                System.out.println("Old Quantity :"+current.Quantity);

                System.out.println("\n\n");
                System.out.println("Enter Id :");
                nid = input.nextInt();
                current.ID = nid;
                System.out.println("Enter name :");
                pname = input.next();
                current.prename = pname;
                System.out.println("Enter price :");
                nprice = input.nextDouble();
                current.prePrice = nprice;
                System.out.println("Enter quantity :");
                nq = input.nextInt();
                current.Quantity = nq;
            }
            else
            {
                System.out.println("ID not found.");
            }
        }
    }

    void  buy()
    {
        clearScreen();
        display();
        String product[];
        int pay=0;
        int no;
        int c = 0;
        double price;
        int id;
        int i;

        if(head2==null)
        {
            System.out.println("There is no item to buy.\n");
        }
        else
        {
            System.out.println("How many item you want to buy :");
            no = input.nextInt();
            product = new String[no];
            int count = display();

            for(i=0; i<no; i++) {
                Node2 current = head2;
                int quant;
                int cho;
                int pos = 0;
                System.out.println("Enter ID to buy :");
                id = input.nextInt();
                if (id == -1) {
                    clearScreen();
                    return;
                }
                pos = search(id);
                if (pos <= count) {
                    while (current.ID != id) {
                        current = current.next2;
                    }
                    System.out.println("Enter the quantity number :");
                    quant = input.nextInt();
                    if (current.Quantity < quant) {
                        System.out.println("The qauntity you enter is unavailable :");
                        System.out.println("Press 1 for main menu.....");
                        break;
                    }
                    product[c] = current.prename;
                    c++;

                    pay = (int) (pay + (current.prePrice * quant));
                    current.Quantity = current.Quantity - quant;
                }
                else {
                    System.out.println("This item is not available in our store.");
                    break;
                }
            }
            String customer;
            System.out.println("Enter your name :");
            customer = input.next();
            Enqueue(customer);
            clearScreen();
            System.out.println("You have bought :");
            for (i = 0; i < no; i++) {
                System.out.println("Item"+(i+1)+": "+product[i] + " ");
            }
            price = pay*(0.9);
            System.out.println("Original price :"+ pay);
            System.out.println("Price with 10% discount :"+ price);
            System.out.println("Thanks for shopping (:");
            clearScreen();
            }
        }

        void administative()
        {
            clearScreen();
            int choice;
            do{
                System.out.println("=============================");
                System.out.println("|    Administrator Portal     |");
                System.out.println("==============================");
                System.out.println("Enter 0 for main menu :");
                System.out.println("Enter 1 to add products :");
                System.out.println("Enter 2 to display all products :");
                System.out.println("Enter 3 to modify products :");
                System.out.println("Enter 4 to delete a product :");
                System.out.println("Enter 5 for customer list :");
                System.out.println("Enter 6 for dequeue customer :");
                System.out.println("Enter 7 to generate hash :");

                System.out.println("Enter your choice :");
                choice = input.nextInt();

                switch (choice) {
                    case 1:
                        clearScreen();
                        beg();
                        break;
                    case 2:
                        clearScreen();
                        display();
                        break;
                    case 3:
                        modify();
                        clearScreen();
                        break;
                    case 4:
                        clearScreen();
                        delete();
                        System.out.println("==========Product Deleted==========");
                        break;
                    case 5:
                        clearScreen();
                        System.out.println("========CUSTOMER NAMES LIST========");
                        displayqueue();
                        break;
                    case 6:
                        clearScreen();
                        System.out.println("=========CUSTOMER NAMES LIST========");
                        dequeue();
                        displayqueue();
                        break;
                    case 7:
                        int x, n;
                        System.out.println("Enter element to generate hash :");
                        x = input.nextInt();
                        System.out.println("Total list number :");
                        n = input.nextInt();
                        System.out.println("Hash of " + x + " is :" + hash(x, n));
                        break;
                    default:
                        clearScreen();
                }
            }while (choice!=0);
        }

    public static void main(String[] args) {
        SMS obj = new SMS();
        Scanner input = new Scanner(System.in);
        for(int i=0; i<=51; i++)
        {
            obj.push(i);
        }

        int choice = 0;
        while (choice!=3)
        {
            System.out.println("======MAIN MENU=======");
            System.out.println("===1 FOR ADMIN MENU===");
            System.out.println("===2 CUSTOMER MENU====");
            System.out.println("=======3 EXIT=========");

            System.out.println("Enter your choice :");
            choice = input.nextInt();

            switch (choice)
            {
                case 1:
                    obj.clearScreen();
                    obj.administative();
                    break;
                case 2:
                    obj.clearScreen();
                    obj.Npop();
                    obj.buy();
                    break;
                case 3:
                    System.out.println("Thanks for Shopping (:");
                    break;
            }
        }
    }
}
