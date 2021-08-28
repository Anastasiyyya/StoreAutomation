package page_objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
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
