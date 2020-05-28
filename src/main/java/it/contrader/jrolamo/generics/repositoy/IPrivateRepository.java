package it.contrader.jrolamo.generics.repositoy;

import com.querydsl.core.types.Predicate;
import it.contrader.jrolamo.generics.annotations.IsOwnerListPostAuth;
import it.contrader.jrolamo.generics.domain.AuditModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Repository to fetch private objects based on logged user in order to keep
 * pagination
 *
 * @author Vittorio Valent
 *
 * @see IsOwnerListPostAuth
 * @since 0.0.1
 */
@NoRepositoryBean
public interface IPrivateRepository<Entity extends AuditModel> extends IRepository<Entity> {

    @Override
    @IsOwnerListPostAuth
    public Page<Entity> findAll(Pageable pageable);

    @Override
    @IsOwnerListPostAuth
    public Page<Entity> findAll(Predicate predicate, Pageable pageable);

}
