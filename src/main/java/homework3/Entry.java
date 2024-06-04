package homework3;
 // Used from HM1
public class Entry implements Comparable<Entry> {
    private String surname;
    private String name;
    private String streetAddress;
    private String city;
    private String postcode;
    private String country;
    private String phoneNumber;

    public Entry(String surname,String name, String streetAddress, String city, String postcode, String country, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.postcode = postcode;
        this.country = country;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return surname + ", "+name;
    }

    @Override
    public int compareTo(Entry other) {
        return this.getName().compareTo(other.getName());
    }

    @Override
    public String toString() {
        return surname + ", " + name + ", " + streetAddress + ", " + city + ", " + postcode + ", " + country + ", " + phoneNumber;
    }
}