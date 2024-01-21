package com.productservice.productservice.inheritancerelation.singletable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("st_userrepository")
public interface UserRepository extends JpaRepository<User, Long> {

}
