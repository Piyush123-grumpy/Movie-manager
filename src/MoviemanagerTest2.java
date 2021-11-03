import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.Test;

class MoviemanagerTest2 {

	@Test
	void test() {
		Moviemanager tst = new Moviemanager();
		JPanel a= tst.addpanel;
		assertEquals(tst.addpanel,tst.addpanel);
	}

}
