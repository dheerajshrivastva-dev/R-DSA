

public class SingleLinkedList {

  class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
    }

    public Node(int val, Node next) {
      this.val = val;
      this.next = next;
    }

    public Node next() {
      return this.next;
    }
  }

  Node head;
  Node tail;
  int count;

  SingleLinkedList() {
    this.head = null;
    this.tail = null;
    this.count = 0;
  }

  void insertFirst(int val) {
    Node newHead = new Node(val);
    if(head == null) {
      head = tail = newHead;
    } else {
      newHead.next = head;
      head = newHead;
    }
    count++;
    // System.out.println("count " + count + head.val);
  }

  void insertMiddle(int index, int val) {
    if(index <= 0) {
      insertFirst(val);
      return;
    } else if (index >= count) { 
      insertLast(val);
      return;
    }
    
    Node newNode = new Node(val);
    Node tempHead = head;
    for(int i = 1; i < index; i++) {
      tempHead = tempHead.next;
    }
    newNode.next = tempHead.next;
    tempHead.next = newNode;
    count++;

  }

  void insertLast(int val) {
    Node newNode = new Node(val);
    if(head == null) {
      insertFirst(val);
      return;
    }
    tail.next = newNode;
    tail = newNode;
    count++;
  }

  void deleteFirst() {
    if(count == 0) {
      return;
    } else if (count == 1) {
      head = null;
      tail = null;
      count--;
    } else {
      head = head.next;
      count--;
    }
  }

  void deleteLast() {
    if(count == 0) {
      return;
    } else if (count == 1) {
      head = null;
      tail = null;
      count--;
    } else {
      Node temp = head;
      for(int i = 1; i < count-1; i++) {
        temp = temp.next;
      }
      temp.next = null;
      tail = temp;
      count--;
    }
  }

  void deleteMiddle(int index) {
    if(index <= 0) {
      deleteFirst();
      return;
    } else if (index >= count-1) {
      deleteLast();
      return;
    } else {
      Node temp = head;
      for(int i = 1; i < index; i++) {
        temp = temp.next;
      }
      Node target = temp.next;
      temp.next = target.next;
      target.next = null;
      count--;
    }
  }

  void traverse() {
    Node temp = head;
    while(temp != null) {
      System.out.print(temp.val + " -> ");
      temp = temp.next;
    }
    System.out.println("null");
  }

}

class Main {
  public static void main(String[] args) {
    SingleLinkedList list = new SingleLinkedList();
    list.insertFirst(20);
    list.insertFirst(10);
    list.traverse();

    list.insertLast(100);
    list.insertLast(200);
    list.traverse();
    list.insertMiddle(2, 30);
    list.traverse();
    list.insertMiddle(-2, -30);
    list.traverse();
    list.insertMiddle(8, 400);
    list.traverse();

    list.deleteFirst();
    list.traverse();

    list.deleteLast();
    list.traverse();

    list.deleteMiddle(3);
    list.traverse();

  }
}

