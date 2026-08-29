class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search the smaller array
        if(nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0;
        int high = m;

        int half = (m + n + 1) / 2;

        while(low <= high) {

            int cut1 = low + (high - low) / 2;
            int cut2 = half - cut1;

            int left1;
            int right1;
            int left2;
            int right2;

            if(cut1 == 0) {
                left1 = Integer.MIN_VALUE;
            } else {
                left1 = nums1[cut1 - 1];
            }

            if(cut1 == m) {
                right1 = Integer.MAX_VALUE;
            } else {
                right1 = nums1[cut1];
            }

            if(cut2 == 0) {
                left2 = Integer.MIN_VALUE;
            } else {
                left2 = nums2[cut2 - 1];
            }

            if(cut2 == n) {
                right2 = Integer.MAX_VALUE;
            } else {
                right2 = nums2[cut2];
            }

            // Correct partition
            if(left1 <= right2 && left2 <= right1) {

                // Odd total length
                if((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }

                // Even total length
                int leftMax = Math.max(left1, left2);
                int rightMin = Math.min(right1, right2);

                return (leftMax + rightMin) / 2.0;
            }

            // Too many elements taken from nums1
            else if(left1 > right2) {
                high = cut1 - 1;
            }

            // Too few elements taken from nums1
            else {
                low = cut1 + 1;
            }
        }

        return 0.0;
    }
}