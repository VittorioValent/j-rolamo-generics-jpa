package it.contrader.jrolamo.generics.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.jrolamo.generics.domain.AbstractDTO;
import it.contrader.jrolamo.generics.service.ICrudService;

/**
 * This controller contains all CRUD methods. Notice that method
 * {@code create(<DTO> dto)} needs a @Valid input.
 *
 * @author Vittorio Valent
 *
 * @param <DTO>
 * @see ReadController
 * @see ICrudService
 * @since 0.0.1
 */
public abstract class PublicCrudController<DTO extends AbstractDTO> extends PublicReadController<DTO> {

	@PostMapping("/public/create")
	public DTO create(@Valid @RequestBody DTO dto) {
		return service.create(dto);
	}

	@DeleteMapping("/public/delete/{id}")
	public void delete(@RequestParam("id") Long id) {
		service.delete(id);
	}

	@PutMapping("/public/update")
	public DTO update(@RequestBody DTO dto) {
		return service.update(dto);
	}

	@PatchMapping("/public/update")
	public DTO merge(@RequestParam Long id, @RequestBody DTO dto) {

		return service.merge(id, dto);
	}
}
