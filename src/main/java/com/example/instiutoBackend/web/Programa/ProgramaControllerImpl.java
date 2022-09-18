package com.example.instiutoBackend.web.Programa;

import com.example.instiutoBackend.model.Programa;
import com.example.instiutoBackend.service.Programa.ProgramaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programa")
@RequiredArgsConstructor
public class ProgramaControllerImpl implements ProgramaController{

    private final ProgramaService programaService;


    @Override
    @GetMapping("/findBy/{pageNo}/{pageSize}")
    @ResponseStatus(HttpStatus.OK)
    public List<Programa> findProgramasPaginado(@PathVariable("pageNo") Integer pageNo,
                                                @PathVariable("pageSize") Integer pageSize) {
        return programaService.findProgramasPaginado(pageNo, pageSize);
    }

    @Override
    @GetMapping("/count")
    @ResponseStatus(HttpStatus.OK)
    public Long count() {
        return programaService.count();
    }

    @Override
    @GetMapping("/findByNombre/{nombre}")
    @ResponseStatus(HttpStatus.OK)
    public List<Programa> findByNombre(@PathVariable("nombre") String nombre) {
        return programaService.findByNombre(nombre);
    }

    @Override
    @PostMapping("guardar")
    @ResponseStatus(HttpStatus.CREATED)
    public Programa guardarPrograma(@RequestBody @Validated Programa programa, BindingResult result) throws Exception {
        if (result.hasErrors()) {
            throw new Exception("Datos incompletos");
        }
        return programaService.guardarPrograma(programa);
    }

    @Override
    @DeleteMapping("/{idPrograma}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminarPrograma(@PathVariable Long idPrograma) throws Exception {
        programaService.elimnarPrograma(idPrograma);
    }
}
