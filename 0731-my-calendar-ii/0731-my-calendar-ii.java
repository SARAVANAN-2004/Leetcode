class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlap;
    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlap = new ArrayList<>();
    }
    private boolean doesOverLap(int st1,int en1,int st2,int en2){
        return Math.max(st1,st2) < Math.min(en1,en2);
    }
    private int[] getOverLap(int st1,int en1,int st2,int en2){
        return new int[]{Math.max(st1,st2) , Math.min(en1,en2)};
    }
    
    public boolean book(int start, int end) {
        for(int[] book:overlap){
            if(doesOverLap(book[0],book[1],start,end)){
                return false;
            }
        }
        for(int[] book:bookings){
            if(doesOverLap(book[0],book[1],start,end)){
                overlap.add(getOverLap(book[0],book[1],start,end));
            }
        }

        bookings.add(new int[]{start,end});
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */