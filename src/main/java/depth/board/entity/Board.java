package depth.board.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;

    // 게시글 수정을 위한 메서드
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
