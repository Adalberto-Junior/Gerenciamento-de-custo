package pt.com.firstproject.gerenciamente_de_custos.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.com.firstproject.gerenciamente_de_custos.model.Expense;
import pt.com.firstproject.gerenciamente_de_custos.repository.ExpenseRepository;


@Service
public class RegisterExpenseUseCase {

    // SOLID - Single Responsibility Principle (Princípio da Responsabilidade Única)
    // Este princípio afirma que uma classe deve ter apenas uma razão para mudar, ou seja,
    //  ela deve ter apenas uma responsabilidade. No contexto do nosso projeto de gerenciamento de custos,
    //  a classe RegisterExpenseUseCase tem a responsabilidade única de lidar com o processo de registro de despesas.
    //  Ela não deve se preocupar com outras responsabilidades, como a validação dos dados ou a persistência no banco de dados,
    //  que devem ser tratadas por outras classes específicas para essas tarefas.
    @Autowired // Injeção de dependência do Spring para criar uma instância da classe ExpenseRepository e injetá-la na classe RegisterExpenseUseCase.
    ExpenseRepository expenseRepository;

    public Expense registerExpense(Expense expense) {
        // Lógica para registrar uma nova despesa

         if (expense.getDescription() == null || expense.getCategory() == null || expense.getEmail() == null || expense.getPrice() == null || expense.getPaidDate() == null) {
            throw new IllegalArgumentException("Todos os campos são obrigatórios: descrição, categoria, email, valor e data de pagamento.");
        }

        expense=  expenseRepository.save(expense);

        return expense;
    }

    
    
}
