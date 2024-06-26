package depth.board.Board.Controller;

import depth.board.Board.DTO.BoardDTO;
import depth.board.Board.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boards")
@RequiredArgsConstructor
public class BoardController {

    @Autowired
    private final BoardService boardService;

    // 게시글 생성
    @PostMapping("/save")
    public int save(@ModelAttribute BoardDTO params) {
        return boardService.save(params);
    }

//    // 게시글 리스트 조회
//    @GetMapping("")
//    public List<BoardDTO> findAll() {
//        return boardService.findAll();
//    }
    // 페이징 기능 게시글 리스트 조회
    @GetMapping("")
    public Page<BoardDTO> findAll(@RequestParam(value = "page", defaultValue = "0") int page,
                                  @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "id"));
        return boardService.findAll(pageable);
    }

    // 특정 게시글 조회
    @GetMapping("/{id}")
    public BoardDTO findById(@PathVariable int id) {
        return boardService.findById(id);
    }

    // 게시글 수정
    @PatchMapping("/boards/{id}")
    public int save(@PathVariable int id, @RequestBody BoardDTO params) {
        return boardService.update(id, params);
    }

    // 게시글 삭제
    @DeleteMapping("/boards/{id}")
    public int delete(@PathVariable int id) {
        return boardService.delete(id);
    }
}