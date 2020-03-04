import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@EqualsAndHashCode
@Entity
public class Model {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String info;
    @Getter
    @Setter
    private String target;
}
