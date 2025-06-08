class Solution {
    List<Integer> arr = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        int num = 1;
        solve(num,n);
        return arr;
    }

    void solve(int num,int n){
        if(num  > n) return;
        arr.add(num);
        solve(num *10,n);
        for(int i = 0;i<9;i++){
            num++;
            if(num > n){
                return;
            }
            if(num %10 != 0){
                arr.add(num);
                solve(num*10,n);
            }
        }
    }
}