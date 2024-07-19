package thefantasticfour.myExpertTranslator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import thefantasticfour.myExpertTranslator.service.TransalationService;

@RestController
@RequestMapping("/api/translate")
public class TransactionController {
    @Autowired
    private TransalationService transalationService;

    @GetMapping
    public String translate(@RequestParam String text, @RequestParam String targetLanguage){
        return transalationService.translate(text, targetLanguage);
    }
}
