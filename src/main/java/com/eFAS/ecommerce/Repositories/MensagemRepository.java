package com.eFAS.ecommerce.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eFAS.ecommerce.model.Mensagem;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

	public List<Mensagem> findAllByDestinatarioContainingIgnoreCase(String destinatario);
	public List<Mensagem> findAllByRemetenteContainingIgnoreCase(String remetente);
	public List<Mensagem> findAllByTextoContainingIgnoreCase(String texto);
}
