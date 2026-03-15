class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2= nums2.length;
        if(n1>n2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left = (n1+n2+1)/2;
        int low = 0;
        int high = n1;
        while(low<=high){
            int mid = (low+high)/2;
            int ind1 = mid-1;
            int ind2 = left-mid-1;
            int indr1 = mid;
            int indr2 = ind2+1;

            int l1 = Integer.MIN_VALUE;
            int l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE;
            int r2 = Integer.MAX_VALUE;

            if(ind1>=0){
                l1 = nums1[ind1];
            }
            if(ind2>=0){
                l2 = nums2[ind2];
            }
            if(indr1<n1){
                r1 = nums1[indr1];
            }
            if(indr2<n2){
                r2 = nums2[indr2];
            }

            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2==1){
                    return (double) Math.max(l1,l2);
                }
                else{
                    return (double) (Math.max(l1,l2)+Math.min(r1,r2))/2.0;
                }
            }
            else if(l1>r2){
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return 0.0;
    }
}