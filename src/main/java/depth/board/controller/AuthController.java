package depth.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller
//@RequestMapping("/member")
public class AuthController {
//    @Autowired
//    KakaoService kakaoService;

    @Value("${REST_API_KEY}")
    private String REST_API_KEY;

    @Value("${REDIRECT_URI}")
    private String REDIRECT_URI;

    // Data 리턴해주는 함수
    @GetMapping("/auth/kakao")
    public @ResponseBody String KakaoCallback(String code) {
        return "카카오 인증 완료 : 코드 값 " + code;
    }
}
