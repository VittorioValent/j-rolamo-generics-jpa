package it.contrader.jrolamo.generics.service;

import it.contrader.jrolamo.generics.annotations.IsOwnerPreAuth;
import it.contrader.jrolamo.generics.domain.AbstractDTO;
import it.contrader.jrolamo.generics.domain.AbstractModel;

/**
 * Read all, Write only owner
 *
 * @author Vittorio Valent
 * @since 0.0.1
 */
public abstract class ProtectedService<Entity extends AbstractModel, DTO extends AbstractDTO> extends PublicService<Entity, DTO> {

    @Override
    @IsOwnerPreAuth
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    @IsOwnerPreAuth
    public DTO update(DTO dto) {
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }

    @Override
    @IsOwnerPreAuth
    public DTO merge(Long id, DTO dto) {
        dto = (DTO) patchUtils.applyPatch(read(id), dto);
        return mapper.toDTO(repository.save(mapper.toEntity(dto)));
    }
}
