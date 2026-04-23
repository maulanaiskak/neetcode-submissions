class TimeMap {
    Map<String, List<String>> values;
    Map<String, List<Integer>> timestamps;

    public TimeMap() {
        values = new HashMap<>();
        timestamps = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        timestamps.computeIfAbsent(key, k -> new ArrayList<>()).add(timestamp);
        values.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }
    
    public String get(String key, int timestamp) {
        if (!values.containsKey(key)) {
            return "";
        }

        var ts = timestamps.get(key);
        var left = 0;
        var right = ts.size() - 1;
        var idx = -1;

        while (left <= right) {
            var mid = left + (right - left) / 2;

            if (ts.get(mid) <= timestamp) {
                idx = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return idx == -1 ? "" : values.get(key).get(idx);
    }
}
