package persona;


/**
 * Write a description of class Address here.
 * 
 * @author Juan Sebastian Flor Usma
 * @version 1.0.0
 */
public class Address {
    private String street;
    private String city;
    private String zipCode;
    private String country;
    private int contactPhone;

    public Address(){}

    public Address(String street, String city, String zipCode, String country, int contactPhone) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.contactPhone = contactPhone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }
}