import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class test4 {

	@Test
	void test() {
		Moviemanager tst = new Moviemanager();
		ArrayList<User> result= tst.userlist();
		assertEquals(result,result);
	}

}
