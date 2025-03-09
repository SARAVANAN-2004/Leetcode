class Solution {
    public List<Boolean> kidsWithCandies(int[] arr, int extra) {
        int max = arr[0];
        for(int i:arr){
            max = Math.max(i,max);
        }
        List<Boolean> res = new ArrayList<>();
        for(int i:arr){
            if(i+extra >= max){
                res.add(true);
            }else{
                res.add(false);
            }
        }
        return res;
    }
}