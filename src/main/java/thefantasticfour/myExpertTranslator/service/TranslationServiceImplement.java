package thefantasticfour.myExpertTranslator.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import thefantasticfour.myExpertTranslator.util.dto.TranslateDto;
import thefantasticfour.myExpertTranslator.util.dto.TranslateRequest;
import thefantasticfour.myExpertTranslator.util.dto.TranslateResponse;

@Service
@RequiredArgsConstructor
public class TranslationServiceImplement implements TranslationService{
    private final RestClient restClient;
    private final String placeHolderUrl = "https://translation.googleapis.com/language/translate/v2";
    private final String API_KEY = "AIzaSyAsyfcq0SeZAN6dHoxc7CRkMDpL1QD-CO0";

    @Override
    public TranslateResponse translate(TranslateRequest translateRequest) {

        String url = placeHolderUrl + "?key=" + API_KEY + "&target=" + translateRequest.getTarget()  + "&q=" + translateRequest.getQ();

        return restClient.get().uri(url).retrieve().body(TranslateResponse.class);
    }
}
