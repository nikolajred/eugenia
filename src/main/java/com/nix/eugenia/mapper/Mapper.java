package com.nix.eugenia.mapper;

import com.nix.eugenia.DTO.AbstractDTO;
import com.nix.eugenia.model.AbstractEntity;

public interface Mapper<E extends AbstractEntity, D extends AbstractDTO> {

    E toEntity(D dto);

    D toDto(E entity);
}
