package persona;


/**
 * Class Address with Persona address details.
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

    /**
     * class constructor
     */
    public Address(){}

    /**
     * @param street name
     * @param city name
     * @param zipCode of region
     * @param country name
     * @param contactPhone number
     */
    public Address(String street, String city, String zipCode, String country, int contactPhone) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.country = country;
        this.contactPhone = contactPhone;
    }

    /**
     * @return street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return contact phone number
     */
    public int getContactPhone() {
        return contactPhone;
    }

    /**
     * @param contactPhone to set
     */
    public void setContactPhone(int contactPhone) {
        this.contactPhone = contactPhone;
    }
}