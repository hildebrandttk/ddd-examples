package tk.hildebrandt.ddd.modulith.todo.persistence;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tk.hildebrandt.ddd.modulith.todo.Description;

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
