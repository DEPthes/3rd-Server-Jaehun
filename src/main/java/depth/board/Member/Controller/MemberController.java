package depth.board.Member.Controller;

import depth.board.Member.DTO.MemberDTO;
import depth.board.Member.Service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final MemberService memberService;

    // 회원가입 페이지
    @GetMapping("/join")
    public String join() {
        return "join";
    }
    @PostMapping("/join")
    public String join(@ModelAttribute MemberDTO memberDTO) {
        memberService.join(memberDTO);
        return "login";
    }

    // 로그인 페이지
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @PostMapping("/login")
    public String login(@ModelAttribute MemberDTO memberDTO, HttpSession session) {
        MemberDTO result = memberService.login(memberDTO);
        // 성공 시
        if (result != null) {
            session.setAttribute("email", result.getEmail());
            return "sucesslogin";
        }
        // 실패 시
        else {
            return "login";
        }
    }

    // 로그 아웃
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "login";
    }
}
