package thefantasticfour.myExpertTranslator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import thefantasticfour.myExpertTranslator.util.dto.TranslateDto;
import thefantasticfour.myExpertTranslator.util.dto.TranslateRequest;
import thefantasticfour.myExpertTranslator.util.dto.TranslateResponse;

@Service
@RequiredArgsConstructor
public class TranslationServiceImplement implements TranslationService{
    private final RestTemplate restTemplate;
    private final String placeHolderUrl = "https://translation.googleapis.com/language/translate/v2";
    private final String API_KEY = "AIzaSyAsyfcq0SeZAN6dHoxc7CRkMDpL1QD-CO0";

    @Override
    public TranslateDto translate(TranslateDto translateDto) {
        String url = UriComponentsBuilder.fromHttpUrl(placeHolderUrl)
                .queryParam("q", translateDto.getText())
                .queryParam("target", translateDto.getTargetLanguage())
                .queryParam("key", API_KEY)
                .toUriString();

        TranslateResponse response = restTemplate.getForObject(url, TranslateResponse.class);

        if (response != null && response.getData() != null && !response.getData().getTranslations().isEmpty()){
            String translatedText =response.getData().getTranslations().get(0).getTranslatedText();
            translateDto.setTranslatedText(translatedText);
        } else {
            throw new RuntimeException("No translations found in response.");
        }

        return translateDto;
    }
}
