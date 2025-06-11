class NumArray {
    int[] si;
    int n;
    int[] arr;
    public NumArray(int[] nums) {
        
        n = nums.length;
        si = new int[4*n];
        arr = Arrays.copyOf(nums,n);
        int sum = constructSegment(0,0,nums.length-1);
        // System.out.println(Arrays.toString(si));
    }

    int constructSegment(int i,int sl,int sr){
        if(sl == sr){
            si[i] = arr[sl];
            return si[i];
        }
        int mid = (sl+sr)/2;
        si[i] = constructSegment(2*i+1,sl,mid) + constructSegment(2*i+2,mid+1,sr);
        return si[i];

    }
    
    public void update(int index, int val) {
        int diff = val  - arr[index];
        arr[index] = val;
        update(0,0,n-1,index,diff);
    }
    void update(int i,int sl,int sr,int pos,int diff){
        if(sl > pos || sr < pos) return;

        si[i] += diff;
        if(sr != sl){
            int mid = (sl+sr)/2;
            update(2*i+1,sl,mid,pos,diff);
            update(2*i+2,mid+1,sr,pos,diff);
        }
    }
    
    public int sumRange(int left, int right) {
       return getSum(0,0,n-1,left,right);
    }

    int getSum(int i,int sl,int sr,int l,int r){
        if(l <= sl && r >= sr){
            return si[i];
        }
        if(sr < l || sl > r) return 0;

        int mid = (sl+sr)/2;
        return getSum(2*i+1,sl,mid,l,r) + getSum(2*i+2,mid+1,sr,l,r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */