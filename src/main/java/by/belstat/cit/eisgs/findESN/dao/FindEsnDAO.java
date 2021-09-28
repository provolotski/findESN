package by.belstat.cit.eisgs.findESN.dao;

import by.belstat.cit.eisgs.findESN.entity.Esn;

import java.util.List;

public interface FindEsnDAO {
    Esn findById(String id);
    List<Esn> findAll();
}
