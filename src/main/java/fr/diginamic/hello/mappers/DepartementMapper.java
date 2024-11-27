package fr.diginamic.hello.mappers;

import fr.diginamic.hello.Dto.DepartementDto;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import org.springframework.stereotype.Component;

@Component
public class DepartementMapper {

    public DepartementDto toDto(Departement departement) {
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

    public Departement toEntity(DepartementDto departementDto) {
        Departement departement = new Departement();
        departement.setCodePostal(departementDto.getCodeDepartement());
        departement.setNom(departementDto.getNomDepartement());
        return departement;
    }
}
