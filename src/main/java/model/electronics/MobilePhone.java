package model.electronics;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author thevu
 */
public class MobilePhone implements Serializable{
    private int id;
    private String ram;
    private String disk;
    private String screenWidth;
    private String chipset;
    private String version;
    private int deleted;
    private Date createAt;
    private Date updateAt;

    public MobilePhone(String ram, String disk, String screenWidth, String chipset, String version, int deleted, Date createAt, Date updateAt) {
        this.ram = ram;
        this.disk = disk;
        this.screenWidth = screenWidth;
        this.chipset = chipset;
        this.version = version;
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

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getDisk() {
        return disk;
    }

    public void setDisk(String disk) {
        this.disk = disk;
    }

    public String getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(String screenWidth) {
        this.screenWidth = screenWidth;
    }

    public String getChipset() {
        return chipset;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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
