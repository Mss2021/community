package mss.community.provider;

import com.alibaba.fastjson.JSON;
import mss.community.dto.AccessTokenDTO;
import mss.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;


/**
 *Created by MSS on 2021/3/26
 */
@Component
public class GitHubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string=response.body().string();
            String token=string.split("&")[0].split("=")[1];
            return token;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string=response.body().string();
            System.out.println(string);
            GithubUser githubUser=JSON.parseObject(string,GithubUser.class);
            return githubUser;
        }catch (Exception e){
        }
        return null;
    }
}
