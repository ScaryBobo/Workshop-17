package VTTP.Workshop17.Model;

public class Currency {

    private String currencyName;
    private String currencySymbol;
    private String id;

    
    public String getCurrencyName() {
        return currencyName;
    }
    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
    @Override
    public String toString() {
        return "Currency [currencyName=" + currencyName + ", currencySymbol=" + currencySymbol + ", id=" + id + "]";
    }
    public String getCurrencySymbol() {
        return currencySymbol;
    }
    public void setCurrencySymbol(String currencySymbol) {
        this.currencySymbol = currencySymbol;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
}
