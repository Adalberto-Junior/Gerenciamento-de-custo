package pt.com.firstproject.gerenciamente_de_custos.useCase;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import pt.com.firstproject.gerenciamente_de_custos.model.Expense;
import pt.com.firstproject.gerenciamente_de_custos.repository.ExpenseRepository;

@Service
public class SearchExpensiveUserCase {
    

    @Autowired // Injeção de dependência do Spring para criar uma instância da classe ExpenseRepository e injetá-la na classe RegisterExpenseUseCase.
    private ExpenseRepository expenseRepository;

    public List<Expense> searchExpenseByEmailAndDate(String email, LocalDate PaidDate) {
            List<Expense> expenses;
            if (PaidDate != null) 
                expenses = expenseRepository.findByEmailAndPaidDate(email, PaidDate);
            else
                expenses = expenseRepository.findByEmail(email);
            return expenses;
    }
}
