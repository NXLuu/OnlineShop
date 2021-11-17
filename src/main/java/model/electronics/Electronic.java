package model.electronics;

import java.io.Serializable;
import java.sql.Date;
/**
 *
 * @author thevu
 */
public class Electronic implements Serializable{
    private int id;
    private String name;
    private String producer;
    private String type;
    private Date producerDate;
    private Integer holdHouseId;
    private Integer mobileId;
    private Integer pcId;
    private int deleted;
    private Date createAt;
    private Date updateAt;

    
   
    public Electronic() {
		super();
	}

	public Electronic(String name, String producer, String type, Date producerDate, Integer holdHouseId, Integer mobileId, Integer pcId, int deleted, Date createAt, Date updateAt) {
        this.name = name;
        this.producer = producer;
        this.type = type;
        this.producerDate = producerDate;
        this.holdHouseId = holdHouseId;
        this.mobileId = mobileId;
        this.pcId = pcId;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getProducerDate() {
        return producerDate;
    }

    public void setProducerDate(Date producerDate) {
        this.producerDate = producerDate;
    }

    public Integer getHoldHouseId() {
        return holdHouseId;
    }

    public void setHoldHouseId(Integer holdHouseId) {
        this.holdHouseId = holdHouseId;
    }

    public Integer getMobileId() {
        return mobileId;
    }

    public void setMobileId(Integer mobileId) {
        this.mobileId = mobileId;
    }

    public Integer getPcId() {
        return pcId;
    }

    public void setPcId(Integer pcId) {
        this.pcId = pcId;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }
}
