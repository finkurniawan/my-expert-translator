package thefantasticfour.myExpertTranslator.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import thefantasticfour.myExpertTranslator.util.dto.UrlUtils;

@Service
public class TransalationService {
    @Value("${google.translate.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();
    public String translate(String text, String targetLanguage){
        try{
            String url = UriComponentsBuilder.fromHttpUrl("https://translation.googleapis.com/language/translate/v2")
                    .queryParam("key", apiKey)
                    .queryParam("q", text)
                    .queryParam("target", targetLanguage)
                    .toUriString();

            String response = restTemplate.getForObject(url, String.class);
            String translatedText = extractTranslatedText(response);
            return UrlUtils.decodeUrl(translatedText);
        }catch(Exception e){
            e.printStackTrace();
            return "Translation Failed";
        }
    }

    private String extractTranslatedText(String response){
        int startIndex = response.indexOf("\"translatedText\": \"") + 19;
        int endIndex = response.indexOf("\"", startIndex);
        return response.substring(startIndex, endIndex);
    }
}
