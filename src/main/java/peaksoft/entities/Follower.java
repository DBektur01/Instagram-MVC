package peaksoft.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "followers")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY ,generator = "follower_id")
    @SequenceGenerator(name = "follower_id",sequenceName = "follower_seq",allocationSize = 1)

    private Long id;
    @ElementCollection
    private List<Long> subscribers ;
    @ElementCollection
    private List<Long> subscriptions ;


    public Follower(List<Long> subscribers, List<Long> subscriptions) {
        this.subscribers = subscribers;
        this.subscriptions = subscriptions;
    }
    @OneToOne
    private User user;
}

