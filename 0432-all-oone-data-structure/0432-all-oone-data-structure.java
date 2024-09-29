class AllOne {
    Map<Integer, Set<String>> cnt_map;
    Map<String, Integer> map;
    int max_key = 0;
    int min_key = Integer.MAX_VALUE;

    public AllOne() {
        this.map = new HashMap<>();
        this.cnt_map = new HashMap<>();
    }

    public void inc(String key) {
        int cnt = map.getOrDefault(key, 0);
        if (cnt > 0) {
            // Remove the key from the current count set
            cnt_map.get(cnt).remove(key);
            if (cnt_map.get(cnt).isEmpty()) {
                cnt_map.remove(cnt);
                if (cnt == min_key) {
                    min_key++;
                }
            }
        }

        // Increment the key's count
        cnt++;
        map.put(key, cnt);

        // Add the key to the new count set
        cnt_map.putIfAbsent(cnt, new HashSet<>());
        cnt_map.get(cnt).add(key);

        // Update max_key and min_key
        max_key = Math.max(max_key, cnt);
        min_key = Math.min(min_key, cnt);

        // printState(key);
    }

    public void dec(String key) {
    int cnt = map.get(key);
    // Remove the key from the current count set
    cnt_map.get(cnt).remove(key);
    if (cnt_map.get(cnt).isEmpty()) {
        cnt_map.remove(cnt);
        if (cnt == max_key) {
            max_key--;
        }
        // If the current count is the minimum key, we need to find the new min_key
        if (cnt == min_key) {
            min_key++;
        }
    }

    if (cnt == 1) {
        // If the count becomes 0, remove the key entirely
        map.remove(key);
        if (map.isEmpty()) {
            // Reset max_key and min_key if map is empty
            max_key = 0;
            min_key = Integer.MAX_VALUE;
        }
    } else {
        // Decrement the count
        cnt--;
        map.put(key, cnt);
        cnt_map.putIfAbsent(cnt, new HashSet<>());
        cnt_map.get(cnt).add(key);
        
        // Update min_key if necessary
        if (cnt < min_key) {
            min_key = cnt;
        }
    }

    // printState(key);
}


    // Utility to print the state after each operation
    private void printState(String key) {
        System.out.println("Key: " + key);
        System.out.println("Map: " + map);
        System.out.println("Count Map: " + cnt_map);
        System.out.println("Max Key: " + max_key);
        System.out.println("Min Key: " + (map.isEmpty() ? "N/A" : min_key));
        System.out.println("-------------------");
    }
    
    public String getMaxKey() {
    while (max_key > 0 && (cnt_map.get(max_key) == null || cnt_map.get(max_key).isEmpty())) {
        max_key--;
    }

    if (cnt_map.containsKey(max_key) && !cnt_map.get(max_key).isEmpty()) {
        return cnt_map.get(max_key).iterator().next();
    }
    return "";
}

public String getMinKey() {
    while (min_key < Integer.MAX_VALUE && (cnt_map.get(min_key) == null || cnt_map.get(min_key).isEmpty())) {
        min_key++;
    }

    if (cnt_map.containsKey(min_key) && !cnt_map.get(min_key).isEmpty()) {
        return cnt_map.get(min_key).iterator().next();
    }
    return "";
}
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */