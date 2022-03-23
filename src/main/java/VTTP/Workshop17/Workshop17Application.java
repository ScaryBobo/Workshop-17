package VTTP.Workshop17;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import VTTP.Workshop17.Model.CurrConvResponse;
import VTTP.Workshop17.Model.Currency;
import VTTP.Workshop17.Service.ApiService;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;

@SpringBootApplication
public class Workshop17Application {


	public static void main(String[] args) throws Exception {
		SpringApplication.run(Workshop17Application.class, args);

		String url = "https://free.currconv.com/api/v7/currencies?apiKey=f79cb1611d08b6caf5d4";
		RequestEntity<Void> req = RequestEntity
		.get(url)
		.accept(MediaType.APPLICATION_JSON)
		.build();

		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> resp = template.exchange(req, String.class);
		ObjectMapper objectMapper = new ObjectMapper();
		CurrConvResponse response = objectMapper.readValue(resp.getBody(), CurrConvResponse.class);
		//System.out.println(response.toString());
		//System.out.println(response.getResults().get("SGD").getCurrencyName());

		ApiService.setSupportedCurr(response.getResults());
    
		// System.out.println(ApiService.getSupportedCurr().get("SGD"));
		// System.out.println(ApiService.getSupportedCurr().get("SGD").getCurrencyName());
		// System.out.println(ApiService.getSupportedCurr().get("USD"));


		
	}

}
