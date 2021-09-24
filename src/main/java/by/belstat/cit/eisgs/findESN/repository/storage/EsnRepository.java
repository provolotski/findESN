package by.belstat.cit.eisgs.findESN.repository.storage;

import by.belstat.cit.eisgs.findESN.entity.EsnEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EsnRepository extends PagingAndSortingRepository<EsnEntity,Long> {
    EsnEntity findByIdEsni(String id);
}
