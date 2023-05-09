package tk.hildebrandt.ddd.domainbased.todo.persistence;

import java.time.Instant;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import tk.hildebrandt.ddd.domainbased.todo.Description;
import tk.hildebrandt.ddd.domainbased.todo.DueDate;

@Converter(autoApply = true)
public class DueDateJpaConverter implements AttributeConverter<DueDate, Long> {
   @Override
   public Long convertToDatabaseColumn(DueDate domainData) {
      if (domainData == null) {
         return null;
      }
      return domainData.getValue()
                       .getEpochSecond();
   }

   @Override
   public DueDate convertToEntityAttribute(Long dbData) {
      if (dbData == null) {
         return null;
      }
      return new DueDate(Instant.ofEpochMilli(dbData));
   }
}
