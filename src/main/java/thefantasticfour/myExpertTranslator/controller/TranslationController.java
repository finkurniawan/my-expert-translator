package thefantasticfour.myExpertTranslator.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import thefantasticfour.myExpertTranslator.service.TranslationService;
import thefantasticfour.myExpertTranslator.util.dto.TranslateRequest;
import thefantasticfour.myExpertTranslator.util.dto.TranslateResponse;

@RestController
@RequestMapping("/translates")
@RequiredArgsConstructor
public class TranslationController {
    private final TranslationService translateService;

    @PostMapping
    public ResponseEntity<TranslateResponse> translate(@RequestBody TranslateRequest translateRequest) {

        return ResponseEntity.ok(translateService.translate(translateRequest));
    }
}
