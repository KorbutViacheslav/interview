import java.util.Arrays;

class EnumExample1 {
    //defining the enum inside the class
    public enum Season {WINTER, SPRING, SUMMER, FALL}

    //main method
    public static void main(String[] args) {
        //traversing the enum
        for (Season s : Season.values())
            System.out.println(s);

        //use values() method
        Arrays.stream(Season.values()).forEach(System.out::println);

        //use valueOf() method
        System.out.println("Value of WINTER is: "+Season.valueOf("WINTER"));

        //use ordinal
        System.out.println("Index of WINTER is: "+Season.valueOf("WINTER").ordinal());
    }
}
