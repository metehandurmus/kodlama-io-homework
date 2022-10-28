package kodlama.io.homework.dataAccess.abstracts;

import kodlama.io.homework.entities.concretes.Language;

import java.util.List;

public interface LanguageRepository {
    List<Language> getAll();
    void delete(int id);
    void add(Language language);
    void update(int index, Language language);
    Language getById(int id);
}
