class Solution {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> comb = new LinkedList<>();
        
        backtrack(candidates, target, comb, 0, result);
        
        return result;
    }
    
    public void backtrack(int[] candidates, int target, LinkedList<Integer> comb, int start, List<List<Integer>> result) {
        if(target == 0) {
            // make a deep copy of the current combination
            result.add(new ArrayList<Integer>(comb));
            return;
        } else if (target < 0) {
            // exceed the scope, stop exploration
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            // add the number into the combination 
            comb.add(candidates[i]);
            backtrack(candidates, target - candidates[i], comb, i, result);
            // backtrack, remove the number from the combination 
            comb.removeLast();
        }   
    }
}


