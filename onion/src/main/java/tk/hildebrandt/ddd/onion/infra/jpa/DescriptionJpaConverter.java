package tk.hildebrandt.ddd.onion.infra.jpa;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import tk.hildebrandt.ddd.onion.core.Description;

@Converter(autoApply = true)
public class DescriptionJpaConverter implements AttributeConverter<Description, String> {
   @Override
   public String convertToDatabaseColumn(Description domainData) {
      return domainData.value();
   }

   @Override
   public Description convertToEntityAttribute(String dbData) {
      return new Description(dbData);
   }
}
