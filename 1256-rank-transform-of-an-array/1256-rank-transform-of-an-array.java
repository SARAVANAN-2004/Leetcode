class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int[] num = new int[n];
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<n;i++){
            num[i] =arr[i];
        }

        Arrays.sort(num);
        int rank = 1;
        for(int i:num){
            if(!map.containsKey(i)){
                map.put(i,rank++);
            }
        }

        for(int i = 0;i<n;i++){
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }


}