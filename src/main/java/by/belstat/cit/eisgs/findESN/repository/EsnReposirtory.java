package by.belstat.cit.eisgs.findESN.repository;

import by.belstat.cit.eisgs.findESN.entity.Esn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EsnReposirtory/* extends ElasticsearchRepository<Esn, Long>*/ {
    Page<Esn> findByCodeEsniOrCodeUnp(String code, Pageable pageable);
}
