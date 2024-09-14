int rob(int* nums, int n) {
    int arr[n+1];
    if(n == 0){
        return 0;
    }
    if(n == 1){
        return nums[0];
    }
    arr[0] = nums[0];
    arr[1] = max(nums[1],nums[0]);
    for(int i = 2;i<n;i++){
        arr[i] = max(arr[i-1],nums[i]+arr[i-2]);
    }
    return arr[n-1];

}

int max(int a,int b){
    return a >= b ? a : b;
}