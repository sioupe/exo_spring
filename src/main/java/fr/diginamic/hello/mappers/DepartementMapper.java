package fr.diginamic.hello.mappers;

import fr.diginamic.hello.Dto.DepartementDto;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartementMapper {

    public static DepartementDto toDto(Departement departement) {
        DepartementDto departementDto = new DepartementDto();
        departementDto.setCodeDepartement(departement.getCodePostal());
        departementDto.setNomDepartement(departementDto.getNomDepartement());
        int nbHabitants=0;
        for (Ville ville : departement.getVilles()) {
            nbHabitants+=ville.getNbHabitants();
        }
        departementDto.setNbHabitants(nbHabitants);
        return departementDto;
    }

    public static List<DepartementDto> toDto(List<Departement> departements) {
        List<DepartementDto> departementDtos = new ArrayList<>();
        for (Departement departement : departements) {
            departementDtos.add(toDto(departement));
        }
        return departementDtos;
    }

    public static Departement toEntity(DepartementDto departementDto) {
        Departement departement = new Departement();
        departement.setCodePostal(departementDto.getCodeDepartement());
        departement.setNom(departementDto.getNomDepartement());
        return departement;
    }
}
