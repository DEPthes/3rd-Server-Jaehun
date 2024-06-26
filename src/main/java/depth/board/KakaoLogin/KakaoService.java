package depth.board.KakaoLogin;

import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

//@Service
public class KakaoService {
    @Value("${REST_API_KEY}")
    private String REST_API_KEY;

    @Value("${REDIRECT_URI}")
    private String REDIRECT_URI;

//    public String getToken(String code) throws IOException {
//        // 인가코드를 token 형식으로 받음
//        String host = "https://kauth.kakao.com/oauth/token";
//        URL url = new URL(host);
//        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//        String token = "";
//
//
//    }
}
