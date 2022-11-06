package tk.hildebrandt.ddd.modulith;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.docs.Documenter;
import org.springframework.modulith.model.ApplicationModules;

public class VerifyModuleStructureTest {
   @Test
   void verifyModularity() {
      ApplicationModules modules = ApplicationModules.of(TodoApp.class)
                                                     .verify();
      new Documenter(modules).writeModulesAsPlantUml()
                             .writeDocumentation();
   }
}
