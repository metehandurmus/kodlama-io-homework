package kodlama.io.homework.dataAccess.concretes;

import kodlama.io.homework.dataAccess.abstracts.LanguageRepository;
import kodlama.io.homework.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {

    private List<Language> languages;

    public InMemoryLanguageRepository() {
        languages = new ArrayList<>();
        languages.add(new Language(1,"C#"));
        languages.add(new Language(2,"PHP"));
        languages.add(new Language(3,"Python"));
        languages.add(new Language(5,"C++"));
    }

    @Override
    public List<Language> getAll() {
        return languages;
    }

    @Override
    public void delete(int id) {
        languages.remove(this.getById(id));
    }

    @Override
    public void add(Language language) {
        languages.add(language);
    }

    @Override
    public void update(int index, Language language) {
        this.languages.set(index,language);
    }

    @Override
    public Language getById(int id) {
        for (Language language : languages) {
            if (language.getId() == id) {
                return language;
            }
        }
        return null;
    }
}
