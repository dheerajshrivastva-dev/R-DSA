class FrontMiddleBackQueue {
    Deque<Integer> left;
    Deque<Integer> right;
    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }

    void balance() {
        if(right.size() > left.size()) {
            left.offerLast(right.pollFirst());
        }
    }
    void unBalance() {
        if(left.size() > right.size()) {
            right.offerFirst(left.pollLast());
        }
    }
    
    public void pushFront(int val) {
        if(left.isEmpty()) {
            left.offerFirst(val);
        } else {
            right.offerLast(val);
            this.balance();
        }
        return;
    }
    
    public void pushMiddle(int val) {
        this.unBalance();
        left.offerLast(val);
        return;
    }
    
    public void pushBack(int val) {
        if(right.isEmpty()) {
            right.offerLast(val);
        } else {
            this.unBalance();
            left.offerFirst(val);
            this.balance();
        }
        return;
    }
    
    public int popFront() {
        if(left.isEmpty() && right.isEmpty()) {
            return -1;
        } else {
            System.out.println(Arrays.toString(left.toArray()) + " " + Arrays.toString(right.toArray()));
            this.unBalance();
            return right.pollLast();
        }
    }
    
    public int popMiddle() {
        if(left.isEmpty() && right.isEmpty()) {
            return -1;
        } else {
            System.out.println(Arrays.toString(left.toArray()) + " " + Arrays.toString(right.toArray()));
            this.balance();
            return left.pollLast();
        }
    }
    
    public int popBack() {
        if(left.isEmpty() && right.isEmpty()) {
            return -1;
        } else {
            System.out.println(Arrays.toString(left.toArray()) + " " + Arrays.toString(right.toArray()));
            this.balance();
            return left.pollFirst();
        }
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */