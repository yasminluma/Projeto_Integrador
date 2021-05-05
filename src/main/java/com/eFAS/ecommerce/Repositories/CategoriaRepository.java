package com.eFAS.ecommerce.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eFAS.ecommerce.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
	
	public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
	
	public List<Categoria> findByOrganicoTrue();
	
	public List<Categoria> findByIndustrialTrue();

}
