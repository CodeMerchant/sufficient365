package com.codemerchant.sufficient365;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SudoUserRepository extends CrudRepository<SudoUser, Long> {
	SudoUser findByUsername(String username);

}
