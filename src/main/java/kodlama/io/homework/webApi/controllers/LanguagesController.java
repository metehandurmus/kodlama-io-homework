package kodlama.io.homework.webApi.controllers;

import kodlama.io.homework.business.abstracts.LanguageService;
import kodlama.io.homework.entities.concretes.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {

    private LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping("/get/all")
    public List<Language> getAll(){
        return languageService.getAll();
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }

    @GetMapping("/get/{id}")
    public Language getById(@PathVariable int id) {
        return this.languageService.getById(id);
    }

    @PostMapping("/add")
    public void add(@RequestBody Language language) {
        this.languageService.add(language);
    }

    @PutMapping("/update")
    public void update(@RequestBody Language language) {
        this.languageService.update(language);
    }
}
