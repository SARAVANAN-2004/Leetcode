class Solution {
    public boolean isNStraightHand(int[] hand, int g) {
        if(g == 1) return true;
        if(hand.length % g != 0) return false;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        List<Integer> arr = new ArrayList<>(map.keySet());
        Collections.sort(arr);
        for(int i = 0;i<arr.size();){
            
            int num = arr.get(i);
            for(int j = 0;j<g;j++){
                
                if(!map.containsKey(num)){
                    return false;
                }
                map.put(num,map.get(num)-1);
                // System.out.println(num+" "+map+" "+map.get(arr.get(i)));
                if(map.get(num)==0){
                    map.remove(num);
                    if(arr.get(i) == num) i++;
                }
                num++;
            }
        }
        return true;
    }
}