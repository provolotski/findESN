package by.belstat.cit.eisgs.findESN.services;


import by.belstat.cit.eisgs.findESN.dao.FindEsnDAO;
import by.belstat.cit.eisgs.findESN.entity.Esn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FindEsnServiceImpl implements FindESNService {
    @Autowired
    private FindEsnDAO findEsnDAO;

    @Override
    public Esn findById(String id) {
        return findEsnDAO.findById(id);
    }
}
