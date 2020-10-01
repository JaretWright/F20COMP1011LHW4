import java.util.Arrays;
import java.util.List;

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
        if (firstName.matches("[A-Z][a-z][A-z]*[-]?[A-z]*?"))
            this.firstName = firstName;
        else
            throw new IllegalArgumentException("Name must have at least 2 characters and start with an upper case letter");
}

    public String getLastName() {
            return lastName;
    }

    /**
     * Validates that the last name starts with an upper case letter and has at least
     * 2 characters.  Hyphenated names are accepted
     * @param lastName
     */
    public void setLastName(String lastName) {
        if (lastName.matches("[A-Z][a-z][A-z]*[-]?[A-z]*?"))
            this.lastName = lastName;
        else
            throw new IllegalArgumentException("Last name must start with an upper case letter and have at least 2 characters");
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
        if (city.matches("[A-Z][a-z][A-z]*"))
            this.city = city;
        else
            throw new IllegalArgumentException("City must start with an " +
                    "                       upper case letter and have 2+ characters");

    }

    public String getProvince() {
        return province;
    }

    public static List<String> getListOfProvinces()
    {
        return Arrays.asList("NL","PE","NS","NB","QC","ON","MB","SK","AB","BC","YT","NT","NU");
    }

    public void setProvince(String province) {
        province = province.toUpperCase();
        if (getListOfProvinces().contains(province))
            this.province = province;
        else
            throw new IllegalArgumentException("Valid provinces are: "+getListOfProvinces());
    }

    public String toString()
    {
        return String.format("%s %s from %s, %s", firstName, lastName, city, province);
    }
}
