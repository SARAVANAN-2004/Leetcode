class Solution {
    public String intToRoman(int num) {
        Map<Integer,Character> map = new HashMap<>();
        map.put(1,'I');
        map.put(5,'V');
        map.put(10,'X');
        map.put(50,'L');
        map.put(100,'C');
        map.put(500,'D');
        map.put(1000,'M');
        StringBuilder str = new StringBuilder();
        int place = 1;
        while(num > 0){

            int n = num%10;
            num /= 10;
            if(n == 0){
                place *= 10;
                continue;
            }
            if(n == 4){
                str.append(map.get(5 * place));
                str.append(map.get(place));
            }else if(n == 9){
                str.append(map.get(10 * place));
                str.append(map.get(place));
            }else{
                for(int i = 0;i<n%5;i++){
                    str.append(map.get(place));
                }
                if(n - (n%5) != 0) str.append(map.get((n - n%5) * place));
            }

            place *= 10;

        }

        str.reverse();
        return str.toString();
    }
}