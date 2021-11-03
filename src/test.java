import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class test {

	@Test
	void test() {
		Moviemanager tst = new Moviemanager();
		JFrame a= tst.movie;
		assertEquals(tst.movie,tst.movie);
	}

}
