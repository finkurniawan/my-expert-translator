package thefantasticfour.myExpertTranslator.util.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TranslateDto {
    private String text;
    private String targetLanguage;
    private String translatedText;
}
