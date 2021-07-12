package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "admin")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "admin_id")
    private long adminId;
    private String uuid;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String username;
    private String gmail;
    private String nic;
    private String mobile;
    private String password;
    @Column(name = "registered_date")
    private Date regDate;
    @Column(name = "registered_time")
    private Time regTime;

    public AdminEntity() {

    }

    public AdminEntity(long adminId,
                       String uuid,
                       String firstName,
                       String lastName,
                       String username,
                       String gmail,
                       String nic,
                       String mobile,
                       String password,
                       Date regDate,
                       Time regTime) {
        this.adminId = adminId;
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.gmail = gmail;
        this.nic = nic;
        this.mobile = mobile;
        this.password = password;
        this.regDate = regDate;
        this.regTime = regTime;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Time getRegTime() {
        return regTime;
    }

    public void setRegTime(Time regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "adminId=" + adminId +
                ", uuid='" + uuid + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", username='" + username + '\'' +
                ", gmail='" + gmail + '\'' +
                ", nic='" + nic + '\'' +
                ", mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regTime='" + regTime + '\'' +
                '}';
    }
}
