package page_objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {

    private String firstName;
    private String lastName;
    private String company;
    private String address;
    private String zipCode;
    private String city;
    private String country;
    private String homePhone;
    private String mobilePhone;
    private String title;
}
