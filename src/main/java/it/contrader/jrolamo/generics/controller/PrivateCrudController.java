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
 * @see PrivateReadController
 * @see ICrudService
 * @since 0.0.1
 */
public abstract class PrivateCrudController<DTO extends AbstractDTO> extends PrivateReadController<DTO> {

	@PostMapping("/create")
	public DTO create(@Valid @RequestBody DTO dto) {
		return service.create(dto);
	}

	@DeleteMapping("/delete/{id}")
	public void delete(@RequestParam("id") Long id) {
		service.delete(id);
	}

	@PutMapping("/update")
	public DTO update(@RequestBody DTO dto) {
		return service.update(dto);
	}

	@PatchMapping("/update")
	public DTO merge(@RequestParam Long id, @RequestBody DTO dto) {

		return service.merge(id, dto);
	}

}
