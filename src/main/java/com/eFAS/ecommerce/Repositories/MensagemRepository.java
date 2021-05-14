package com.eFAS.ecommerce.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eFAS.ecommerce.model.Mensagem;
import com.eFAS.ecommerce.model.Usuario;

public interface MensagemRepository extends JpaRepository<Mensagem, Long> {

	public List<Mensagem> findAllByDestinatarioContaining(Usuario destinatario);
	public List<Mensagem> findAllByRemetenteContaining(Usuario remetente);
	public List<Mensagem> findAllByTextoContainingIgnoreCase(String texto);
}
