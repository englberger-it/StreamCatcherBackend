package com.SaaB.StreamCatcher;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class StreamCatcherApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void createModuleDocumentation() {
		ApplicationModules modules = ApplicationModules.of(StreamCatcherApplication.class);
		new Documenter(modules)
				.writeDocumentation()
				.writeIndividualModulesAsPlantUml();
		modules.verify();
	}

}
