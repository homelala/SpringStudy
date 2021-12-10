package hellojpa;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity {
    @Id
    @GeneratedValue
    private Long id;

    public AddressEntity() {
    }

    public AddressEntity(Long id, Address address) {
        this.address = address;
    }

    @Embedded
    private Address address;

    public AddressEntity(String city, String street, String zipcode) {
        this.address = new Address(city, street, zipcode);
    }
}
