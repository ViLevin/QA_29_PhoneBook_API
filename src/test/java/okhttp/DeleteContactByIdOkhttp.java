package okhttp;

import com.google.gson.Gson;
import dto.DeleteByIdResponseDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class DeleteContactByIdOkhttp {
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJyb2xlcyI6WyJST0xFX1VTRVIiXSwic3ViIjoidGVzdDEyQGdtYWlsLmNvbSIsImlzcyI6IlJlZ3VsYWl0IiwiZXhwIjoxNzUxODE3NTkwLCJpYXQiOjE3NTEyMTc1OTB9.9YNgLvFxNi1uM2pDWYMENMrXd9vAA5v3YKwl1-Ye1jk";
    Gson gson = new Gson();
    OkHttpClient client = new OkHttpClient();

    @Test
    public void deleteContactByIDSuccess() throws IOException {
        Request request = new Request.Builder()
                .url("https://contactapp-telran-backend.herokuapp.com/v1/contacts/a18f6211-4a64-4622-933f-7caf7d8fcce5")
                .delete()
                .addHeader("Authorization", token)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertEquals(response.code(), 200);
        DeleteByIdResponseDTO dto = gson.fromJson(response.body().string(), DeleteByIdResponseDTO.class);
        System.out.println(dto.getMessage());
        Assert.assertEquals(dto.getMessage(), "Contact was deleted!");
    }

}
//135ff1b1-2593-4679-80a3-5e50d1a4b568
//ben1546adam@gmail.com
//========================
//a18f6211-4a64-4622-933f-7caf7d8fcce5
//ben1500adam@gmail.com
//========================
//        38d2d095-afad-48b2-9f11-c85244bd1792
//ben1400adam@gmail.com
//========================
