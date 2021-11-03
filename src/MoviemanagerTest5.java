import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MoviemanagerTest5 {

	@Test
	void test() {
		Moviemanager tst = new Moviemanager();
		boolean result = true;
		assertEquals (result,tst.update);
	}

}
