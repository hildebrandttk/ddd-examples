package tk.hildebrandt.ddd.modulith.user.persistence;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tk.hildebrandt.ddd.modulith.user.Lastname;

@Converter(autoApply = true)
public class LastnameJpaConverter implements AttributeConverter<Lastname, String> {
   @Override
   public String convertToDatabaseColumn(Lastname domainData) {
      return domainData.getValue();
   }

   @Override
   public Lastname convertToEntityAttribute(String dbData) {
      return new Lastname(dbData);
   }
}
