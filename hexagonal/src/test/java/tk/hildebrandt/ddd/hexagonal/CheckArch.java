package tk.hildebrandt.ddd.hexagonal;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class CheckArch {

   @Test
   public void Services_should_only_be_accessed_by_Controllers() {
      JavaClasses importedClasses = new ClassFileImporter().importPackages("tk.hildebrandt.ddd.hexagonal");

      ArchRule myRule = classes()
         .that().resideInAPackage("..service..")
         .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

      myRule.check(importedClasses);
   }
   //https://tech.willhaben.at/enforcing-code-structure-with-archunit-7af87fdab46
   @Test
   public void Layers() {
      JavaClasses importedClasses = new ClassFileImporter().importPackages("tk.hildebrandt.ddd.hexagonal");

      ArchRule myRule = classes()
         .that().resideInAPackage("..service..")
         .should().onlyBeAccessed().byAnyPackage("..controller..", "..service..");

      myRule.check(importedClasses);
   }
}
