class TimeMap {
    Map<String, TreeMap<Integer, String>> data;

    public TimeMap() {
        data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        var valueMap = data.getOrDefault(key, new TreeMap<Integer, String>());
        valueMap.put(timestamp, value);
        data.put(key, valueMap);
    }
    
    public String get(String key, int timestamp) {
        var valueMap = data.get(key);
        if (valueMap == null) {
            return "";
        }

        var floor = valueMap.floorKey(timestamp);
        return floor == null ? "" : valueMap.get(floor);
    }
}
