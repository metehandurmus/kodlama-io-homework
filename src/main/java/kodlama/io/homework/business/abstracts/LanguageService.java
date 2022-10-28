package kodlama.io.homework.business.abstracts;

import kodlama.io.homework.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();
    void delete(int id);
    void add(Language language);
    void update(Language language);
    Language getById(int id);
}
