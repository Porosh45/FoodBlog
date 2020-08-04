package foodfinder;

public class seller {

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public int getPhone() {
        return phone;
    }
    public void setPhone(int phone) {
        this.phone = phone;
    }
    
    private int id;
    private String name;
    private String password;
    private String email;
    private String location;
    private int phone;
    
    public seller(int id, String name,  String email, String password, String location, int phone)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.location = location;
        this.phone = phone;
    }
    public seller(){};
}
