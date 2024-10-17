class Solution {
    public int maximumSwap(int num) {
       List<Integer> arr = new ArrayList<>();
       int x = num;
       while(x > 0){
        arr.add(x%10);
        x/=10;
       }
       int idx  = -1;
       int idy = -1;
       int max = -1;
        for(int i = 0;i<arr.size();i++){
            if(max == -1 || arr.get(max) < arr.get(i)){
                max = i;
            }else if(arr.get(max) > arr.get(i)){
                idx = max;
                idy = i;
            }
        }
        if(idx != -1 && idy != -1){
            int temp = arr.get(idx);
            arr.set(idx,arr.get(idy));
            arr.set(idy,temp);
        }


        int sum = 0;
       for(int i = arr.size()-1;i>=0;i--){
        sum *= 10;
        sum += arr.get(i);
       }

       return sum;
    }
}