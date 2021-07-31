package br.edu.infnet.bootalunoapp.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;

@SpringBootTest
public class AlunoServiceTest {

	@InjectMocks
	private AlunoService service;
	
	@Mock
	private AlunoRepository repo;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	/**  Teste Unitário e o padrão AAA(Arrange, Act, Assert) **/
	@Test
	public void deveriaSalvarAluno() {
		
		//Arrange
		AlunoRepository repo = Mockito.mock(AlunoRepository.class);
		AlunoService service = new AlunoService(repo);		
		when(repo.save(Mockito.any(Aluno.class))).thenReturn(new Aluno());
		
		Aluno aluno = new Aluno();
		aluno.setId(1);
		
		when(repo.save(Mockito.any(Aluno.class))).thenReturn(aluno);
		
		// Act
		Aluno alunoSalvo = service.salvar(new Aluno());
		
		// Assert
		assertNotNull(alunoSalvo);
		assertEquals(1, aluno.getId());
		
	}
	
	/**  Teste Unitário e o usando a Injeção de Dependencias do Spring  **/
	@Test
	public void deveriaSalvarAlunoSpring() {
		
		Aluno aluno = new Aluno();
		aluno.setId(1);
		
		when(repo.save(Mockito.any(Aluno.class))).thenReturn(aluno);
		
		// Act
		Aluno alunoSalvo = service.salvar(new Aluno());
		
		// Assert
		assertNotNull(alunoSalvo);
		assertEquals(1, aluno.getId());
		
		verify(repo).save(Mockito.any());
	}
	
	/**  Teste Unitário e o usando a Injeção de Dependencias do Spring  **/
	@Test
	public void deveriaListarAlunosSpring() {
		
		Aluno aluno1 = new Aluno();
		aluno1.setId(1);
		aluno1.setNome("Paulo Marinho");
		
		Aluno aluno2 = new Aluno();
		aluno2.setId(2);
		aluno2.setNome("Ricardo Pontes");
		
		doReturn(Arrays.asList(aluno1, aluno2)).when(repo).findAll();
		
		List<Aluno> alunoLista = service.listAll();
						
		assertEquals(2, alunoLista.size());
		assertNotNull(alunoLista);
		
		
		verify(repo).findAll();
		
		
	}

}
