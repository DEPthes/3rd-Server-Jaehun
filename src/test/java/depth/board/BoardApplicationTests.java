package depth.board;

import depth.board.entity.Board;
import depth.board.repository.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BoardApplicationTests {

    @Autowired
    private BoardRepository boardRepository;

	@Test
	void savePost() {
		Board params = Board.builder()
				.title("1번 게시글 제목")
				.content("1번 게시글 내용").build();

		boardRepository.save(params);
	}

}
