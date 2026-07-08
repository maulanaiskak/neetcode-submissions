class Solution {

    public int[] findOrder(final int numCourses, final int[][] prerequisites) {

        final var graph = new ArrayList<List<Integer>>();
        final var indegree = new int[numCourses];

        for (var course = 0; course < numCourses; course++) {
            graph.add(new ArrayList<>());
        }

        for (final var prerequisite : prerequisites) {
            final var course = prerequisite[0];
            final var prerequisiteCourse = prerequisite[1];

            graph.get(prerequisiteCourse).add(course);
            indegree[course]++;
        }

        final Queue<Integer> queue = new ArrayDeque<>();

        for (var course = 0; course < numCourses; course++) {
            if (indegree[course] == 0) {
                queue.offer(course);
            }
        }

        final var order = new int[numCourses];
        var index = 0;

        while (!queue.isEmpty()) {
            final var course = queue.poll();
            order[index++] = course;

            for (final var nextCourse : graph.get(course)) {
                indegree[nextCourse]--;

                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }
}