package com.mentoring.amarchuk.tickets.web;

import com.mentoring.amarchuk.tickets.facade.BookingFacade;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.tool.xml.XMLWorkerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Artsiom Prokharau 10.07.2021
 */

@Controller
public class PdfController {

    @Autowired
    BookingFacade bookingFacade;

    @GetMapping(value = "/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public FileSystemResource getFile(Model model) throws IOException, DocumentException {
        model.addAttribute("allUser", bookingFacade.getAllUsers());
        Document document = new Document();
        FileOutputStream fileOutputStream = new FileOutputStream("html.pdf");
        PdfWriter writer = PdfWriter.getInstance(document, fileOutputStream);
        document.open();
        XMLWorkerHelper.getInstance().parseXHtml(writer, document, new FileInputStream("src/main/webapp/WEB-INF/templates/users.html"));
        document.close();

        return new FileSystemResource("html.pdf");
    }
}

