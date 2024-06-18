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

//    @GetMapping("/write")  // localhost:8090/board/write
//    public String boardWriteForm() {
//        return "boardwrite";
//    }
//
//    @PostMapping("/writepro")
//    public String boardWritePro(Board board) {
//        boardService.write(board);
//        return "";
//    }
//
//    @GetMapping("/list")
//    public String boardList(Model model) {
//        model.addAttribute("list", boardService.boardlist());
//        return "boardlist";
//    }
//
//    @GetMapping("/view")  // localhost:8090/board/view?id=1
//    public String boardView(Model model, Integer id) {
//        model.addAttribute("board", boardService.boardView(id));
//        return "boardview";
//    }
//
//    @GetMapping("/delete")
//    public String boardDelete(Integer id) {
//        boardService.boardDelete(id);
//        return "redirect:/board/list";
//    }
//
//    @GetMapping("/modify/{id}")
//    public String boardModify(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("board", boardService.boardView(id));
//        return "boardmodify";
//    }

//    @PostMapping("/update/{id}")
//    public String boardUpdate(@PathVariable("id") Integer id, Board board) {
//        Board boardTemp = boardService.boardView(id);
//        boardTemp.setTitle(board.getTitle());
//        boardTemp.setContent(board.getContent());
//
//        boardService.write(boardTemp);
//
//        return "redirect:/board/list";
//    }
}
