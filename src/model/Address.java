package model;

/**
 * Represents a house's address
 * @version 1.0
 * @since 1.0
 */
public class Address {
    private String house_num;
    private String street;
    private String quadrant;
    private String city;
    private String province;
    private String country;

    /**
     * 
     * @return  this house's number
     */
    public String getHouseNum() {
        return this.house_num;
    }

    /**
     * 
     * @return this house's street location
     */
    public String getStreet() {
        return this.street;
    }

    /**
     * 
     * @return  this house's quadrant within its city
     */
    public String getQuadrant() {
        return this.quadrant;
    }

    /**
     * 
     * @return  the city that this house is located in
     */
    public String getCity() {
        return this.city;
    }

    /**
     * 
     * @return  the province that this house is located in
     */
    public String getProvince() {
        return this.province;
    }

    /**
     * 
     * @return  the country that this house is located in
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * 
     * @param house_num house number to set
     */
    public void setHouseNum(String house_num) {
        this.house_num = house_num;
    }

    /**
     * 
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 
     * @param quadrant  the quadrant to set the house in
     */
    public void setQuadrant(String quadrant) {
        this.quadrant = quadrant;
    }

    /**
     * 
     * @param city  the city to set the house in
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @param province  the province to set the house in
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 
     * @param country   the country to set the house in
     */
    public void setCountry(String country) {
        this.country = country;
    }
}
