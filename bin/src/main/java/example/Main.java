package example;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;
import org.kie.api.runtime.KieSession;

import example.model.*;

public class Main {

	private static  KieContainer kieContainer(KieServices ks) {
		KieFileSystem kieFileSystem = ks.newKieFileSystem();
		kieFileSystem.write(ResourceFactory.newClassPathResource("Car.drl"));
		KieBuilder kb = ks.newKieBuilder(kieFileSystem);
		kb.buildAll();
		KieModule kieModule = kb.getKieModule();
		return ks.newKieContainer(kieModule.getReleaseId());
	}

	public static void main(String[] args) {

		Car car = new Car();

		try {
			// load up the knowledge base
	    KieServices ks = KieServices.Factory.get();
	    KieContainer kContainer = kieContainer(ks);
	    KieSession kSession = kContainer.newKieSession();
			car.setYear(1990);
			System.out.println("Prior");
			System.out.println(car.toString());
			if (ks == null) {
				System.out.println("KieServices null");
			}
			else if (kContainer == null) {
				System.out.println("KieContainer null");
			}
			else if (kSession == null) {
				System.out.println("KieSession null");
			}
			else {
				kSession.insert(car);
				kSession.fireAllRules();
				kSession.dispose();
			}
			System.out.println("After");
			System.out.println(car.toString());

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
}
