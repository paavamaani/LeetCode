#https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int findFirstIndex(int[] nums, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target && (mid == 0 || nums[mid - 1] < target)) {
                return mid;
            }
            else if(nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int findLastIndex(int[] nums, int target, int low, int high) {
        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target)) {
                return mid;
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int len = nums.length - 1;

        if(nums == null || nums.length == 0 || nums[0] > target || nums[len] < target) {
            return new int[]{-1, -1};
        }
        int firstIndex = findFirstIndex(nums, target, 0, len);

        if(firstIndex == -1) {
            return new int[]{-1, -1};
        }
        
        int lastIndex = findLastIndex(nums, target, firstIndex, len);

        return new int[]{firstIndex, lastIndex};
    }
}