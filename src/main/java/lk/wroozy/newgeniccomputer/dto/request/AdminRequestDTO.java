package lk.wroozy.newgeniccomputer.dto.request;


import javax.validation.constraints.*;

public class AdminRequestDTO {

    private String firstName;
    private String lastName;
    @NotEmpty(message = "User name cannot be null or empty")
    @NotNull(message = "User name cannot be null or empty")
    private String userName;
    private String nic;
    @NotEmpty(message = "Email cannot be null or empty")
    @NotNull(message = "Email cannot be null or empty")
    @Email(message = "Please input valid email address")
    private String gmail;
    @Pattern(regexp = "[0-9]{9,10}", message = "Please input valid mobile number")
    private String mobile;
    @Size(min = 7, message = "Password should have 8 characters")
    @NotEmpty(message = "Password cannot be null or empty")
    @NotNull(message = "Password cannot be null or empty")
    private String password;

    public AdminRequestDTO() {
    }

    public AdminRequestDTO(String firstName,
                           String lastName,
                           String userName,
                           String nic,
                           String gmail,
                           String mobile,
                           String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.nic = nic;
        this.gmail = gmail;
        this.mobile = mobile;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "AdminRequestDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", nic='" + nic + '\'' +
                ", gmail='" + gmail + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
