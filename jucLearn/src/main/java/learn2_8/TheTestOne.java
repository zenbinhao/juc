package learn2_8;

public class TheTestOne {
    public static void main(String[] args) {

        int []A = new int[]{1,0,2,4,8,9};
        int i = firstMissingPositive(A);
        System.out.println(i);
    }
    public static int firstMissingPositive (int[] A) {
        // write code here
        int temp= 0;
        one:for(int i=1;i<=A.length;i++){
            two:for(int j=0;j<A.length;j++){
                if(A[j]==i){
                    temp++;
                    continue one;
                }
            }
            if(temp!=i){
                return temp+1;
            }
        }
        return temp+1;
    }
}
