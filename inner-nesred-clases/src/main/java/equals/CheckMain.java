package equals;

public class CheckMain {
    public static void main(String[] args) {
        Address address = new Address("YourCountry", "YourCity");
        PostalAddress postalAddress = new PostalAddress("YourCountry", "YourCity");

        //Отримуємо hashCode двох об'єктів
        var addressHash = address.hashCode();
        var postalHash = postalAddress.hashCode();

        //Порівнюємо отримані hashCode
        boolean booleanHash = addressHash == postalHash;

        //Порівнюємо об'єкти
        boolean booleanEquals = address.equals(postalAddress);
        System.out.println("Address hashCode: " + addressHash +
                "\nPostalAddress: " + postalHash +
                "\nBooleanHash: " + booleanHash +
                "\nBooleanEquals: " + booleanEquals);
    }
}
