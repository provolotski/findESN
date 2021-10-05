package by.belstat.cit.eisgs.findESN.services;

import by.belstat.cit.eisgs.findESN.entity.Esn;

import java.util.List;


public interface FindESNService {
    Esn findById(String id);
    List<Esn> findAll();
    List<Esn> findAllPaginator(long start, long finish);
    long count();

}
