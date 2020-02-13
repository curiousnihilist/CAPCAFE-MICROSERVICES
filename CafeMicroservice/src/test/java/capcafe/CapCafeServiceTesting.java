package capcafe;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.cg.capcafe.dto.Cafe;
import com.cg.capcafe.exception.CafeNotFoundException;
import com.cg.capcafe.repo.CafeRepository;
import com.cg.capcafe.repo.MenuRepository;
import com.cg.capcafe.repo.OrderRepository;
import com.cg.capcafe.service.CafeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class CapCafeServiceTesting {
	
	CafeRepository cafeRepoMock;
	OrderRepository orderRepoMock;
	CafeServiceImpl service;
	
	@Test
	public void testSearchCafeById() throws CafeNotFoundException {
		
		CafeRepository cafeRepoMock = mock(CafeRepository.class);
		OrderRepository orderRepoMock = mock(OrderRepository.class);
		service = new CafeServiceImpl(cafeRepoMock,orderRepoMock);
		Cafe cafe = new Cafe();
		cafe.setCafeId(2);
		cafe.setLocation("Mumbai");
		cafe.setName("Silly Chilly");
		cafe.setOwner("Akash Verma");
		when(cafeRepoMock.findById(2)).thenReturn(Optional.of(cafe));
		assertEquals(service.searchById(2),cafe);
		
	}
	
	
	

}
