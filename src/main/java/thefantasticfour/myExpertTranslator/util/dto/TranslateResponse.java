package thefantasticfour.myExpertTranslator.util.dto;

import lombok.Data;

import java.util.List;

@Data
public class TranslateResponse {
    private Data data;

    @lombok.Data
    public static class Data {
        private List<Translation> translations;
    }

    @lombok.Data
    public static class Translation {
        private String translatedText;
    }
}
