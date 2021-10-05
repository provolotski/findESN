package by.belstat.cit.eisgs.findESN.services;


import by.belstat.cit.eisgs.findESN.dao.FindEsnDAO;
import by.belstat.cit.eisgs.findESN.entity.Esn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FindEsnServiceImpl implements FindESNService {
    @Autowired
    private FindEsnDAO findEsnDAO;

    @Override
    public Esn findById(String id) {
        return findEsnDAO.findById(id);
    }

    @Override
    public List<Esn> findAll() {
        return findEsnDAO.findAll();
    }

    @Override
    public List<Esn> findAllPaginator(long start, long finish) {
        return findEsnDAO.findAllPaginator(start,finish);
    }

    @Override
    public long count() {
        return findEsnDAO.count();
    }
}
