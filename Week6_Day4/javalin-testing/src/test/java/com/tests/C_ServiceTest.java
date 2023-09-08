package com.tests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.model.EmployeeLogin;
import com.repository.LoginRepository;
import com.service.LoginService;

import io.javalin.http.Context;

public class C_ServiceTest {
	@InjectMocks
	LoginService lServ;
	
	// This mocked object IS being injected. Because we have a constructor
	// that accepted this data, Mockito is using Constructor injection
	@Mock
	LoginRepository dummyRepo = mock(LoginRepository.class);
	
	// This Mocked Object is NOT being injected. We are passing it in
	// as an argument to the appropriate method
	@Mock
	Context dummyCtx = mock(Context.class);
	
	@Before
	public void setUp() {
		lServ = new LoginService();
		
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void loginServiceTest_01() {
		EmployeeLogin request = new EmployeeLogin(1,1,"dummyUsername", "dummyPassword");
		EmployeeLogin response = new EmployeeLogin(1,1,"dummyUsername", "dummyPassword");
		
		// When my dummyContext Object has the 'bodyAsClass' method called, what should the response be from that method?
		when(dummyCtx.bodyAsClass(EmployeeLogin.class)).thenReturn(request);
		when(dummyRepo.selectLoginByCredentials(request.getLogin_name(), request.getLogin_pass())).thenReturn(response);		
		when(dummyCtx.status(200)).thenReturn(dummyCtx);
		
		// The following 3 lines are the 'actual test'
		lServ.login(dummyCtx);
		verify(dummyCtx).status(200);
		verify(dummyCtx).result("Login Successful");
	}
	
	@Test
	public void loginServiceTest_02() {
		EmployeeLogin el = new EmployeeLogin(1,1,"dummyUsername", "dummyPassword");
		
		when(dummyCtx.bodyAsClass(EmployeeLogin.class)).thenReturn(el);
		when(dummyRepo.selectLoginByCredentials(el.getLogin_name(), el.getLogin_pass())).thenReturn(null);
		when(dummyCtx.status(400)).thenReturn(dummyCtx);
		
		lServ.login(dummyCtx);
		
		verify(dummyCtx).status(400);
		verify(dummyCtx).result("Login Unsuccessful");
	}
}
