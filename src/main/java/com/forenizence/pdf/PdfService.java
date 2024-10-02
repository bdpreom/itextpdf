package com.forenizence.pdf;

import com.itextpdf.html2pdf.HtmlConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;


@Service
public class PdfService {
    @Autowired
    private PassportRepository passportRepository;


    public byte[] generatePassportPdf(Long passportId) throws IOException {
        Passport passport = passportRepository.findById(passportId)
                .orElseThrow(() -> new RuntimeException("Passport not found"));

        // Load HTML template from file
        String htmlTemplate = new String
                (Files.readAllBytes(new ClassPathResource("templates/passport_template.html").
                        getFile().toPath()));

        // Replace placeholders with actual data
        String htmlContent = htmlTemplate
                .replace("{{passportNumber}}", passport.getPassportNumber())
                .replace("{{nationality}}", passport.getNationality())
                .replace("{{expiryDate}}", passport.getExpiryDate());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Convert HTML to PDF
        HtmlConverter.convertToPdf(htmlContent, outputStream);

        return outputStream.toByteArray();
    }






}
