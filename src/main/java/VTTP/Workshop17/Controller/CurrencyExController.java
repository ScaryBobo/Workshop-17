package VTTP.Workshop17.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import VTTP.Workshop17.Model.ConversionPair;
import VTTP.Workshop17.Model.ConversionPairResponse;
import VTTP.Workshop17.Model.CurrConvResponse;
import VTTP.Workshop17.Service.ApiService;

@Controller
@RequestMapping (path="/")
public class CurrencyExController {
    @Autowired
    private ApiService apiService;

    @GetMapping
    public String currencyExchangePage(Model model){
        List<String> currencyNames = new ArrayList<>();
		for (String k : ApiService.getSupportedCurr().keySet()){
			//System.out.println(apiService.getSupportedCurr().get(k).getCurrencyName());
			currencyNames.add(k);
		}
        //System.out.println(currencyNames.toString());
        model.addAttribute("currencyname",currencyNames);
        return "index";
    }

    @PostMapping (path="/convert")

    public String currencyConvert(Model model,
     @RequestParam(name="currencySrc") String currencySrc,
     @RequestParam(name="currencyDst") String currencyDst,
     @RequestParam (name="amount") double currencySrcInput) throws JsonProcessingException, JsonMappingException
     {
        
        String url = "https://free.currconv.com/api/v7/convert?q=" + currencySrc + "_"+ currencyDst + "&compact=ultra&apiKey=f79cb1611d08b6caf5d4";
		RequestEntity<Void> req = RequestEntity
		.get(url)
		.accept(MediaType.APPLICATION_JSON)
		.build();

		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> resp = template.exchange(req, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String, Double> response = objectMapper.readValue(resp.getBody(), Map.class);
        System.out.println("This is the currency conversion rate : " + 
        response.get(currencySrc + "_" + currencyDst));
        System.out.println("This is the currency amount to be converted : " + 
        currencySrcInput);
        Double currencyResult = (response.get(currencySrc + "_" + currencyDst) *  currencySrcInput);
        System.out.println("This is the converted currency " + currencyResult);


        System.out.println(ApiService.getSupportedCurr().get(currencySrc).getCurrencyName());

        model.addAttribute("currencySrc", ApiService.getSupportedCurr()
                            .get(currencySrc).getCurrencyName() + ApiService.getSupportedCurr()
                            .get(currencySrc).getCurrencySymbol());
        model.addAttribute("currencySrcInput", currencySrcInput);
        
        model.addAttribute("currencyDst", ApiService.getSupportedCurr()
                            .get(currencyDst).getCurrencyName() + ApiService.getSupportedCurr()
                            .get(currencyDst).getCurrencySymbol());
        model.addAttribute("currencyResult", currencyResult);
        


        return "result";


     }
    




    
}
