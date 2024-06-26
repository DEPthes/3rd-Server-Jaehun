package depth.board.Member.Service;

import depth.board.Member.DTO.MemberDTO;
import depth.board.Member.Entity.Member;
import depth.board.Member.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public void join(MemberDTO param) {
        Member entity = memberRepository.save(param.toEntity());
        memberRepository.save(entity);
    }

    @Transactional
    public MemberDTO login(MemberDTO param) {
        Optional<Member> byEmail = memberRepository.findByEmail(param.getEmail());
        // 이메일 있음
        if (byEmail.isPresent()) {
            Member entity = byEmail.get();
            // 입력한 비밀번호와 db 비밀번호 동일
            if (entity.getPassword().equals(param.getPassword())) {
                MemberDTO dto = new MemberDTO(entity);
                return dto;
            }
            // 비밀번호 불일치
            else{
                return null;
            }
        }
        // 이메일 없음
        else{
            return null;
        }
    }

    @Transactional(readOnly = true)
    public List<MemberDTO> findAll() {
        List<Member> list = memberRepository.findAll();
        List<MemberDTO> dtolist = new ArrayList<>();
        for(Member entity : list){
            MemberDTO dto = new MemberDTO(entity);
            dtolist.add(dto);
        }
        return dtolist;
    }

    @Transactional(readOnly = true)
    public MemberDTO findById(int id) {
        Optional<Member> byId = memberRepository.findById(id);
        if(byId.isPresent()){
            Member entity = byId.get();
            MemberDTO dto = new MemberDTO(entity);
            return dto;
        }else{
            return null;
        }
    }

    @Transactional
    public void delete(int id) {
        memberRepository.deleteById(id);
    }
}
