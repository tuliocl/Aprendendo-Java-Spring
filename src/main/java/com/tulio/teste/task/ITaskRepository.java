package com.tulio.teste.task;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ITaskRepository extends JpaRepository<Taskmodel,UUID>{
    
}
