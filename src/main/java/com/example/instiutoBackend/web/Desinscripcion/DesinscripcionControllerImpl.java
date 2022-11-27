package com.example.instiutoBackend.web.Desinscripcion;

import com.example.instiutoBackend.model.DTOS.DesinscripcionDTO;
import com.example.instiutoBackend.model.Desinscripcion;
import com.example.instiutoBackend.model.Respuesta;
import com.example.instiutoBackend.service.Desinscripcion.DesinscripcionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/desinscripciones")
@RequiredArgsConstructor
public class DesinscripcionControllerImpl implements DesinscripcionController {

    private final DesinscripcionService desinscripcionService;

    @Override
    @GetMapping("/findActivos")
    @ResponseStatus(HttpStatus.OK)
    public List<Desinscripcion> findSolicitudesActivas() {
        return desinscripcionService.findSolicitudesActivas();
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long contarDesinscripcionesActivas() {
        return desinscripcionService.contarDesinscripcionesActivas();
    }

    @Override
    @PostMapping("/getToken")
    @ResponseStatus(HttpStatus.OK)
    public void getToken(@RequestBody DesinscripcionDTO desinscripcionDTO) throws IOException {
        desinscripcionService.getToken(desinscripcionDTO);
    }

    @Override
    @PostMapping("/guardar")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta guardarDesinscripcion(@RequestBody DesinscripcionDTO desinscripcionDTO)  {
        return desinscripcionService.guardarDesinscripcion(desinscripcionDTO);
    }

    @Override
    @PostMapping("/cancelar")
    @ResponseStatus(HttpStatus.OK)
    public Respuesta eliminarDesinscripcion(@RequestBody DesinscripcionDTO desinscripcionDTO) throws IOException {
        System.out.println(desinscripcionDTO);
        return desinscripcionService.cancelarDescripcion(desinscripcionDTO);
    }
}
