package by.belstat.cit.eisgs.findESN.services;

import by.belstat.cit.eisgs.findESN.entity.Esn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FindESNService {
    Esn findById(String id);
    List<Esn> findAll();
}
