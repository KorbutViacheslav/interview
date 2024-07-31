package equals;

import java.util.Objects;

public class PostalAddress {
    String street;
    String postalBox;

    public PostalAddress(String street, String postalBox) {
        this.street = street;
        this.postalBox = postalBox;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostalAddress that = (PostalAddress) o;
        return Objects.equals(street, that.street) && Objects.equals(postalBox, that.postalBox);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, postalBox);
    }
}
