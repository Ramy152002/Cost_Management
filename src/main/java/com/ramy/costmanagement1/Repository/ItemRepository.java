package com.ramy.costmanagement1.Repository;

import com.ramy.costmanagement1.Entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Items, Long> {
}
