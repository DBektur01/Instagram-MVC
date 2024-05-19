package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;
import java.util.List;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;

/**
 * Author: Bektur Duyshenbek uulu
 */

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "user_id")
    @SequenceGenerator(name = "user_id",sequenceName = "user_seq",allocationSize = 1)
    private Long id;
    @NotNull
    @Column(name = "user_name",unique = true)
    private String userName;
    @NotNull
    private String password;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    @Column(name = "phone_number",unique = true)
    private String phoneNumber;

    public User(String password, String email, String phoneNumber, String userName) {
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userName = userName;
    }

    @OneToOne(mappedBy = "user" ,cascade = {REMOVE, PERSIST,})
    private UserInfo userInfo;

    @OneToMany(mappedBy = "user",cascade = {REMOVE,PERSIST},fetch = FetchType.EAGER)
    private List<Post> post;

    @OneToOne(mappedBy = "user",cascade = {REMOVE, PERSIST})
    private Follower follower;



    @OneToMany(mappedBy = "user",cascade = {REMOVE})
    private List<Comment>comment;

    @OneToOne(mappedBy = "user")
    private Like like;




}
