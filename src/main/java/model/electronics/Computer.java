package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author thevu
 */
public class Computer implements Serializable{
    private int id;
    private String version;
    private String ram;
    private String disk;
    private String screenWidth;
    private String type;
    private String userType;
    private String des;
    private String advantages;
    private String defect;
    private int deleted;
    private Date createAt;
    private Date updateAt;

    public Computer(String version, String ram, String disk, String screenWidth, String type, String userType, String des, String advantages, String defect, int deleted, Date createAt, Date updateAt) {
        this.version = version;
        this.ram = ram;
        this.disk = disk;
        this.screenWidth = screenWidth;
        this.type = type;
        this.userType = userType;
        this.des = des;
        this.advantages = advantages;
        this.defect = defect;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getAdvantages() {
        return advantages;
    }

    public void setAdvantages(String advantages) {
        this.advantages = advantages;
    }

    public String getDefect() {
        return defect;
    }

    public void setDefect(String defect) {
        this.defect = defect;
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
