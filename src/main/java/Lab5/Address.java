package Lab5;

public class Address {
    public String city;
    public String state;

    @Override
    public String toString() {
        return "City: "+city+"\nState: "+state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
