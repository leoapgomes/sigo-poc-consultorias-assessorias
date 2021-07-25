package br.com.indtexbr.sigo.consultoriaseassessorias.dto;

import br.com.indtexbr.sigo.consultoriaseassessorias.models.Contrato;

public class ContratoDTO {

	private Long id;
	private String contrato;
	private String descricao;
	private String url;
	
	@Deprecated
	public ContratoDTO() {}
	
	public ContratoDTO(Contrato contrato) {
		this.id = contrato.getId();
		this.contrato = contrato.getContrato();
		this.descricao = contrato.getDescricao();
		this.url = contrato.getUrl();
	}
	
	public ContratoDTO(Long id, String contrato, String descricao, String url) {
		this.id = id;
		this.contrato = contrato;
		this.descricao = descricao;
		this.url = url;
	}
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	
	public String getContrato() {
		return contrato;
	}
	public String getUrl() {
		return url;
	}
		
	
}
