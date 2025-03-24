class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> set = new HashSet<>();
        int n = rooms.size();
        for(int i = 0;i<n;i++){
            set.add(i);
        }

        Queue<Integer> queu = new LinkedList<>();
        queu.add(0);
        while(!queu.isEmpty() && !set.isEmpty()){
            int i = queu.poll();
            set.remove(i);
            for(int j :rooms.get(i)){
                if(set.contains(j)){
                    queu.add(j);
                }
            }
        }
        return set.isEmpty();
    }
}