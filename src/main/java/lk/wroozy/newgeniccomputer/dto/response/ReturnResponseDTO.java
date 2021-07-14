package lk.wroozy.newgeniccomputer.dto.response;

import java.util.List;

public class ReturnResponseDTO {

    private long returnId;
    private String date;
    private String time;
    private List<ReturnDetailResponseDTO> returnDetailList;

    public ReturnResponseDTO() {
    }

    public ReturnResponseDTO(long returnId,
                             String date,
                             String time,
                             List<ReturnDetailResponseDTO> returnDetailList) {
        this.returnId = returnId;
        this.date = date;
        this.time = time;
        this.returnDetailList = returnDetailList;
    }

    public long getReturnId() {
        return returnId;
    }

    public void setReturnId(long returnId) {
        this.returnId = returnId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ReturnDetailResponseDTO> getReturnDetailList() {
        return returnDetailList;
    }

    public void setReturnDetailList(List<ReturnDetailResponseDTO> returnDetailList) {
        this.returnDetailList = returnDetailList;
    }

    @Override
    public String toString() {
        return "ReturnResponseDTO{" +
                "returnId=" + returnId +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", returnDetailList=" + returnDetailList +
                '}';
    }
}
