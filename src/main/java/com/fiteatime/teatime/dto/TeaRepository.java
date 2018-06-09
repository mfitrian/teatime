package com.fiteatime.teatime.dto;

import com.fiteatime.teatime.models.Tea;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeaRepository extends CrudRepository<Tea, UUID> {

}
