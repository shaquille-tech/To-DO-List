package com.qa.TDL.domain;

import org.springframework.data.jpa.repository.JpaRepository;;

// JPA allows java to communicate to DB
public interface TaskRepo extends JpaRepository<Task, Long> {

	
}
