package entities;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;


@Embeddable
@Entity
public class Address {
    String StreetNumber;
    String Location;
    String State;

    public Address() {
    }

    public Address(String streetNumber, String location, String state) {
        StreetNumber = streetNumber;
        Location = location;
        State = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "StreetNumber='" + StreetNumber + '\'' +
                ", Location='" + Location + '\'' +
                ", State='" + State + '\'' +
                '}';
    }

    public String getStreetNumber() {
        return StreetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        StreetNumber = streetNumber;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }
}
