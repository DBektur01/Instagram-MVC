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

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "posts")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "post_id")
    @SequenceGenerator(name = "post_id",sequenceName = "user_seq",allocationSize = 1)
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDate createdAt =LocalDate.now();

    public Post(String title, String description, LocalDate createdAt) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
    }

    @PrePersist
    private void now(){
        this.createdAt=LocalDate.now();
    }

    @ManyToOne(cascade = {REMOVE,PERSIST},fetch = FetchType.EAGER)
    private User user;

    @OneToMany(mappedBy = "post",cascade = {PERSIST,REMOVE},fetch = FetchType.EAGER)
    private List<Comment> comment;

    @OneToMany(mappedBy = "post",cascade = {PERSIST})
    private List<Like> like;

    @OneToMany(mappedBy = "post",cascade = {REMOVE,PERSIST},fetch = FetchType.EAGER)
    private List<Image> image;









}
