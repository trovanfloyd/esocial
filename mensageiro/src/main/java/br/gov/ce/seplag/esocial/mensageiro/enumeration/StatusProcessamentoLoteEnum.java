package br.gov.ce.seplag.esocial.mensageiro.enumeration;

public enum StatusProcessamentoLoteEnum {

	LOTE_EM_PROCESSAMENTO("lote em processamento"),
	LOTE_PROCESSADO_COM_SUCESSO("lote processado com sucesso"),
	ERRO_ENVIO_LOTE("erro envio lote");
	
	private String descricao;
	

	StatusProcessamentoLoteEnum(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return descricao;
    }
    
}
