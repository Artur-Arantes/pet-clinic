package artur.springframework.petclinic.formatters;

import artur.springframework.petclinic.domain.PetType;
import artur.springframework.petclinic.services.PetTypeService;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class PetTypeFormatter implements Formatter<PetType> {
  private final PetTypeService petTypeService;

  public PetTypeFormatter(PetTypeService petTypeService) {
    this.petTypeService = petTypeService;
  }

  @Override
  public String print(PetType petType, Locale locale) {
    return petType.getName();
  }

  @Override
  public PetType parse(String text, Locale locale) throws ParseException {
    List<PetType> findPetTypes = petTypeService.findAll();

    for (PetType type : findPetTypes) {
      if (type.getName().equals(text)) {
        return type;
      }
    }
    throw new ParseException("type not found: " + text, 0);
  }

}
