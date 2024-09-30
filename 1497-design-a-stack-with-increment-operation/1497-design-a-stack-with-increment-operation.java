class CustomStack {
    int[] arr;
    int front  = 0;
    int size;

    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
        this.size = maxSize;
    }
    
    public void push(int x) {
        if(front+1 > size){
            return;
        }
        arr[front++] = x;
        // System.out.println(Arrays.toString(arr));
    }
    
    public int pop() {
        if(front-1 < 0) return -1;
        // System.out.println(Arrays.toString(arr));
        return arr[--front];
        
    }
    
    public void increment(int k, int val) {
        for(int i =0;i<Math.min(k,size);i++){
            arr[i] += val;
        }
        // System.out.println(Arrays.toString(arr));
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */