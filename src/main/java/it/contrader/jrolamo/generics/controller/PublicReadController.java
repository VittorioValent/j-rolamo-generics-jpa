package it.contrader.jrolamo.generics.controller;

import com.querydsl.core.types.Predicate;
import it.contrader.jrolamo.generics.domain.AbstractDTO;
import it.contrader.jrolamo.generics.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This Controller handles all read-only requests from client.
 *
 * @author Vittorio Valent
 *
 * @see CrudController
 * @since 0.0.1
 */
public abstract class PublicReadController<DTO extends AbstractDTO> {

	@Autowired
	protected ICrudService<DTO> service;

	@GetMapping("/public/all")
	public abstract Page<DTO> getAll(
			Predicate predicate,
			Integer pageSize,
			Integer pageNumber,
			Direction direction,
			String sortField);

	@GetMapping("/public/read")
	public DTO read(@RequestParam Long id) {
		return service.read(id);
	}
}
