package thefantasticfour.myExpertTranslator.util.dto;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class UrlUtils {
    public static String decodeUrl(String encoderdUrl){
        try{
            return URLDecoder.decode(encoderdUrl,StandardCharsets.UTF_8.name());
        } catch(UnsupportedEncodingException e){
            e.printStackTrace();
            return encoderdUrl;
        }
    }
}
