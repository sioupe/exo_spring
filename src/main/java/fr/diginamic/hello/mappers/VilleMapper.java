package fr.diginamic.hello.mappers;

import fr.diginamic.hello.Dto.VilleDto;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class VilleMapper {
    public static VilleDto toDto(Ville ville) {
        VilleDto dto = new VilleDto();
        dto.setCodeVille(ville.getId());
        dto.setNomVille(ville.getNom());
        dto.setNbHabitants(ville.getNbHabitants());
        dto.setCodeDepartement(ville.getDepartement().getCodePostal());
        dto.setNomDepartement(ville.getDepartement().getNom());
        return dto;
    }
    public static List<VilleDto> toDto(List<Ville> villes) {
        List<VilleDto> dtos = new ArrayList<>();
        for (Ville ville : villes) {
            dtos.add(toDto(ville));
        }
        return dtos;
    }

    public static Ville toEntity(VilleDto dto) {
        Ville ville = new Ville();
        ville.setId(dto.getCodeVille());
        ville.setNom(dto.getNomVille());
        ville.setNbHabitants(dto.getNbHabitants());
        ville.setDepartement(new Departement(dto.getNomDepartement(), dto.getCodeDepartement()));
        return ville;
    }
}
