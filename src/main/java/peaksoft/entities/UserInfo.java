package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import peaksoft.enums.Gender;

import javax.validation.constraints.NotNull;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "user_info")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "userInfo_id")
    @SequenceGenerator(name = "userInfo_id",sequenceName = "userInfo_seq",allocationSize = 1)
    private Long id;
    @NotNull
    @Column(name = "full_name")
    private String fullName;
    @NotNull
    private String biography;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @NotNull
    private String image;

    public UserInfo(String fullName, String biography, Gender gender, String image) {
        this.fullName = fullName;
        this.biography = biography;
        this.gender = gender;
        this.image = image;
    }
    @OneToOne
    private User user;
}
