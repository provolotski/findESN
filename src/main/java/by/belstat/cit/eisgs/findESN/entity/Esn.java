package by.belstat.cit.eisgs.findESN.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Esn implements Serializable {
    private Long id;
    private String codeEsni;
    private String codeUnp;
    private Integer idEsnt;
    private String nameEnt;

    public Esn() {
    }

    public Esn(Long id, String codeEsni, String codeUnp, Integer idEsnt, String nameEnt) {
        this.id = id;
        this.codeEsni = codeEsni;
        this.codeUnp = codeUnp;
        this.idEsnt = idEsnt;
        this.nameEnt = nameEnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeEsni() {
        return codeEsni;
    }

    public void setCodeEsni(String codeEsni) {
        this.codeEsni = codeEsni;
    }

    public String getCodeUnp() {
        return codeUnp;
    }

    public void setCodeUnp(String codeUnp) {
        this.codeUnp = codeUnp;
    }

    public Integer getIdEsnt() {
        return idEsnt;
    }

    public void setIdEsnt(Integer idEsnt) {
        this.idEsnt = idEsnt;
    }

    public String getNameEnt() {
        return nameEnt;
    }

    public void setNameEnt(String nameEnt) {
        this.nameEnt = nameEnt;
    }

    @Override
    public String toString() {
        return "Esn{" +
                "id=" + id +
                ", codeEsni='" + codeEsni + '\'' +
                ", codeUnp='" + codeUnp + '\'' +
                ", idEsnt=" + idEsnt +
                ", nameEnt='" + nameEnt + '\'' +
                '}';
    }
}
