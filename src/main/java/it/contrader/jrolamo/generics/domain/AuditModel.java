package it.contrader.jrolamo.generics.domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * Superclass for entity, provides auditing implementation.
 *
 * @author Vittorio Valent
 * @see AuditDTO
 * @since 0.0.1
 */
@Data
@MappedSuperclass
@EqualsAndHashCode(callSuper = false)
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditModel extends AbstractModel {

    /**
     * Indicates when the object was created first
     */
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, updatable = false)
    protected Date createdOn;

    /**
     * Indicates the creator/owner of the given object
     */
    @CreatedBy
    protected String owner;

    /**
     * Indicates when the object was last
     */
    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    protected Date lastModifiedOn;

    /**
     * Indicates last user updating the object
     */
    @LastModifiedBy
    protected String lastModifiedBy;
}
