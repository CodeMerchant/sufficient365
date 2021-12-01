package com.codemerchant.sufficient365.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CropRepository extends CrudRepository<Crop, Long> {

	List<Crop> findByAmountOfSun(@Param("amountOfSun") String amountOfSun);

	List<Crop> findBySowType(@Param("sowType") String sowType);

}
