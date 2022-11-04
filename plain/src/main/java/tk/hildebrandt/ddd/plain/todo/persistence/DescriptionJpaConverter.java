package tk.hildebrandt.ddd.plain.todo.persistence;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import tk.hildebrandt.ddd.plain.todo.Description;

@Converter(autoApply = true)
public class DescriptionJpaConverter implements AttributeConverter<Description, String> {
   @Override
   public String convertToDatabaseColumn(Description domainData) {
      return domainData.getValue();
   }

   @Override
   public Description convertToEntityAttribute(String dbData) {
      return new Description(dbData);
   }
}
