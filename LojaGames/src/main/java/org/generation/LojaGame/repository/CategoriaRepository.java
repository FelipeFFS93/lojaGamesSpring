package org.generation.LojaGame.repository;

import java.util.List;

import org.generation.LojaGame.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // informando para o spring que o CategoriaRepository é um repositorio
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllByDescricaoContainingIgnoreCase (String descricao);
		// select * tb_categoria where descricao like "%descricao%"
}
