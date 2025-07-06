class FindSumPairs {
    Map<Integer,Integer> map = new HashMap<>();
    int[] arr1;
    int[] arr2;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.arr1 = nums1;
        this.arr2 = nums2;
        for(int i:nums2){
            map.put(i,map.getOrDefault(i,0)+1);
        }
    }
    
    public void add(int index, int val) {
        int prev = arr2[index];
        map.put(prev,map.get(prev)-1);
        prev += val;
        arr2[index] = prev;
        map.put(prev,map.getOrDefault(prev,0)+1);
    }
    
    public int count(int tot) {
        int cnt = 0;
        for(int i:arr1){
            cnt += map.getOrDefault(tot-i,0);
        }
        return cnt;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */