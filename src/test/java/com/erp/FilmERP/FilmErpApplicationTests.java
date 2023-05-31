package com.erp.FilmERP;

import com.erp.FilmERP.DAO.DirectorsDAO;
import com.erp.FilmERP.model.Directors;
import com.erp.FilmERP.serveis.directors.DirectorService;
import java.util.List;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
class FilmErpApplicationTests {

    @Autowired
    @Mock
    private DirectorService directorService;

    @Test
    void eliminarDirectorTest() {
        // Obtener la lista de Directores
        List<Directors> directores = directorService.llistarDirectors();

        // Verificar que hay directores en la lista
        assertTrue(!directores.isEmpty());

        // Obtener un director aleatorio
        Directors directorEliminar = directores.get(new Random().nextInt(directores.size()));

        // Obtener el id del director aleatorio
        String idDirectorEliminar = directorEliminar.getCorreu();

        // Eliminar el director aleatorio
        Directors director = directorService.cercarDirectorPorCorreo(idDirectorEliminar);
        directorService.eliminarDirector(director);

        // Verificar que el director fue eliminado correctamente
        assertEquals(directores.size() - 1, directorService.llistarDirectors().size());

    }

}
