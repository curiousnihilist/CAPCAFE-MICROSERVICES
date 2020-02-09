package capcafe;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.capcafe.dto.Admin;
import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.dto.Login;
import com.cg.capcafe.service.EmployeeServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeeServiceImpl.class)
class CafeTests {

	@MockBean
	private EmployeeServiceImpl empService;

	Employee mockEmp = new Employee(1, "abc@gmail.com", "abcd", "1234", "male");

	@Test
	public void signUpTest() throws Exception {
		Employee mockEmp = new Employee(1, "abc@gmail.com", "abcd", "1234", "male");
		Mockito.when(empService.signUp(mockEmp)).thenReturn(mockEmp);
		assertEquals(mockEmp, empService.signUp(mockEmp));
	}

	@Test
	public void loginTest() throws Exception {
		int id = 1;
		String password = "1234";
		Mockito.when(empService.login(id, password)).thenReturn(mockEmp);
		assertEquals(mockEmp, empService.login(id, password));

	}

	@Test
	public void adminLogin() throws Exception {
		Admin mockAdmin = new Admin(5, "abc@gmail.com", "abc", "harshita");
		int id = 5;
		String password = "12345";
		Mockito.when(empService.adminLogin(id, password)).thenReturn(mockAdmin);
		assertEquals(mockAdmin, empService.adminLogin(id, password));
	}

}
