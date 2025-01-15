/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {

    int findBitonic(MountainArray arr,int l,int r){
        int mid = (l+r)/2;
        int pre = arr.get(mid-1);
        int next = arr.get(mid+1);
        int middle = arr.get(mid);
        if(middle > pre && middle > next){
            return mid;
        }else if(middle > pre){
            return findBitonic(arr,mid,r);
        }
        return findBitonic(arr,l,mid);

    }
    public int findInMountainArray(int target, MountainArray arr) {
        int n = arr.length();
        int r = n-1,l = 0;
        int idx = findBitonic(arr,l,r);
        int temp = searchAscending(arr,l,idx,target);
        if(temp != -1){
            return temp;
        }
        return searchdescending(arr,idx+1,r,target);
        
    }

    int searchAscending(MountainArray arr,int l,int r,int target){
        while(l <= r){
            int  m = (l+r)/2;
            int mid = arr.get(m);
            if(mid == target){
                return m;
            }
            if(mid < target){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return -1;
    }
    int searchdescending(MountainArray arr,int l,int r,int target){
        while(l <= r){
            int  m = (l+r)/2;
            int mid = arr.get(m);
            if(mid == target){
                return m;
            }
            if(mid > target){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return -1;
    }
}