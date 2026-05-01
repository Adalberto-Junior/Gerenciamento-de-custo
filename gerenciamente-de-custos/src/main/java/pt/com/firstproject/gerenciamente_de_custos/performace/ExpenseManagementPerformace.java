package pt.com.firstproject.gerenciamente_de_custos.performace;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.com.firstproject.gerenciamente_de_custos.model.Expense;
import pt.com.firstproject.gerenciamente_de_custos.repository.ExpenseRepository;

@RequestMapping("expensemanagement/performace")
@RestController
@EnableCaching
public class ExpenseManagementPerformace {
    
    @Autowired
    ExpenseRepository expenseRepository;

    @GetMapping("/without-pagination")
    public ResponseEntity<List<Expense>> listWithoutPagination() {
        long start = System.currentTimeMillis();
        var expenses = expenseRepository.findAll();

        long end = System.currentTimeMillis();

        System.out.println("Time without pagination: " + (end - start) + " ms");
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/with-pagination") //localhost:8080?page=10&size=26
    public ResponseEntity<Page<Expense>> listWithPagination(Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var expenses = expenseRepository.findAll(pageable);

        stopWatch.stop();

        System.out.println("Time with pagination: " + stopWatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(expenses);
    }

    @GetMapping("/with-pagination/{email}") //localhost:8080?page=10&size=26
    public ResponseEntity<Page<Expense>> listWithPaginationByEmail(@PathVariable String email ,Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var expenses = expenseRepository.findByEmail(email, pageable);

        stopWatch.stop();

        System.out.println("Time with pagination: " + stopWatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(expenses);
    }

    @Cacheable(value = "ExpenseManagementByEmailCache", key = " #email + '-' + #pageable.pageNumber + '-' + #pageable.pageSize + '-'")
    @GetMapping("/cache/{email}")
    public ResponseEntity<Page<Expense>> cacheWithPaginactionByEmail(@PathVariable String email, Pageable pageable) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        var expenses = expenseRepository.findByEmail(email, pageable);

        stopWatch.stop();

        System.out.println("Time with pagination and cache: " + stopWatch.getTotalTimeMillis() + " ms");
        return ResponseEntity.ok(expenses);
    }
    
}
