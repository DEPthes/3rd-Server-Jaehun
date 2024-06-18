package depth.board.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

//@Service
public class AuthService {
    @Value("${REST_API_KEY}")
    private String REST_API_KEY;

    @Value("${REDIRECT_URI}")
    private String REDIRECT_URI;


}
