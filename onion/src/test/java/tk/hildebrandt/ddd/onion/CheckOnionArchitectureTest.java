package tk.hildebrandt.ddd.onion;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "tk.hildebrandt.ddd.onion",
   importOptions = ImportOption.DoNotIncludeTests.class)
public class CheckOnionArchitectureTest {

   @ArchTest
   public static final ArchRule coreShouldNotAccessApiAndInfra = classes()
      .that()
      .resideInAPackage("..core..")
      .should()
      .onlyAccessClassesThat()
      .resideOutsideOfPackages("..api..", "..infra..");

   @ArchTest
   public static final ArchRule apiShouldNotAccessInfra = classes()
      .that()
      .resideInAPackage("..onion.api..")
      .should()
      .onlyAccessClassesThat()
      .resideOutsideOfPackages("..infra..");

   @ArchTest
   public static final ArchRule infraApiNotAccessInfraJpa = classes()
      .that()
      .resideInAPackage("..infra.api..")
      .should()
      .onlyAccessClassesThat()
      .resideOutsideOfPackages("..infra.jpa..");

   @ArchTest
   public static final ArchRule infraJpaNotAccessInfraApi = classes()
      .that()
      .resideInAPackage("..infra.jpa..")
      .should()
      .onlyAccessClassesThat()
      .resideOutsideOfPackages("..infra.api..");
}
