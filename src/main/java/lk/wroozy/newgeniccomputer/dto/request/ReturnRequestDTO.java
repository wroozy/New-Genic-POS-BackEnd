package lk.wroozy.newgeniccomputer.dto.request;

import java.util.List;

public class ReturnRequestDTO {

    private String orderId;
    private List<ReturnDetailRequestDTO> detailList;


    public ReturnRequestDTO() {
    }

    public ReturnRequestDTO(String orderId, List<ReturnDetailRequestDTO> detailList) {
        this.orderId = orderId;
        this.detailList = detailList;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<ReturnDetailRequestDTO> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<ReturnDetailRequestDTO> detailList) {
        this.detailList = detailList;
    }

    @Override
    public String toString() {
        return "ReturnRequestDTO{" +
                "orderId='" + orderId + '\'' +
                ", detailList=" + detailList +
                '}';
    }
}
