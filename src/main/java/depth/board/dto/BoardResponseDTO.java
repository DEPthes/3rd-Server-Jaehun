package depth.board.dto;

import depth.board.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponseDTO {
    private int id;
    private String title;
    private String content;

    public BoardResponseDTO(Board entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
    }
}
