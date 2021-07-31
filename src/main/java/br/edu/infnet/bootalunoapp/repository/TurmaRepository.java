package br.edu.infnet.bootalunoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.bootalunoapp.modelo.Turma;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

}
