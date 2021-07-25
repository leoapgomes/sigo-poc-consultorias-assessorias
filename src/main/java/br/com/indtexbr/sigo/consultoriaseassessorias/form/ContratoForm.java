package br.com.indtexbr.sigo.consultoriaseassessorias.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.indtexbr.sigo.consultoriaseassessorias.models.Contrato;

public class ContratoForm {

	@NotNull @NotEmpty
	private String contrato;
	
	@NotNull @NotEmpty
	private String descricao;
	
	@NotNull @NotEmpty
	private String url;	
	
	public String getContrato() {
		return contrato;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getUrl() {
		return url;
	}		
		
	public Contrato toContrato() {
		Contrato contrato = new Contrato();
		contrato.setDescricao(descricao);
		contrato.setContrato(this.contrato);
		contrato.setUrl(url);
		
		return contrato;
		
	}
	
	
	
}
