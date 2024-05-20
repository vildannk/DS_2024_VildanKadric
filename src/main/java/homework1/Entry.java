package homework1;

public class Entry implements Comparable<Entry> {
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Entry other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Street address: " + streetAddress + "\n" +
                "City: " + city + "\n" +
                "Postalcode: " + postcode + "\n" +
                "Country: " + country + "\n" +
                "Phone number: " + phoneNumber + "\n";
    }
}