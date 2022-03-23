package VTTP.Workshop17.Model;

import java.util.Map;

public class CurrConvResponse {
    private Map<String, Currency> results;

    public Map<String, Currency> getResults() {
        return results;
    }

    public void setResults(Map<String, Currency> results) {
        this.results = results;
    }
}
