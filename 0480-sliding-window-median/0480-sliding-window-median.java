class Solution {
    class Median{
        record E(long num,int idx){}
        TreeSet<E> left,right;
        Median(){
            left = new TreeSet<E>(Comparator.comparing(E::num).reversed().thenComparing(E::idx));
            right = new TreeSet<E>(Comparator.comparing(E::num).thenComparing(E::idx));
        }

        void add(long num,int idx){
            if(left.size() == right.size()){
                left.add(new E(num,idx));
                right.add(left.pollFirst());
            }else{
                right.add(new E(num,idx));
                left.add(right.pollFirst());
            }
        }
        void remove(long num,int idx){
            if(!left.remove(new E(num,idx))){
                right.remove(new E(num,idx));
            }

            if(left.size() > right.size()){
                right.add(left.pollFirst());
            }else if(right.size() > left.size()+1){
                left.add(right.pollFirst());
            }
        }

        double median(){
            if(left.size() == right.size()){
                return (left.first().num + right.first().num)/2.0;
            }
            return right.first().num;
        }

    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        Median mf = new Median();
        int n = nums.length;
        double[] res = new double[n - k+1];
        for(int i = 0;i<k;i++){
            mf.add(nums[i],i);
        }
        res[0] = mf.median();
        int idx = 1;
        for(int i = k;i<n;i++){
            mf.add(nums[i],i);
            mf.remove(nums[i-k],i-k);
            res[idx++] = mf.median();
        }
        return res;
    }
}