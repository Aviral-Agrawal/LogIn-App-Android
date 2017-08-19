package app.com.example.aviral.loginapp2;

//Each field represents  a column of the database table
public class Data {

    private String id;
    private String firstName;
    private String secondName;
    private String username;
    private String dob;
    private String address;
    private String gender;
    private String pass;

    public Data(String firstName, String secondName, String username, String dob, String address, String gender, String pass) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.username = username;
        this.dob = dob;
        this.address = address;
        this.gender = gender;
        this.pass = pass;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getUsername() {
        return username;
    }

    public String getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getPass() {
        return pass;
    }
}
