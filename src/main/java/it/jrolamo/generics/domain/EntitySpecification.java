package it.jrolamo.generics.domain;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;

/**
 * All Entity Specifications must extend this class.It has a default filter (the
 * given entity).
 *
 *
 * @author Vittorio Valent
 * @param <Entity>
 *
 * @see Specification
 * @since 0.0.1
 */
@Getter
@Setter
public abstract class EntitySpecification<Entity extends AbstractModel> implements Specification<Entity> {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    protected Entity filter;

    /**
     *
     * @param root
     * @param query
     * @param criteriaBuilder
     * @return
     */
    @Override
    public abstract Predicate toPredicate(Root<Entity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder);

}
