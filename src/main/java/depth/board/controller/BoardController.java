package depth.board.controller;

import depth.board.dto.BoardRequestDTO;
import depth.board.dto.BoardResponseDTO;
import depth.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;

    // 게시글 생성
    @PostMapping("/boards")
    public int save(@RequestBody BoardRequestDTO params) {
        return boardService.save(params);
    }

    // 게시글 리스트 조회
    @GetMapping("/boards")
    public List<BoardResponseDTO> findAll() {
        return boardService.findAll();
    }

    // 게시글 수정
    @PatchMapping("/boards/{id}")
    public int save(@PathVariable int id, @RequestBody BoardRequestDTO params) {
        return boardService.update(id, params);
    }
}
