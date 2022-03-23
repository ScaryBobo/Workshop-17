package VTTP.Workshop17.Model;

import java.util.Map;

public class ConversionPairResponse {

    private Map <String, ConversionPair> results;

    private Map <String, String> query;

    public Map<String, String> getQuery() {
        return query;
    }

    public void setQuery(Map<String, String> query) {
        this.query = query;
    }

    public Map<String, ConversionPair> getResults() {
        return results;
    }

    public void setResults(Map<String, ConversionPair> results) {
        this.results = results;
    }

    
    
}
