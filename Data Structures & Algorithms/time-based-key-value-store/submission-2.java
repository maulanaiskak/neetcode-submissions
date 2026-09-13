class TimeMap {
    private Map<String, List<TimeValue>> map;

    private class TimeValue {
        int timestamp;
        String value;

        TimeValue(int timestamp, String value) {
            this.timestamp = timestamp;
            this.value = value;
        }
    }

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        var timeValue = new TimeValue(timestamp, value);

        if (!map.containsKey(key)) {;
            map.put(key, new ArrayList<>(List.of(timeValue)));
            return;
        }

        var timeValues = map.get(key).add(timeValue);
    }
    
    public String get(String key, int timestamp) {
        var timeValues = map.get(key);
        if (timeValues == null || timeValues.size() == 0) {
            return "";
        }

        var left = 0;
        var right = timeValues.size() - 1;

        while (left <= right) {
            var mid = (left + right) / 2;
            var timeValue = timeValues.get(mid);

            if (timeValue.timestamp == timestamp) {
                return timeValue.value;
            }

            if (timeValue.timestamp < timestamp) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right >= 0 ? timeValues.get(right).value : "";
    }
}
