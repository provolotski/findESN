package by.belstat.cit.eisgs.findESN.controller;


import by.belstat.cit.eisgs.findESN.entity.Esn;
import by.belstat.cit.eisgs.findESN.services.FindESNService;
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
    @Autowired
    private FindESNService findESNService;

    @GetMapping("/findESN/{esnId}")
    public Esn checkProtocolReady(@PathVariable String esnId, Model model){
        return findESNService.findById(esnId);
    }

    @GetMapping(value = "/showAll")
    public List<Esn> showAllEsn(Model model){
        return findESNService.findAll();
    }


}
