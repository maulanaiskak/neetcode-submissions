class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        var courseMap = new HashMap<Integer, List<Integer>>();
        var status = new int[numCourses];

        for (var prerequisite : prerequisites) {
            courseMap.computeIfAbsent(prerequisite[0], k -> new ArrayList<>()).add(prerequisite[1]);
        }

        for (var i = 0; i < numCourses; i++) {
            if (!dfs(courseMap, i, status)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> courseMap, int idx, int[] status) {
        if (status[idx] == 1) {
            return false;
        }

        if (status[idx] == 2) {
            return true;
        }

        status[idx] = 1;

        for (var course : courseMap.getOrDefault(idx, new ArrayList<>())) {
            if (!dfs(courseMap, course, status)) {
                return false;
            }
        }

        status[idx] = 2;

        return true;
    }
}
