package model.electronics;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author thevu
 */
public class HoldHouse implements Serializable{
    private int id;
    private String type;
    private float power;
    private Float insurance;
    private Float longevity;
    private String technologyUsed;
    private int deleted;
    private Date createAt;
    private Date updateAt;    

    public HoldHouse(String type, float power, Float insurance, Float longevity, String technologyUsed, int deleted, Date createAt, Date updateAt) {
        this.type = type;
        this.power = power;
        this.insurance = insurance;
        this.longevity = longevity;
        this.technologyUsed = technologyUsed;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPower() {
        return power;
    }

    public void setPower(float power) {
        this.power = power;
    }

    public Float getInsurance() {
        return insurance;
    }

    public void setInsurance(Float insurance) {
        this.insurance = insurance;
    }

    public Float getLongevity() {
        return longevity;
    }

    public void setLongevity(Float longevity) {
        this.longevity = longevity;
    }

    public String getTechnologyUsed() {
        return technologyUsed;
    }

    public void setTechnologyUsed(String technologyUsed) {
        this.technologyUsed = technologyUsed;
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
