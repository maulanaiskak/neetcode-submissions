class Solution {
    private Map<Integer, Set<Integer>> map = new HashMap<>();
    private List<Integer> courses = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (var prereq : prerequisites) {
            map.computeIfAbsent(prereq[1], k -> new HashSet<>()).add(prereq[0]);
        }

        var state = new int[numCourses];
        for (var i = 0; i < state.length; i++) {
            if (hasCycle(i, state)) {
                return new int[0];
            }
        }

        return courses.reversed().stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean hasCycle(int course, int[] state) {
        if (state[course] == 1) {
            return true;
        }

        if (state[course] == 2) {
            return false;
        }

        state[course] = 1;

        var prereq = map.get(course);
        if (prereq != null) {
            for (var pre : prereq) {
                if (hasCycle(pre, state)) {
                    return true;
                }
            }
        }

        state[course] = 2;
        courses.add(course);
        return false;
    }
}
