package com.example.POS_System.controller;


import com.example.POS_System.model.Invoice;
import com.example.POS_System.model.InvoiceItem;
import com.example.POS_System.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
    @Autowired
    private InvoiceService invoiceService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/invoice")
    public ResponseEntity<Invoice> checkout(@RequestBody List<InvoiceItem> invoiceItems) {

        Invoice invoice = invoiceService.generateInvoice(invoiceItems);
        return ResponseEntity.ok(invoice);
    }
}

