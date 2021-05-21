package com.scheduling.Scheduling.repository;

import com.scheduling.Scheduling.entities.Transfer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends CrudRepository<Transfer, Long> {




}
