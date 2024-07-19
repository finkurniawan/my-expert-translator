package thefantasticfour.myExpertTranslator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import thefantasticfour.myExpertTranslator.service.TranslationService;
import thefantasticfour.myExpertTranslator.util.dto.TranslateDto;

@RestController
public class TranslationController {
    @Autowired
    private TranslationService translationService;

    @GetMapping("/translate")
    public TranslateDto translate(@RequestParam String text, @RequestParam String targetLanguage) {
        TranslateDto translateDto = new TranslateDto();
        translateDto.setText(text);
        translateDto.setTargetLanguage(targetLanguage);

        return translationService.translate(translateDto);
    }
}
