package equals;

import java.util.Objects;

public class Address {
    String country;
    String city;
    int number;

    public Address(String country, String city, int number) {
        this.country = country;
        this.city = city;
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;
        return number == address.number && Objects.equals(country, address.country) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(country);
        result = 31 * result + Objects.hashCode(city);
        result = 31 * result + number;
        return result;
    }
}
