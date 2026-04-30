package pt.com.firstproject.gerenciamente_de_custos.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.Column;
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

    @Column(nullable = false)
    private String description;
    
    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private LocalDate paidDate;

    @Column(length = 100, nullable = false) // Define que o campo "category" terá um comprimento máximo de 100 caracteres na tabela "expenses" do banco de dados.
    private String category;

    @CreationTimestamp // Define que o campo "creationDate" será preenchido automaticamente com a data de criação da despesa.
    private LocalDate creationDate;

    @Column(nullable = false) // Define que o campo "email" terá um comprimento máximo de 100 caracteres na tabela "expenses" do banco de dados.
    private String email;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(LocalDate PaidDate) {
        this.paidDate = PaidDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Expense() {

    }

    @Override
    public String toString() {
        return "Expense [id=" + id + ", description=" + description + ", price=" + price + ", PaidDate=" + paidDate
                + ", category=" + category + ", creationDate=" + creationDate + ", email=" + email + "]";
    }

    
}
