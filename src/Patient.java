public class Patient {
    private String firstName, lastName, phone, city, province;

    public Patient(String firstName, String lastName, String phone, String city, String province) {
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setCity(city);
        setProvince(province);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    /**
     * This validates that the String provided matches the
     * North American Dialing plan (NPA-NXX-XXXX) and sets
     * the instance variable or throws an IllegalArgumentException
     * if it does not
     * @param phone A String representing the phone number
     */
    public void setPhone(String phone) {
        if (phone.matches("\\(?[2-9]\\d{2}\\)?[-\\s]?[2-9]\\d{2}[-\\s]?\\d{4}"))
            this.phone = phone;
        else
            throw new IllegalArgumentException("Phone number must match NPA-NXX-XXXX");
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
