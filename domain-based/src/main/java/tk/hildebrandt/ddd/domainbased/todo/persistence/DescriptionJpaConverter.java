package tk.hildebrandt.ddd.domainbased.todo.persistence;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import tk.hildebrandt.ddd.domainbased.todo.Description;

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
