package it.contrader.jrolamo.generics.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.querydsl.core.types.Predicate;

import it.contrader.jrolamo.generics.domain.AbstractDTO;
import it.contrader.jrolamo.generics.service.ICrudService;

/**
 * This Controller handles all read-only requests from client.
 * 
 * @author Vittorio Valent
 *
 * @param <DTO>
 * 
 * @see CrudController
 * @since 0.0.1
 */
public abstract class ReadController<DTO extends AbstractDTO> {

	@Autowired
	protected ICrudService<DTO> service;

	@GetMapping("/all")
	public abstract Page<DTO> getAll(
			Predicate predicate,
			Integer pageSize,
			Integer pageNumber,
			Direction direction,
			String sortField);

	@GetMapping("/read")
	public DTO read(@RequestParam Long id) {
		return service.read(id);
	}
}
