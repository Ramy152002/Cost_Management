package com.ramy.costmanagement1.Repository;

import com.ramy.costmanagement1.Entity.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}
