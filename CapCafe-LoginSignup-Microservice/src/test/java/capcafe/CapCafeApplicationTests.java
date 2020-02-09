package capcafe;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.capcafe.dto.Employee;
import com.cg.capcafe.service.EmployeeServiceImpl;
@RunWith(SpringRunner.class)
@SpringBootTest
class CapCafeApplicationTests {
	
	@MockBean
	private EmployeeServiceImpl empService;

	@Test
	public void signUpTest() throws Exception{
		Employee mockEmp =new Employee(1,"abc@gmail.com","abcd","1234","male");
		Mockito.when(empService.signUp(mockEmp)).thenReturn(mockEmp);
		assertEquals(mockEmp, empService.signUp(mockEmp));
	}

}
