package depth.board.Board.Service;

import depth.board.Board.DTO.BoardDTO;
import depth.board.Board.Entity.Board;
import depth.board.Board.Repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    // 게시글 생성
    @Transactional
    public int save(BoardDTO params){
        Board entity = boardRepository.save(params.toEntity());
        return entity.getId();
    }

//    // 게시글 조회
//    @Transactional(readOnly = true)
//    public List<BoardDTO> findAll() {
//        Sort sort = Sort.by(Sort.Direction.ASC, "id");
//        List<Board> list = boardRepository.findAll(sort);
//        return list.stream().map(BoardDTO::new).collect(Collectors.toList());
//    }
    // 페이징 기능 구현한 게시글 조회
    @Transactional(readOnly = true)
    public Page<BoardDTO> findAll(Pageable pageable) {
        Page<Board> page = boardRepository.findAll(pageable);
        return page.map(BoardDTO::new);
    }

    // 특정 게시글 조회
    @Transactional(readOnly = true)
    public BoardDTO findById(int id){
        return boardRepository.findById(id).map(BoardDTO::new).orElseThrow(
                () -> new IllegalArgumentException("Id not exist")
        );
    }

    // 게시글 수정
    @Transactional
    public int update(int id, BoardDTO params) {
        Board entity = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Board not found"));
        entity.update(params.getTitle(), params.getContent());
        return id;
    }

    // 게시글 삭제
    @Transactional
    public int delete(int id) {
        Board entity = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Board not found"));
        boardRepository.delete(entity);
        return id;
    }
}
