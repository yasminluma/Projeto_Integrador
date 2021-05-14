package com.eFAS.ecommerce.Control;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eFAS.ecommerce.Repositories.MensagemRepository;
import com.eFAS.ecommerce.model.Mensagem;
import com.eFAS.ecommerce.model.Produto;
import com.eFAS.ecommerce.model.Usuario;

@RestController
@RequestMapping("/mensagem")
@CrossOrigin("*")
public class MensagemController {

	@Autowired MensagemRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Mensagem>> getAll()
	{
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Mensagem> getById(@PathVariable long id)
	{
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/destinatario/{destinatario}")
	public ResponseEntity<List<Mensagem>> getByDestinatario(@PathVariable Usuario destinatario)
	{
		return ResponseEntity.ok(repository.findAllByDestinatarioContaining(destinatario));
	}
	
	@GetMapping("/remetente/{remetente}")
	public ResponseEntity<List<Mensagem>> getByRemetente(@PathVariable Usuario remetente)
	{
		return ResponseEntity.ok(repository.findAllByRemetenteContaining(remetente));
	}
	
	@GetMapping("/texto/{texto}")
	public ResponseEntity<List<Mensagem>> getByTexto(@PathVariable String texto)
	{
		return ResponseEntity.ok(repository.findAllByTextoContainingIgnoreCase(texto));
	}
	
	@PostMapping
	public ResponseEntity<Mensagem> post(@RequestBody Mensagem mensagem)
	{
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(mensagem));
	}
	
	
}
