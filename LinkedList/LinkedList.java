public class LinkedList {
    private Node first=null;
    private int count=0;

    public void add(Object e){
        if(first==null){
            first=new Node(e, null);
            count++;
            return;
        }
        Node current=first;
        while(current.next != null){
            current=current.next;
        }
        current.next=new Node(e, null);
        count++;
    }

    public void add(Object e,int index) {
        if(index<=-1 || index>=size()) {
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            first=new Node(e,first);
            count++;
            return;
        }
        Node current=first;
        for(int i=1;i<index;i++) {
            current = current.next;
        }
        current.next = new Node(e, current.next);
        count++;
    }

    public int size() {
        return count;
    }

    public Object get(int index){
        if(index<=-1 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        Node current=first;
        for(int i=1;i<=index;i++){
            current=current.next;
        }
        return current.element;
    }

    public void remove(int index) {
        if(index<=-1 || index>=size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0) {
            first=first.next;
            count--;
            return;
        }
        Node curr=first;
        for(int i=1;i<index;i++) {
            curr=curr.next;
        }
        curr.next = curr.next.next;
        count--;
    }

    public void reverse() {
        Node curr=first;
        Node prev=null;
        while(curr!=null) {
           Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        first=prev;
    }

    public void printLinkedList() {
        for(int i=0;i<size();i++) {
            System.out.print(get(i)+" ");
        }
        System.out.println();
    }
}
