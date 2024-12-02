package fr.diginamic.hello.testService;

import fr.diginamic.hello.Repository.VilleRespository;
import fr.diginamic.hello.entite.Departement;
import fr.diginamic.hello.entite.Ville;
import fr.diginamic.hello.service.VilleService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@ActiveProfiles("JeanMichel")
@AutoConfigureMockMvc
public class TestVilleService {
    @Autowired
    private VilleService villeService;

    @MockitoBean
    private VilleRespository villeRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testfindAllVilles() throws Exception {
        Ville ville = new Ville("Angers",142000);
        ville.setDepartement(new Departement("Maine-et-Loire","49"));
        when(villeRepository.findAll()).thenReturn(List.of(ville));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/villes")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Angers")))
                .andExpect(jsonPath("$[0].nomVille",is("Angers")))
                .andExpect(jsonPath("$[0].codeDepartement",is("49")));

    }
}
