package com.ramy.costmanagement1.Repository;

import com.ramy.costmanagement1.Entity.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepository extends JpaRepository<Cost, Long> {

}
