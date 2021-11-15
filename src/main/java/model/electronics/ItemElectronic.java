package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author thevu
 */
public class ItemElectronic implements Serializable{
    private int id;
    private float price;
    private Float discount;
    private int electronicId;
    private int deleted;
    private Date createAt;
    private Date updateAt;

    public ItemElectronic(float price, Float discount, int electronicId, int deleted, Date createAt, Date updateAt) {
        this.price = price;
        this.discount = discount;
        this.electronicId = electronicId;
        this.deleted = deleted;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }
    
     public ItemElectronic(int id, float price, Float discount, int electronicId, int deleted, Date createAt, Date updateAt) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.electronicId = electronicId;
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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public int getElectronicId() {
        return electronicId;
    }

    public void setElectronicId(int electronicId) {
        this.electronicId = electronicId;
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

    @Override
    public String toString() {
        return "ItemElectronic{" + "id=" + id + ", price=" + price + ", discount=" + discount + ", electronicId=" + electronicId + ", deleted=" + deleted + ", createAt=" + createAt + ", updateAt=" + updateAt + '}';
    }
}
