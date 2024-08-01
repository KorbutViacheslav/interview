package innerClass;

public class OuterClass {
    public class InnerClass{
        String nameInnerClass = "InnerClassName";
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.InnerClass ic = oc.new InnerClass();
        System.out.println(ic.nameInnerClass);
    }
}
