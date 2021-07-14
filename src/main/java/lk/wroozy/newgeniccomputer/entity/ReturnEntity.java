package lk.wroozy.newgeniccomputer.entity;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "returns")
public class ReturnEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "return_Id")
    private long returnId;
    private Date date;
    private Time time;
    @OneToMany(mappedBy = "returnEntity",fetch = FetchType.LAZY)
    private List<ReturnDetailEntity> returnDetailList;

    public ReturnEntity() {
    }

    public ReturnEntity(long returnId,
                        Date date,
                        Time time,
                        List<ReturnDetailEntity> returnDetailList) {
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public List<ReturnDetailEntity> getReturnDetailList() {
        return returnDetailList;
    }

    public void setReturnDetailList(List<ReturnDetailEntity> returnDetailList) {
        this.returnDetailList = returnDetailList;
    }

    @Override
    public String toString() {
        return "ReturnEntity{" +
                "returnId=" + returnId +
                ", date=" + date +
                ", time=" + time +
                ", returnDetailList=" + returnDetailList +
                '}';
    }
}
