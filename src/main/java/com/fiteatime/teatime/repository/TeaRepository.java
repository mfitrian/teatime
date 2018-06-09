package com.fiteatime.teatime.repository;

import com.fiteatime.teatime.data.Tea;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeaRepository extends PagingAndSortingRepository<Tea, UUID> {

}
