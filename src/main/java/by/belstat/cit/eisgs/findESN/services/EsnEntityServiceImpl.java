package by.belstat.cit.eisgs.findESN.services;


import by.belstat.cit.eisgs.findESN.entity.EsnEntity;
import by.belstat.cit.eisgs.findESN.repository.storage.EsnRepository;

//@Service
public class EsnEntityServiceImpl implements EsnEntityService{

  //  @Autowired
    private EsnRepository esnRepository;

    @Override
    public EsnEntity findByIdEsni(String id) {
        return  esnRepository.findByIdEsni(id);
    }
}
