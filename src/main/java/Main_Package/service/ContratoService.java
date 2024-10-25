package Main_Package.service;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import Main_Package.model.Contrato;
import Main_Package.repository.ContratoRepository;

import java.io.FileOutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.web.bind.annotation.ModelAttribute;

public class ContratoService {

	
	private ContratoRepository contratoRepository;
	
    public void gerarContrato(Contrato contrato) throws Exception {
        String nomeArquivo = "contrato_" + contrato.getId() + ".pdf";
        PdfWriter writer = new PdfWriter(new FileOutputStream(nomeArquivo));
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Adicionando informações ao contrato
        document.add(new Paragraph("Contrato de Prestação de Serviço"));
        document.add(new Paragraph("Data de Início: " + contrato.getDataInicio().format(formatter)));
        document.add(new Paragraph("Data de Fim: " + contrato.getDataFim().format(formatter)));
        document.add(new Paragraph("Freelancer: " + contrato.getFreelancer().getNome()));
        document.add(new Paragraph("Cliente: " + contrato.getCliente().getNome()));
        document.add(new Paragraph("Termos do Contrato:"));
        document.add(new Paragraph(contrato.getTermos()));

        // Fechar o documento PDF
        document.close();
    }
    
    public Contrato buscarContratoPorId(Long id) {
        return contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato não encontrado para o ID: " + id));
    }

    public Contrato salvarContrato(@ModelAttribute Contrato contrato) {
    	return contratoRepository.save(contrato);
    }


}
