package com.forenizence.pdf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class PdfController {

    @Autowired
    private PdfService pdfService;

    @GetMapping("/passports/{id}/pdf")
    public ResponseEntity<byte[]> downloadPassportPdf(@PathVariable Long id) throws IOException {
        byte[] pdfContents = pdfService.generatePassportPdf(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/pdf");
        headers.add("Content-Disposition", "attachment; filename=passport_" + id + ".pdf");

        return new ResponseEntity<>(pdfContents, headers, HttpStatus.OK);
    }
}