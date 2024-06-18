package depth.board.service;

import depth.board.dto.BoardRequestDTO;
import depth.board.dto.BoardResponseDTO;
import depth.board.entity.Board;
import depth.board.repository.BoardRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 게시글 생성
    @Transactional
    public int save(BoardRequestDTO params){
        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

    // 게시글 조회
    @Transactional
    public List<BoardResponseDTO> findAll() {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        List<Board> list = boardRepository.findAll(sort);
        return list.stream().map(BoardResponseDTO::new).collect(Collectors.toList());
    }

    // 게시글 수정
    @Transactional
    public int update(int id, BoardRequestDTO params) {
        Board entity = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Board not found"));
        entity.update(params.getTitle(), params.getContent());
        return id;
    }

    // 글 작성 처리
    public void write(Board board) {
        boardRepository.save(board);
    }

    // 게시글 리스트 처리
    public List<Board> boardlist() {
        return boardRepository.findAll();
    }

    // 특정 게시글 불러오기
    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    // 특정 게시글 삭제
    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }
}
