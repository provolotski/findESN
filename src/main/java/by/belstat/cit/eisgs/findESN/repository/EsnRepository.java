package by.belstat.cit.eisgs.findESN.repository;

import by.belstat.cit.eisgs.findESN.entity.Esn;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;


public interface EsnRepository extends ElasticsearchRepository<Esn, Long> {
    List<Esn> findByCodeEsniContainingOrCodeUnpContaining(String code);
    List<Esn> findAll();
    void deleteAll();
    void  deleteById(Long id);
    long count();

}
