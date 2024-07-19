package thefantasticfour.myExpertTranslator.util.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
@Getter
public class TranslateRequest {
    private String q;
    private String target;
    private String key;

    public TranslateRequest(
            String q, String target, String key
    ) {
        this.q = q;
        this.target = target;
        this.key = key;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("q", q);
        map.put("target", target);
        map.put("key", key);

        return map;
    }
}
