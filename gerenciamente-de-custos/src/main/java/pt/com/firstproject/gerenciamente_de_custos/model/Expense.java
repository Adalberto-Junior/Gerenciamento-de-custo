package pt.com.firstproject.gerenciamente_de_custos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "expenses")
public class Expense {

    @Id // Define que o campo "id" é a chave primária da tabela "expenses" no banco de dados.
    @GeneratedValue(strategy = GenerationType.AUTO) // Define que o valor do campo "id" será gerado automaticamente pelo banco de dados.
    private UUID id;
    private String description;
    private BigDecimal value;
    private LocalDate date;
    private String category;

    @CreatedDate // Define que o campo "creationDate" será preenchido automaticamente com a data de criação da despesa.
    private LocalDate creationDate;
    private String email;

    public Expense() {

    }
}
