package peaksoft.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;
import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.REMOVE;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "commnets")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "comment_id")
    @SequenceGenerator(name = "comment_id",sequenceName = "comment_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private String comment;
    @NotNull
    @Column(name = "create_at")
    private LocalDate createAt=LocalDate.now();

    public Comment(String comment, LocalDate createAt) {
        this.comment = comment;
        this.createAt = createAt;
    }
    @PrePersist
    private void now(){
        this.createAt=LocalDate.now();
    }

    @ManyToOne
    private User user;

    @ManyToOne(cascade = {DETACH})
    private Post post;

    @OneToMany(mappedBy = "comment",cascade = {REMOVE})
    private List<Like> like;
}
