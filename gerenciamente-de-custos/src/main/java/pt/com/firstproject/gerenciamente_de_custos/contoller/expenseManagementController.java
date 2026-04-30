package pt.com.firstproject.gerenciamente_de_custos.contoller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pt.com.firstproject.gerenciamente_de_custos.model.Expense;
import pt.com.firstproject.gerenciamente_de_custos.useCase.RegisterExpenseUseCase;
import pt.com.firstproject.gerenciamente_de_custos.useCase.SearchExpensiveUserCase;
import pt.com.firstproject.gerenciamente_de_custos.custum_message.ErrorMessage;


@RequestMapping("/expensemanagement")        // Define que a minha aplicação vai ser controlada/gerenciada por Spring Boot, e o caminho para acessar a aplicação será "localhost:8080/expensemanagement"
@RestController
public class ExpenseManagementController {
    
    /*
    * Registrar a despesa
    * Criar tabela de despesas na base de dados
    * criar entidade de despesa com os seguintes campos: id, descrição, valor, data, categoria, data_criacao, email (model)
    */
    @Autowired
    RegisterExpenseUseCase registerExpenseUseCase;

    @Autowired
    SearchExpensiveUserCase searchExpensiveUserCase;

    @PostMapping("/create")   // Define que o método createExpense() vai ser acessado através de uma requisição POST no caminho "localhost:8080/expensemanagement/create"
    public ResponseEntity<?> createExpense( @RequestBody Expense expense) {
        // Lógica para criar uma nova despesa
        try {
            var result =  registerExpenseUseCase.registerExpense(expense);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            // Lógica para lidar com a exceção de argumento ilegal, como campos obrigatórios ausentes ou inválidos.
            return ResponseEntity.badRequest().body(new ErrorMessage(e.getMessage(), "Argumento inválido", "BAD_REQUEST"));
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(500).body(new ErrorMessage(e.getMessage(), "Erro interno do servidor", "INTERNAL_SERVER_ERROR"));
        }
       
    }

    // expensemanagement/search/email?date=2026-04-30
    @GetMapping("/search/{email}")
    public ResponseEntity<?> searchExpenseByEmailAndDate(@PathVariable String email, @RequestParam(required = false) LocalDate PaidDate) {
        // Lógica para buscar despesas  @RequestParam String startDate
        try {
            var expenses = searchExpensiveUserCase.searchExpenseByEmailAndDate(email, PaidDate);
            return ResponseEntity.ok(expenses); 
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.status(500).body(new ErrorMessage(e.getMessage(), "Erro interno do Servido", "INTERNAL_SERVER_ERROR"));
        }
       
    }
}
