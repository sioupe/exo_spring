package fr.diginamic.hello.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import fr.diginamic.hello.Dto.VilleDto;
import fr.diginamic.hello.Repository.DepartementRespository;
import fr.diginamic.hello.Repository.VilleRespository;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;

import fr.diginamic.hello.exception.VilleException;
import fr.diginamic.hello.mappers.VilleMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Service
public class VilleService {
    @Autowired
    VilleRespository villeRepository;
    @Autowired
    DepartementRespository departementRepository;




    public List<Ville> extractVilles() throws VilleException {

        List<Ville> villes = villeRepository.findAll();
        if (villes.isEmpty()) {
            throw new VilleException("Villes not found");
        }
        return villes;
    }

    public List<Ville> extractVilles  (Pageable pageable) {
        return villeRepository.findAll(pageable).getContent();
    }

    public Ville extractVille(int id) {

        return villeRepository.findById(id).orElse(null);
    }
    public Ville extractVille(String nom) throws VilleException {
        Ville ville = villeRepository.findByNom(nom);
        if (ville == null) {
            throw new VilleException("Ville nom non valide");
        }
        return ville;
    }

    @Transactional
    public List<Ville> ajouterVille(Ville ville) {
        if (ville.getDepartement() != null) {
            if (departementRepository.findById(ville.getDepartement().getId()) == null) {
                departementRepository.save(ville.getDepartement());
            }
            villeRepository.save(ville);
        }
       return villeRepository.findAll();
    }

    @Transactional
    public List<Ville> update(int idVille,Ville ville) {
        villeRepository.delete(villeRepository.findById(idVille).orElse(null));

        return villeRepository.findAll();
    }

    @Transactional
    public List<Ville> delete(int id) {
        villeRepository.delete(villeRepository.findById(id).orElse(null));
        return villeRepository.findAll();
    }
    public List<Ville> listVillePlusNbHabitant(int min){
        return villeRepository.findByNbHabitantsIsGreaterThan(min);
    }
    public List<Ville> listVillePlusNbHabitantParDepartement(int min, Departement departement)throws VilleException {
        List<Ville> villes = villeRepository.findByDepartementAndNbHabitantsIsGreaterThan(departement,min);

        if (villes.isEmpty()) {
            throw new VilleException("Villes not found");
        }
        return villes;
    }

    public List<Ville> listVilleNbHabitantComprisEntre(int min,int max){
        return villeRepository.findByNbHabitantsBetween(min,max);
    }
    public List<Ville> listVilleNbHabitantComprisEntreParDepartement(int min,int max,Departement departement) throws VilleException {
        List<Ville> villes = villeRepository.findByDepartementAndNbHabitantsBetween(departement,min,max);
        if (villes.isEmpty()) {
            throw new VilleException("Villes not found");
        }
        return villeRepository.findByDepartementAndNbHabitantsBetween(departement,min,max);
    }

    public List<Ville> trouverNPlusGrandeVille(Ville ville,int n) {
        Pageable pagination = PageRequest.of(0,n);
        return villeRepository.findByDepartementOrderByNbHabitantsDesc(ville.getDepartement(), pagination);
    }

    public void telechargerEnPdf(HttpServletResponse response,List<VilleDto> villes) throws IOException, DocumentException {

        response.setHeader("Content-Disposition","attachment; filename=villes.pdf");

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document,response.getOutputStream());
        document.open();
        document.addTitle("villes");
        document.newPage();
        BaseFont baseFont= BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
        for (VilleDto ville : villes) {
            Phrase phrase = new Phrase(ville.toString(),new Font(baseFont,10.0f,1,new BaseColor(0,51,80)));
            document.add(phrase);
        }
        document.close();
        response.flushBuffer();
    }

}
