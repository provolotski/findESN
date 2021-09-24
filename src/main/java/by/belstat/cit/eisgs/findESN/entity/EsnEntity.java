package by.belstat.cit.eisgs.findESN.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "V_ESN_ITEM_ENTITY")
public class EsnEntity implements Serializable {
    @Id
    @Column(name = "ID_ESNI")
    private Long idEsni;

    @Column(name ="CODE_ESNI")
    private String codeEsni;

    @Column(name = "CODE_ESNI_UNP")
    private String codeEsniUnp;

    @Column(name="ID_ESNT")
    private Long idEsnt;

    @Column(name = "VARC_DATA")
    private String entName;

    public EsnEntity() {
    }

    public Long getIdEsni() {
        return idEsni;
    }

    public void setIdEsni(Long idEsni) {
        this.idEsni = idEsni;
    }

    public String getCodeEsni() {
        return codeEsni;
    }

    public void setCodeEsni(String codeEsni) {
        this.codeEsni = codeEsni;
    }

    public String getCodeEsniUnp() {
        return codeEsniUnp;
    }

    public void setCodeEsniUnp(String codeEsniUnp) {
        this.codeEsniUnp = codeEsniUnp;
    }

    public Long getIdEsnt() {
        return idEsnt;
    }

    public void setIdEsnt(Long idEsnt) {
        this.idEsnt = idEsnt;
    }

    public String getEntName() {
        return entName;
    }

    public void setEntName(String entName) {
        this.entName = entName;
    }
}
