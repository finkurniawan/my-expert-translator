package thefantasticfour.myExpertTranslator.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "translates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Translate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "q")
    private String q;

    @Column(name = "target")
    private String target;

    @Column(name = "result")
    private String result;
}
