package tk.hildebrandt.ddd.hexagonal;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "tk.hildebrandt.ddd.hexagonal",
   importOptions = ImportOption.DoNotIncludeTests.class)
public class CheckHexagonalArchitectureTest {
   @ArchTest
   public static final ArchRule servicesShouldOnlyAccessedByActiveAdapterAndServices = classes()
      .that()
      .resideInAPackage("..service..")
      .should()
      .onlyBeAccessed()
      .byAnyPackage("..adapter.active..", "..service..");

   @ArchTest
   public static final ArchRule passivePortsShouldOnlyAccessedByServices = classes()
      .that()
      .resideInAPackage("..port.passive..")
      .should()
      .onlyBeAccessed()
      .byAnyPackage("..service..");

   @ArchTest
   public static final ArchRule activePortsShouldOnlyAccessedByActiveAdapters = classes()
      .that()
      .resideInAPackage("..port.active..")
      .should()
      .onlyBeAccessed()
      .byAnyPackage("..adapter.active..");

   @ArchTest
   public static final ArchRule domainShouldOnlyAccessedByItselfAndServicesAndPassivePortsAndAdapters = classes()
      .that()
      .resideInAPackage("..domain..")
      .should()
      .onlyBeAccessed()
      .byAnyPackage("..domain..", "..service..", "..port.passive..", "..adapter.passive..");
}
