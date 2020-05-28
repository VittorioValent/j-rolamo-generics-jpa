package it.contrader.jrolamo.generics.service;

import com.querydsl.core.types.Predicate;
import it.contrader.jrolamo.generics.controller.PrivateCrudController;
import it.contrader.jrolamo.generics.domain.AbstractDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * All CRUD methods service
 *
 * @author Vittorio Valent
 *
 * @param <DTO>
 * @see PrivateCrudController
 *
 * @since 0.0.1
 */
@Service
public interface ICrudService<DTO extends AbstractDTO> {

    public DTO create(DTO entity);

    public void delete(Long id);

    public DTO update(DTO entity);

    public DTO merge(Long id, DTO entity);

    public Page<DTO> getAll(Predicate predicate, Pageable pageable);

    public DTO read(Long id);
}
