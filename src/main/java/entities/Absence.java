package entities;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Data
@ToString
@Entity
@Table(name = "absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "meeting_id")
//    private Meeting meeting;

//    @ManyToOne
//    @JoinColumn(name = "doctorant_id")
//    private Doctorant doctorant;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private String reason;

    @Column(nullable = false)
    private String raisonAbsence;

}
