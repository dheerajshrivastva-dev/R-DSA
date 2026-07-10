public class Queue {
  private int[] arr;
  private int front;
  private int rear;
  private int capacity;

  public Queue(int capacity) {
    this.capacity = capacity;
    this.arr = new int[capacity];
    this.front = 0;
    this.rear = -1; 
  }

  public boolean isFull() {
    return rear == capacity -1;
  }

  public boolean isEmpty() {
    return front > rear && rear < capacity -1;
  }

  public boolean insert(int val) {
    if(this.isFull()) {
      System.out.println("Queue is full");
      display();
      return false;
    } else {
      arr[++rear] = val;
      return true;
    }
  }

  public int poll() {
    if(this.isEmpty()) {
      System.out.println("Queue is Empty");
      return -1;
    } else {
      return arr[front++];
    }
  }

  public int peekRear() {
    if(this.isEmpty()) {
      return -1;
    } else {
      return arr[rear];
    }
  }

  public int peekFront() {
    if(this.isEmpty()) {
      return -1;
    } else {
      return arr[front];
    }
  }

  public void display() {
    if(this.isEmpty()) {
      System.out.println("Queue is empty!");
    }

    for (int i = front; i <= rear; i++) {
      System.out.print(arr[i] + " -> ");
    }
    System.out.println();
  }

}

class Main {
  public static void main(String[] args) {
    Queue q = new Queue(5);

    q.insert(10);
    q.insert(20);
    q.insert(-30);
    q.insert(30);
    q.insert(40);
    q.insert(0);
    q.display();

    System.out.println(q.peekFront());
    System.out.println(q.peekRear());
    System.out.println(q.poll());
    
    q.poll();
    q.display();
    q.insert(40);
    q.poll();
    q.display();

    q.insert(23);
    q.display();
  }
}