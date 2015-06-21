package by.newsline.data;

import by.newsline.data.util.StatusEnum;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class CustomEntity {

    @Column(name = "F_STATUS")
    @Enumerated(EnumType.STRING)
    protected StatusEnum status;

    public CustomEntity() {
    }

    public CustomEntity(StatusEnum status) {
    this.status = status;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
