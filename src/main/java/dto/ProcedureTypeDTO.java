package dto;

public class ProcedureTypeDTO {
    public ProcedureTypeDTO(Integer id, String created, String deleted, String updated, String description) {
        this.id = id;
        this.created = created;
        this.deleted = deleted;
        this.updated = updated;
        this.description = description;
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
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer id;
    public String created;
    public String deleted;
    public String updated;
    public String description;

}
