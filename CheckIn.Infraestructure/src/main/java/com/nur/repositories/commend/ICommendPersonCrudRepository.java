package com.nur.repositories.commend;

import com.nur.model.CommendPersonJpaModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommendPersonCrudRepository extends JpaRepository<CommendPersonJpaModel, UUID> {}
