package pt.com.firstproject.gerenciamente_de_custos.performace;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import pt.com.firstproject.gerenciamente_de_custos.model.Expense;
import pt.com.firstproject.gerenciamente_de_custos.repository.ExpenseRepository;

// @Component // // Faz com que o spring-boot corra este ficheiro juntamente com a aplicação
public class ExpenseManegementSeeder implements CommandLineRunner {

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("I'm running with the application --> start seed generaction");
        List<Expense> listExpense = new ArrayList<>();
        for (int i = 0; i < 15000; i++){
            Expense expense = new Expense();

            expense.setDescription("Expense Number: " + i);
            expense.setCategory("Alimentação");
            expense.setPrice(BigDecimal.valueOf( 10 * (i % 50)));
            expense.setPaidDate(LocalDate.now().minusDays((i % 30))); // 1 - 30 dias
            if (i % 2 == 0)
                expense.setEmail("adalberton2ta@gmail.com");
            else
                expense.setEmail("adalberton1ta@gmail.com");

            listExpense.add(expense);
        }
        expenseRepository.saveAll(listExpense);
        System.out.println("I'm running with the application --> end seed generaction");
    }
    
}
