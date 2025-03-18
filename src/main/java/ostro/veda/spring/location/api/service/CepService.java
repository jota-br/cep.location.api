package ostro.veda.spring.location.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.springframework.stereotype.Service;
import ostro.veda.spring.location.api.dto.AddressDto;
import ostro.veda.spring.location.api.util.BusinessException;

import java.io.IOException;
import java.util.Optional;

@Service
public class CepService {

    private final String BASE_URL = "https://viacep.com.br/ws/";

    public AddressDto getAddress(String cep) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + cep + "/json/").newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);

        try (Response response = call.execute()) {

            ResponseBody responseBody = response.body();
            if (responseBody == null || !response.isSuccessful()) throw new BusinessException("Something went wrong");

            String jsonResponse = Optional.of(responseBody.string())
                    .orElseThrow(() -> new BusinessException("No Address found with CEP ", cep));

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonResponse, AddressDto.class);
            
        } catch (IOException | IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }
}
