package peaksoft.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.DETACH;
import static jakarta.persistence.CascadeType.PERSIST;

/**
 * Author: Bektur Duyshenbek uulu
 */
@Entity
@Table(name = "images")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "image_id")
    @SequenceGenerator(name = "image_id",sequenceName = "image_seq",allocationSize = 1)
    private Long id;
    private String imageURL;

    public Image(String imageURL) {
        this.imageURL = imageURL;
    }
    @ManyToOne(cascade = {PERSIST})
    private Post post;



}
