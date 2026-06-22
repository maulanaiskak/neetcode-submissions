class Solution {

    private Map<Integer, List<Integer>> graph = new HashMap<>();
    private int[] state;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        state = new int[numCourses];

        for (var courses : prerequisites) {
            graph.computeIfAbsent(courses[1], k -> new ArrayList<>())
                 .add(courses[0]);
        }

        for (int course = 0; course < numCourses; course++) {
            if (dfs(course)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course) {

        if (state[course] == 1) {
            return true; // cycle
        }

        if (state[course] == 2) {
            return false; // already checked
        }

        state[course] = 1;

        for (int nextCourse : graph.getOrDefault(course, Collections.emptyList())) {
            if (dfs(nextCourse)) {
                return true;
            }
        }

        state[course] = 2;

        return false;
    }
}