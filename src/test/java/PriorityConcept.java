import org.testng.annotations.Test;

public class PriorityConcept {

	@Test(priority=1)
	public static void aTest() {
		System.out.println("A");
	}
	@Test
	public static void bTest() {
		System.out.println("B");
	}
	@Test
	public static void cTest() {
		System.out.println("C");
	}
	@Test(priority=2)
	public static void dTest() {
		System.out.println("D");
	}
	@Test (priority=3)
	public static void eTest() {
		System.out.println("E");
	}
	
}

