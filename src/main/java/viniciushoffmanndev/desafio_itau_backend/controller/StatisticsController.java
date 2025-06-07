package viniciushoffmanndev.desafio_itau_backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import viniciushoffmanndev.desafio_itau_backend.dto.StatisticResponse;
import viniciushoffmanndev.desafio_itau_backend.service.TransactionService;

import java.util.DoubleSummaryStatistics;

@AllArgsConstructor
@RestController
@RequestMapping("/estatistica")
public class StatisticsController {

    private final TransactionService transactionService;

    @GetMapping
    public ResponseEntity<StatisticResponse> getStatistics(){
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticResponse(stats));
    }
}
