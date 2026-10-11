class Solution {
    private Map<Integer, Set<Integer>> map = new HashMap<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (var prereq : prerequisites) {
            var value = map.computeIfAbsent(prereq[1], key -> new HashSet<>());
            value.add(prereq[0]);
        }

        var state = new int[numCourses];

        for (var i = 0; i < numCourses; i++) {
            if (hasCycle(i, state)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int course, int[] state) {
        if (state[course] == 1) {
            return true;
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        var value = map.get(course);
        if (value == null) {
            state[course] = 2;
            return false;
        }

        for (int next : value) {
            if (hasCycle(next, state)) {
                return true;
            }
        }

        state[course] = 2;
        return false;
    }
}
