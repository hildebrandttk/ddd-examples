package tk.hildebrandt.ddd.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class VerifyModuleStructureTest {
   @Test
   void verifyModularity() {
      ApplicationModules modules = ApplicationModules.of(TodoApp.class)
                                                     .verify();
      new Documenter(modules).writeModulesAsPlantUml()
                             .writeDocumentation();
   }
}
