import java.util.Arrays;

public class AllExampleBigO {
    public static void main(String[] args) {
        //Константа - О(1)
        System.out.println(Constant.sum(2,5));
        System.out.println(Constant.isEven(3));

        //Логарифмічна - О(log N). Злиття
        int[] ar1 = {1,3,5,7};
        int[] ar2 = {2,4,6,8};
        Arrays.stream(Logarithmic.merge(ar1,ar2)).forEach(System.out::print);
        System.out.println("\nTarget index: "+Logarithmic.binarySearch(ar1,5));

        //Лінійна - О(N)
        System.out.println("\nLinear Target index: "+Linear.linearSearch(ar2,6));
        System.out.println("\nSum of array: "+Linear.sumArrayElements(ar1));
        int[] arrev = {2,4,6,8};
        Linear.reverseArray(arrev);
        Arrays.stream(arrev).forEach(System.out::print);
    }

}
