import java.util.Arrays;

class largeProduct3 {
    public double solution(double[] A) {
        int result1, result2;

        Arrays.sort(A);
        result1 = A[0] * A[1] * A[A.length-1];
        result2 = A[A.length-1] * A[A.length-2] * A[A.length-3];

        if (result1 >= result2) return result1;
        else return result2;

    }
    
    public static void main(String[] args)
    {
        
        double[] given = new double[
}