package tk.hildebrandt.ddd.modulith.user.persistence;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tk.hildebrandt.ddd.modulith.user.Firstname;

@Converter(autoApply = true)
public class FirstnameJpaConverter implements AttributeConverter<Firstname, String> {
   @Override
   public String convertToDatabaseColumn(Firstname domainData) {
      return domainData.getValue();
   }

   @Override
   public Firstname convertToEntityAttribute(String dbData) {
      return new Firstname(dbData);
   }
}
