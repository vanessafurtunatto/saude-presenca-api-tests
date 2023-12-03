package dto;

public class PersonDTO {
    public Integer id;

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

    public String getNumberSus() {
        return numberSus;
    }

    public void setNumberSus(String numberSus) {
        this.numberSus = numberSus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdPersonPhone() {
        return idPersonPhone;
    }

    public void setIdPersonPhone(String idPersonPhone) {
        this.idPersonPhone = idPersonPhone;
    }

    public PersonPhoneDTO getPersonPhoneDTO() {
        return personPhoneDTO;
    }

    public void setPersonPhoneDTO(PersonPhoneDTO personPhoneDTO) {
        this.personPhoneDTO = personPhoneDTO;
    }

    public String created;
    public String deleted;
    public String updated;
    public String numberSus;
    public String name;
    public String idPersonPhone;
    public PersonPhoneDTO personPhoneDTO;

    public PersonDTO(Integer id, String created, String deleted, String updated,
                     String numberSus, String name, String idPersonPhone, PersonPhoneDTO personPhoneDTO) {
        this.id = id;
        this.created = created;
        this.deleted = deleted;
        this.updated = updated;
        this.numberSus = numberSus;
        this.name = name;
        this.idPersonPhone = idPersonPhone;
        this.personPhoneDTO = personPhoneDTO;

}
    }