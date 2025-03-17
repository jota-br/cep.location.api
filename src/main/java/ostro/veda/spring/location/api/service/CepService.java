package ostro.veda.spring.location.api.service;

import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CepService {

    private final String BASE_URL = "https://viacep.com.br/ws/";

    public String getAddress(String cep) {

        OkHttpClient client = new OkHttpClient().newBuilder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(BASE_URL + cep + "/json/").newBuilder();

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();
        Call call = client.newCall(request);
        try (Response response = call.execute()) {
            ResponseBody responseBody = response.body();
            if (responseBody == null) return null;
            return responseBody.string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
