package viniciushoffmanndev.desafio_itau_backend.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import viniciushoffmanndev.desafio_itau_backend.dto.TransactionRequest;
import viniciushoffmanndev.desafio_itau_backend.model.Transaction;
import viniciushoffmanndev.desafio_itau_backend.service.TransactionService;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    private TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }
    @PostMapping
    public ResponseEntity<Void> create(@Valid @RequestBody TransactionRequest request){
        if (request.getDataHora().isAfter(OffsetDateTime.now()) ||
        request.getValor() <=0){
            return ResponseEntity.unprocessableEntity().build();
        }
        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @DeleteMapping
    public ResponseEntity<Void> clear(){
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();
    }
}
