package equals;

public class CheckMain {
    public static void main(String[] args) {
        Address address = new Address(new String("YourCountry"), "YourCity", 256);
        PostalAddress postalAddress = new PostalAddress("YourCountry", "YourCity", 256);

        //Отримуємо hashCode двох об'єктів
        var addressHash = address.hashCode();
        var postalHash = postalAddress.hashCode();

        //Порівнюємо отримані hashCode
        boolean booleanHash = addressHash == postalHash;

        //Порівнюємо об'єкти equals
        boolean booleanEquals = address.equals(postalAddress);
        System.out.println("Address hashCode: " + addressHash +
                "\nPostalAddress: " + postalHash +
                "\nBooleanHash: " + booleanHash +
                "\nBooleanEquals: " + booleanEquals);
    }
}
