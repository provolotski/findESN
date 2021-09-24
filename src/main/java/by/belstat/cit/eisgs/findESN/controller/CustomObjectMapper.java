package by.belstat.cit.eisgs.findESN.controller;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomObjectMapper extends ObjectMapper {

    public CustomObjectMapper() {
        super.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII
                /*JsonWriteFeature.ESCAPE_NON_ASCII*/, true);
    }
}
