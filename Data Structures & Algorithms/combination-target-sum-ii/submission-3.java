class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(0, candidates, target, new ArrayList<>());
        return result;
    }

    private void backtrack(int index, int[] candidates, int remaining, List<Integer> current) {
        if (remaining < 0) {
            return;
        }

        if (remaining == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (var i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] > remaining) {
                break;
            }
            
            current.add(candidates[i]);
            backtrack(i + 1, candidates, remaining - candidates[i], current);
            current.remove(current.size() - 1);
        }
    }
}
