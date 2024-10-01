class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            int remainder = (i % k + k) % k; 
            map.put(remainder, map.getOrDefault(remainder, 0) + 1);
            set.add(remainder);

        }
        System.out.println(map);
        for(int n:set){

            if(n == 0){
                if(map.get(n) % 2 != 0){
                    return false;
                }
            }
            else if(!set.contains(k-n)){
                return false;
            }
            else{
                if(!map.get(n).equals(map.get(k-n))){
                    return false;
                }
            }
        }
        
        return true;
    }
}