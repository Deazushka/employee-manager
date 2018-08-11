package by.training.employeemanager.web;

import by.training.employeemanager.entity.Profession;
import by.training.employeemanager.repository.ProfessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profession")
public class ProfessionController {
    private ProfessionRepository professionRepository;

    public ProfessionController() {
    }
    @Autowired
    public ProfessionController(ProfessionRepository professionRepository) {
        this.professionRepository = professionRepository;
    }
    @GetMapping("/")
    @ResponseBody
    Iterable<Profession> getAll() {
        return professionRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    Profession getProfession(@PathVariable Long id) {
        return professionRepository.findById(id).orElse(null);
    }

    @PostMapping("/")
    @ResponseBody
    void postProfession(@RequestBody Profession department) {
        professionRepository.save(department);
    }
}


