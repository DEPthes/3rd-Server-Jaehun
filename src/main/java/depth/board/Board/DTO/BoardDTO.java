package depth.board.Board.DTO;

import depth.board.Board.Entity.Board;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardDTO {
    private int id;
    private String title;
    private String content;

    // ResponseDTO
    public BoardDTO(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }

    // RequestDTO
    public Board toEntity() {
        return Board.builder()
                .title(title)
                .content(content)
                .build();
    }
}
