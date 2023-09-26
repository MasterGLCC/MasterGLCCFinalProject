package entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Forum {
    @Id
    private Integer forumID;
    private String contexte;
    @OneToMany
    private List<Message> listMessafes;
}
