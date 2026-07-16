class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        int r= nums.length -1;
        int[] arr = new int[nums.length];
        for(int j = nums.length -1; j >= 0; j--) {
            if(nums[l]*nums[l] >= nums[r]*nums[r]) {
                arr[j] = nums[l]*nums[l];
                l++;
            } else {
                arr[j] = nums[r]*nums[r];
                r--;
            }
        }
        return arr;
    }
}