class Solution {
    public int takeCharacters(String s, int k) { 
        HashMap<Integer,Integer>map_a=new HashMap<>();
        HashMap<Integer,Integer>map_b=new HashMap<>();
        HashMap<Integer,Integer>map_c=new HashMap<>();
        int n=s.length();
        int count=0;
        map_a.put(0,n);
        map_b.put(0,n);
        map_c.put(0,n);
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='a'){
                count++;
                map_a.put(count,i);
            }
        }
        int count2=0;
        int count3=0;
         for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='b'){
                count2++;
                map_b.put(count2,i);
            }
        }
         for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='c'){
                count3++;
                map_c.put(count3,i);
            }
        }
         if(k==0){
            return 0;
        }
        if(count<k||count2<k||count3<k){
            return -1;
        }
        int ca=0;
        int cb=0;
        int cc=0;
        int ans=-1;
        ans=n-Math.min(map_a.get(Math.max(0,k-ca)),Math.min(map_b.get(Math.max(0,k-cb)),map_c.get(Math.max(0,k-cc))));
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)=='a'){
                ca++;
            }else if(s.charAt(i)=='b'){
                cb++;
            }else{
                cc++;
            }
            ans=Math.min(ans,i+1+n-Math.min(map_a.get(Math.max(0,k-ca)),Math.min(map_b.get(Math.max(0,k-cb)),map_c.get(Math.max(0,k-cc)))));
        }
        return ans;        
    }
}