package okhttp;

import com.google.gson.Gson;
import dto.AuthRequestDTO;
import dto.AuthResponseDTO;
import dto.ErrorDTO;
import okhttp3.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginTestsOkhttp {

    Gson gson = new Gson();
    public static final MediaType JSON = MediaType.get("application/json;charset=utf-8");
    OkHttpClient client = new OkHttpClient();

    @Test
    public void loginSuccess() throws IOException {
        AuthRequestDTO auth = AuthRequestDTO.builder().username("test12@gmail.com").password("vilevinQa!1234").build();
        RequestBody body = RequestBody.create(gson.toJson(auth), JSON);

        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(response.code(), 200);
        AuthResponseDTO responseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
        System.out.println(responseDTO.getToken());
    }

    @Test
    public void loginUnsuccess_WrongEmail() throws IOException {
        AuthRequestDTO auth = AuthRequestDTO.builder().username("test12gmail.com").password("vilevinQa!1234").build();
        RequestBody body = RequestBody.create(gson.toJson(auth), JSON);

        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertFalse(response.isSuccessful());
        Assert.assertEquals(response.code(), 401);
        ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
        Assert.assertEquals(errorDTO.getStatus(), 401);
        Assert.assertEquals(errorDTO.getMessage(), "Login or Password incorrect");

    }

    @Test
    public void loginUnsuccess_WrongPassword() throws IOException {
        AuthRequestDTO auth = AuthRequestDTO.builder().username("test12@gmail.com").password("vilevina1234").build();
        RequestBody body = RequestBody.create(gson.toJson(auth), JSON);

        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertFalse(response.isSuccessful());
        Assert.assertEquals(response.code(), 401);
        ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
        Assert.assertEquals(errorDTO.getStatus(), 401);
        Assert.assertEquals(errorDTO.getMessage(), "Login or Password incorrect");

    }


    @Test(enabled = false)
    public void loginUnsuccess() throws IOException {
        AuthRequestDTO auth = AuthRequestDTO.builder().username("test12@gmail.com").password("vilevinQa!1234").build();
        RequestBody body = RequestBody.create(gson.toJson(auth), JSON);

        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertFalse(response.isSuccessful());
        Assert.assertEquals(response.code(), 401);
        ErrorDTO errorDTO = gson.fromJson(response.body().string(), ErrorDTO.class);
        Assert.assertEquals(errorDTO.getStatus(), 401);
        Assert.assertEquals(errorDTO.getMessage(), "Login or password incorrect");

    }


    @Test(enabled = false)
    public void loginUnsuccess_2() throws IOException {
        AuthRequestDTO auth = AuthRequestDTO.builder().username("test12@gmail.com").password("vilevinQa!1234").build();
        RequestBody body = RequestBody.create(gson.toJson(auth), JSON);

        Request request = new Request.Builder().url("https://contactapp-telran-backend.herokuapp.com/v1/user/login/usernamepassword")
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        Assert.assertTrue(response.isSuccessful());
        Assert.assertEquals(response.code(), 200);
        AuthResponseDTO responseDTO = gson.fromJson(response.body().string(), AuthResponseDTO.class);
        System.out.println(responseDTO.getToken());
    }


}
