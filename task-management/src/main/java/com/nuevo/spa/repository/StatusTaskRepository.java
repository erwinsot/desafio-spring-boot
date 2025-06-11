package com.nuevo.spa.repository;

import com.nuevo.spa.entity.StatusTask;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StatusTaskRepository extends JpaRepository<StatusTask, Long> {
    Optional<StatusTask> findByName(String name);

}
