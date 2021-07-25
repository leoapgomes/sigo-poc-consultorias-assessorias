package br.com.indtexbr.sigo.consultoriaseassessorias.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.indtexbr.sigo.consultoriaseassessorias.dto.ContratoDTO;
import br.com.indtexbr.sigo.consultoriaseassessorias.form.ContratoForm;
import br.com.indtexbr.sigo.consultoriaseassessorias.models.Contrato;
import br.com.indtexbr.sigo.consultoriaseassessorias.repository.ContratoRepository;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

	@Autowired
	private ContratoRepository contratoRepository;
	
	@GetMapping
	public List<ContratoDTO> all(){
	
		List <Contrato> contratos = contratoRepository.findAll();
		return contratos.stream().map(ContratoDTO::new).collect(Collectors.toList());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContratoDTO> get(@PathVariable Long id){
		
		Optional<Contrato> contrato = contratoRepository.findById(id);
		if (contrato.isPresent()) {
			return ResponseEntity.ok(new ContratoDTO(contrato.get()));
		}
		
		return ResponseEntity.notFound().build();		
	}	


	@PostMapping
	@Transactional
	public ResponseEntity<ContratoDTO> post(@RequestBody @Valid ContratoForm form, UriComponentsBuilder uriBuilder) {
		
		Contrato contrato = form.toContrato();
		contratoRepository.save(contrato);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(contrato.getId()).toUri();
		return ResponseEntity.created(uri).body( new ContratoDTO(contrato) );
	}	
	
	

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ContratoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ContratoForm form) {
		
		Optional<Contrato> optional = contratoRepository.findById(id);
		if (optional.isPresent()) {
			Contrato contrato = contratoRepository.getOne(id);
			
			contrato.setDescricao(form.getDescricao());
			contrato.setContrato(form.getContrato());
			contrato.setUrl(form.getUrl());
			
			System.out.println(form);
			
			return ResponseEntity.ok(new ContratoDTO(contrato));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Contrato> optional = contratoRepository.findById(id);
		if (optional.isPresent()) {
			contratoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}	
	
	
}
