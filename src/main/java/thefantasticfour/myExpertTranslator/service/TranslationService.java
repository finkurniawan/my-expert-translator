package thefantasticfour.myExpertTranslator.service;

import thefantasticfour.myExpertTranslator.util.dto.TranslateDto;
import thefantasticfour.myExpertTranslator.util.dto.TranslateRequest;

public interface TranslationService {
    TranslateDto translate(TranslateDto translateDto);
}
