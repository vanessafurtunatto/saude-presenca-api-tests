package dto;

public class PersonPhoneDTO {

    public PersonPhoneDTO(Integer id, String created, String deleted, String updated, String phoneCountryCode, String areaCode, String number) {
        this.id = id;
        this.created = created;
        this.deleted = deleted;
        this.updated = updated;
        this.phoneCountryCode = phoneCountryCode;
        this.areaCode = areaCode;
        this.number = number;

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer id;
    public String created;
    public String deleted;
    public String updated;
    public String phoneCountryCode;
    public String areaCode;
    public String number;
}
