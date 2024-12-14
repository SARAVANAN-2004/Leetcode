class MedianFinder {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    
    public MedianFinder() {
        left = new PriorityQueue<>();
        right = new PriorityQueue<>(Collections.reverseOrder());

    }
    
    public void addNum(int num) {
        if(left.size() == right.size()){
            left.add(num);
            right.add(left.poll());
        }else{
            right.add(num);
            left.add(right.poll());
        }
    }
    
    public double findMedian() {
        if(left.size() == right.size()){
            return (left.peek()+right.peek())/2.0;
        }
        return right.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */