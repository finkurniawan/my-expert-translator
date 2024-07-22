package thefantasticfour.myExpertTranslator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import thefantasticfour.myExpertTranslator.model.Translate;

public interface TranslateRepository extends JpaRepository<Translate, Integer> {
}
