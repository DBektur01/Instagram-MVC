package peaksoft.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "likes")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "like_id")
    @SequenceGenerator(name = "like_id",sequenceName = "like_seq",allocationSize = 1)
    private Long id;

    private boolean isLike;

    public Like(boolean isLike) {
        this.isLike = isLike;
    }

    @ManyToOne
    private Comment comment;

    @OneToOne
    private User user;
    @ManyToOne
    private Post post;
}
