package abstractClasses;

interface X {
    int product(int x, int y);
}

abstract class Product implements X {

    public int product(int x, int y) {
        return x * y;
    }
}

class GFG extends Product {
    public static void main(String[] args) {
        GFG ob = new GFG();
        int p = ob.product(20, 10);
        System.out.println("Product: " + p);
    }
}
