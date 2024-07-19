package thefantasticfour.myExpertTranslator.service;

import thefantasticfour.myExpertTranslator.util.dto.TranslateDto;
import thefantasticfour.myExpertTranslator.util.dto.TranslateRequest;
import thefantasticfour.myExpertTranslator.util.dto.TranslateResponse;

public interface TranslationService {
    public TranslateResponse translate(TranslateRequest translateRequest);
}
