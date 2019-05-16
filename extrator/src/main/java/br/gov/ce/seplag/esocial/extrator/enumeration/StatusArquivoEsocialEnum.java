package br.gov.ce.seplag.esocial.extrator.enumeration;

public enum StatusArquivoEsocialEnum {

	AGUARDANDO_PROCESSAMENTO("aguardando processamento"),
	ENVIADO_PARA_PROCESSAMENTO("enviado para processamento"),
	PROCESSADO_COM_SUCESSO("processado com sucesso"),
	PROCESSADO_COM_ERRO("processado com erro");
	
	private String descricao;
	

	StatusArquivoEsocialEnum(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return descricao;
    }
    
}
