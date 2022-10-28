package kodlama.io.homework.business.concretes;

import kodlama.io.homework.business.abstracts.LanguageService;
import kodlama.io.homework.dataAccess.abstracts.LanguageRepository;
import kodlama.io.homework.entities.concretes.Language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {

    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    @Override
    public void add(Language language) {
        boolean flag = true;
        List<Language> languages = languageRepository.getAll();
        if(language.getName().trim().replace(" ","").length()==0) {
            flag = false;
        } else {
            for(Language l:languages) {
                if(l.getName().equals(language.getName()) || l.getId() == language.getId()){
                    flag = false;
                }
            }
        }
        if(flag) {
            languageRepository.add(language);
        } else {
            System.err.println("Bu ada sahip veya idye sahip programlama dili mevcut veya programlama dilini doldurmadınız.");
        }

    }

    @Override
    public void update(Language language) {
        int index = -1;
        for (int i = 0; i < languageRepository.getAll().size(); i++) {
            if (languageRepository.getAll().get(i).getId() == language.getId()){
                index = i;
            }
        }
        if(index != -1) {
            languageRepository.update(index, language);
        }
    }

    @Override
    public Language getById(int id){
        return languageRepository.getById(id);
    }
}
