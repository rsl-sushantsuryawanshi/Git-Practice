public class Doubly {
    Node head;
    Node tail;
    int size;
    private class Node{
        int data;
        Node next;
        Node prev;
        public Node(int data){
            this.data=data;
        }
    }
    public void insert(int data){
        Node newnode=new Node(data);
        if(head==null){
            head=newnode;
            tail=newnode;
        }else{
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
        size++;
    }
    public boolean remove(int data){
        Node current=head;
        while(current!=null){
            if(current.data==data){
                if(current==head){
                    head=current.next;
                    if(head!=null){
                        head.prev=null;

                    }
                    else{
                        tail=null;
                    }
                }
                    else if(current == tail){
                        tail=current.prev;
                        if(tail!=null){
                            tail.next=null;
                        }
                        else{head=null;}
                    }
                    else{
                        current.prev.next=current.next;
                        current.next.prev=current.prev;
                    }
                    size--;
                    return true;
                }
                current=current.next;
  
            }
            return false;
        }
        public boolean find(int data){
            Node current=head;
            while(current!=null){
                if(current.data==data){
                    return true;
                }
                current=current.next;
            }
            return false;
        }

        public void display(){
            Node current=head;
            while(current!=null){
                System.out.print(current.data + " ");
                current=current.next;
            }
            System.out.println("null");
        }
        public static void main(String[] args) {
            Doubly ll=new Doubly();
            ll.insert(10);
            ll.insert(20);
            ll.insert(30);
            System.out.println(".(Doubly Linked List after insertion)");
            ll.display();
            System.out.println("Finding element 20: " + ll.find(20));
            System.out.println("Finding element 40: " + ll.find(40));
            ll.remove(20);
            System.out.println("Doubly Linked List after removing 20:");
            ll.display();
            ll.remove(10);
            System.out.println("Doubly Linked List after removing 10:");
            ll.display();
            ll.remove(30);
            System.out.println("Doubly Linked List after removing 30 (empty list):");
            ll.display();
        }



    }

