package com.library.library.Controllers;

import com.library.library.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transactions")
@CrossOrigin(origins = {"http://localhost:3000"})
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/issue")
    public ResponseEntity<String> issueBook(@RequestParam("cardId") int cardId,
                                            @RequestParam("bookId") int bookId) throws Exception {
        String transactionId = transactionService.issueBooks(cardId, bookId);
        return new ResponseEntity<>("Transaction successful! Your Txn ID: " + transactionId, HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam("cardId") int cardId,
                                             @RequestParam("bookId") int bookId) throws Exception {
        String transactionId = transactionService.returnBooks(cardId, bookId);
        return new ResponseEntity<>("Return successful! Your Txn ID: " + transactionId, HttpStatus.OK);
    }
}
