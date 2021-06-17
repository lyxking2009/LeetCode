class TargetSum {
    int len;
    
    public int findTargetSumWays(int[] nums, int target) {
        HashMap<Integer, Integer> sumFreq = new HashMap<>();
        len = nums.length;
        sumFreq = updateFreq(sumFreq, nums, 0);
        return sumFreq.getOrDefault(target, 0);
    }
    
    public HashMap<Integer, Integer> updateFreq(HashMap<Integer, Integer> sumFreq, int[] nums, int idx) {
        if (idx == len)
            return sumFreq;
        HashMap<Integer, Integer> newSumFreq = new HashMap<>();
        if (sumFreq.isEmpty()) {
            newSumFreq.put(nums[idx], 1);
            newSumFreq.put(-nums[idx], newSumFreq.getOrDefault(-nums[idx], 0) + 1);
        } else {
            for (int curSum : sumFreq.keySet()) {
                newSumFreq.put(curSum + nums[idx], newSumFreq.getOrDefault(curSum + nums[idx], 0) + sumFreq.get(curSum));
                newSumFreq.put(curSum - nums[idx], newSumFreq.getOrDefault(curSum - nums[idx], 0) + sumFreq.get(curSum));
            }
        }
        newSumFreq = updateFreq(newSumFreq, nums, idx + 1);
        return newSumFreq;
    }
}