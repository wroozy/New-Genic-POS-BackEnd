package lk.wroozy.newgeniccomputer.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

public class AdminSignUpResponseDTO {

    private String adminId;
    private String username;
    private LocalDate regDate;
    private LocalTime regTime;

    public AdminSignUpResponseDTO() {
    }

    public AdminSignUpResponseDTO(String adminId,
                                  String username,
                                  LocalDate regDate,
                                  LocalTime regTime) {
        this.adminId = adminId;
        this.username = username;
        this.regDate = regDate;
        this.regTime = regTime;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getRegDate() {
        return regDate;
    }

    public void setRegDate(LocalDate regDate) {
        this.regDate = regDate;
    }

    public LocalTime getRegTime() {
        return regTime;
    }

    public void setRegTime(LocalTime regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "AdminSignUpResponseDTO{" +
                "adminId='" + adminId + '\'' +
                ", username='" + username + '\'' +
                ", regDate=" + regDate +
                ", regTime=" + regTime +
                '}';
    }
}
