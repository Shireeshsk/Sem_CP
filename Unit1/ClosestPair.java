public class ClosestPair {
    public static int[] helper(int arr1[],int arr2[],int num){
        int i = 0;
        int j = arr2.length-1;
        int diff = Integer.MAX_VALUE;
        int res1=0;
        int res2=0;
        while(i<arr1.length && j>=0){
            int sum = arr1[i] + arr2[j];
            int temp = Math.abs(sum-num);
            if(temp<diff){
                res1 = i;
                res2 = j;
                diff = temp;
            }
            if(sum>num){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{arr1[res1],arr2[res2]};
    }

    public static void main(String[] args) {
        int[] ar1 = {1, 4, 5, 7};
        int[] ar2 = {10, 20, 30, 40};
        int x1 = 32;
        int x2 = 50;

        int[] result1 = helper(ar1, ar2, x1);
        System.out.println("Closest pair to " + x1 + ": " + result1[0] + " and " + result1[1]);

        int[] result2 = helper(ar1, ar2, x2);
        System.out.println("Closest pair to " + x2 + ": " + result2[0] + " and " + result2[1]);
    }
}
