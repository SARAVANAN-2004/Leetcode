class Solution {
    public boolean checkIfExist(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for(int i = 0;i<arr.length;i++){
            if(map.getOrDefault(arr[i]*2,i) != i){
                return true;
            }
            // set.add(arr[i]);
        }
        return false;
    }
}