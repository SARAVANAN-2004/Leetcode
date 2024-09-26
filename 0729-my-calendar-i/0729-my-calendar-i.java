class MyCalendar {
    List<int[] > arr;
    public MyCalendar() {
        this.arr =new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        for(int[] ans:arr){
            if(ans[0] < end && ans[1] > start){
                return false;
            }
        }
        arr.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */