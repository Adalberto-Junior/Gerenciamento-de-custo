package pt.com.firstproject.gerenciamente_de_custos.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import pt.com.firstproject.gerenciamente_de_custos.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, UUID> {

    List<Expense> findByEmail (String email);
    List<Expense> findByEmailAndPaidDate (String email, LocalDate paidDate);
    
    Page<Expense> findByEmail(String email, Pageable Pageable);
}
