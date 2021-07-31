package br.edu.infnet.bootalunoapp.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.infnet.bootalunoapp.modelo.Aluno;
import br.edu.infnet.bootalunoapp.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired // injetando a depencia - no construtor
	private AlunoRepository alunoRepositorio;
	final static Logger logger = LoggerFactory.getLogger(AlunoService.class);

	
	
	public AlunoService() {
		logger.debug("entrou...");
//		this.alunoRepositorio = alunoRepositorio;
	}

	public AlunoService(AlunoRepository repo) {
		this.alunoRepositorio = repo;
	}

	@Transactional
	public Aluno salvar(Aluno aluno) {
		logger.debug("entrou...");
		return alunoRepositorio.save(aluno);
	}

	@Transactional(readOnly = true)
	public List<Aluno> listAll() {
		logger.debug("entrou...");
		return alunoRepositorio.findAll();
	}

	@Transactional(readOnly = true)
	public Aluno getAluno(String id) {
		// testar se o string nao é null
		logger.debug("entrou...");
		return alunoRepositorio.getOne(Integer.valueOf(id));
	}

	@Transactional
	public void delete(String id) {
		logger.debug("entrou...");
		alunoRepositorio.delete(getAluno(id));
	}

}
