package by.belstat.cit.eisgs.findESN.util;

import by.belstat.cit.eisgs.findESN.repository.EsnRepository;
import by.belstat.cit.eisgs.findESN.services.FindESNService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public  class Connector {
    static final String MSGCNT ="count elasticsearch is {}";
    private Connector() {
    }
    private static final Logger LOGGER = LogManager.getLogger(Connector.class);

    public static void initElastic(FindESNService findESNService, EsnRepository esnRepository) {
        LOGGER.info("start init ElasticSearch");
        long delta = 100_000;
        long start = 0;
        while (start<findESNService.count())
        {
          esnRepository.saveAll(findESNService.findAllPaginator(start, start+delta));
          start +=delta;
          LOGGER.debug("addes {} items", start);
        }

        LOGGER.info(MSGCNT,esnRepository.count());
        LOGGER.info("finish generate repository");
    }

    public static void clearBase( EsnRepository esnRepository){
        LOGGER.info("start init clearBase");
        LOGGER.info(MSGCNT,esnRepository.count());
        esnRepository.deleteAll();
        LOGGER.info(MSGCNT,esnRepository.count());
        LOGGER.info("finish generate repository");

    }

}
