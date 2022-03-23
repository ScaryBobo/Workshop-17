package VTTP.Workshop17.Service;

import java.util.Map;

import org.springframework.stereotype.Service;

import VTTP.Workshop17.Model.Currency;


@Service
public class ApiService {
    private static Map<String, Currency> supportedCurr;

    public static Map<String, Currency> getSupportedCurr() {
        return supportedCurr;
    }

    public static void setSupportedCurr(Map<String, Currency> map) {
        ApiService.supportedCurr = map;
    }




}
