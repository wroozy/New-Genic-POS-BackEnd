package lk.wroozy.newgeniccomputer.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class AdminSignInResponseDTO {

    private String token;
    private String adminId;
    private String userName;
    private LocalDate date;
    private LocalTime time;

    public AdminSignInResponseDTO() {
    }

    public AdminSignInResponseDTO(String token,
                                  String adminId,
                                  String userName,
                                  LocalDate date,
                                  LocalTime time) {
        this.token = token;
        this.adminId = adminId;
        this.userName = userName;
        this.date = date;
        this.time = time;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "AdminSignInResponseDTO{" +
                "token='" + token + '\'' +
                ", adminId='" + adminId + '\'' +
                ", userName='" + userName + '\'' +
                ", date=" + date +
                ", time=" + time +
                '}';
    }
}
