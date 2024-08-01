package equals;

import java.util.Objects;

public class PostalAddress {
    String street;
    String postalBox;
    int number;

    public PostalAddress(String street, String postalBox, int number) {
        this.street = street;
        this.postalBox = postalBox;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostalAddress that = (PostalAddress) o;
        return number == that.number && Objects.equals(street, that.street) && Objects.equals(postalBox, that.postalBox);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(street);
        result = 31 * result + Objects.hashCode(postalBox);
        result = 31 * result + number;
        return result;
    }
}
