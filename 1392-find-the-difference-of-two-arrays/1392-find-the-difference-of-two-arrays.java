class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        fill(set1,nums1);
        Set<Integer> set2 = new HashSet<>();
        fill(set2,nums2);
        Set<Integer> diff = new HashSet<>(set1);
        diff.retainAll(set2);
        for(int i:diff){
            set2.remove(i);
            set1.remove(i);
        }


        List<List<Integer>>  ans = new ArrayList<>();
        // List<Integer> temp = ;
        ans.add(new ArrayList<>(set1));
        ans.add(new ArrayList<>(set2));
        return ans;
        
    }
    void fill(Set<Integer> set,int[] num){
        for(int i:num){
            set.add(i);
        }
    }
}