package by.belstat.cit.eisgs.findESN.controller;


import by.belstat.cit.eisgs.findESN.entity.Esn;
import by.belstat.cit.eisgs.findESN.repository.EsnRepository;
import by.belstat.cit.eisgs.findESN.services.FindESNService;
import by.belstat.cit.eisgs.findESN.util.Connector;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

@RequestMapping("/v1")
public class FindEsnController {
    private static final Logger LOGGER = LogManager.getLogger(FindEsnController.class);
    @Autowired
    private FindESNService findESNService;

    @Autowired
    private EsnRepository esnRepository;

    @GetMapping("/findESN/{esnId}")
    public Esn checkProtocolReady(@PathVariable String esnId, Model model) {
        return findESNService.findById(esnId);
    }

    @GetMapping(value = "/showAll")
    public List<Esn> showAllEsn(Model model) {
        return findESNService.findAll();
    }

    @GetMapping(value = "/find/{id}")
    public Esn findEsn(@PathVariable String id, Model model) {
        LOGGER.info("start search by {}", id);
        return esnRepository.findById(Long.parseLong(id)).orElse(new Esn());
    }

    @GetMapping(value = "/search/{qry}")
    public List<Esn> searchEsn(@PathVariable String qry, Model model) {
        LOGGER.info("start search by {}", qry);
        return esnRepository.findByCodeEsniContainingOrCodeUnpContaining(qry);

    }


    @GetMapping(value = "/init")
    public String initStorage() {
        LOGGER.info("init elastic");
        Connector.initElastic(findESNService, esnRepository);
        return "Done, added "+esnRepository.count()+" esn";
    }

    @GetMapping(value = "/clear")
    public String clearStorage() {
        LOGGER.info("clear elastic");
        Connector.clearBase(esnRepository);
        return "Done ";
    }

    @GetMapping(value = "/count")
    public long countStorage() {

        return esnRepository.count();
    }

}
