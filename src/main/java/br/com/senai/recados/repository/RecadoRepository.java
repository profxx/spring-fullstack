package br.com.senai.recados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.senai.recados.entity.Recado;

@Repository
public interface RecadoRepository extends JpaRepository<Recado, Long>{

}
