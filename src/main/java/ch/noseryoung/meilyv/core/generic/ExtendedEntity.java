package ch.noseryoung.meilyv.core.generic;

import org.hibernate.annotations.Type;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class ExtendedEntity {
//    @Id
//    @GeneratedValue(generator = "uuid2")
//    @GenericGenerator(name = "uuid2", strategy = "uuid2")
//    // TODO: Comment the following line out if you are not in the testing mode
////    @Type(type = "uuid-char")
//    @Column(name = "id", updatable = false, nullable = false)
//    private UUID id;

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @Type(type = "uuid-char")
    private UUID id;

    @PrePersist
    protected void onCreate() {
        if (Objects.isNull(this.id)) {
            this.id = UUID.randomUUID();
        }
    }

    protected ExtendedEntity() {
    }

    protected ExtendedEntity(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public ExtendedEntity setId(UUID id) {
        this.id = id;
        return this;
    }
}