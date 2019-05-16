package br.gov.ce.seplag.esocial.mensageiro.enumeration;

public enum TipoEventoEnum {

	S1000("s1000","evtInfoEmpregador.xsd","evtInfoEmpregador"),
	S1005("s1005","evtTabEstab.xsd","evtTabEstab"),
	S1010("s1010","evtTabRubrica.xsd","evtTabRubrica"),
	S1030("s1030","evtTabCargo.xsd","evtTabCargo"),
	S1035("s1035","evtTabCarreira.xsd","evtTabCarreira"),
	S1040("s1040","evtTabFuncao.xsd","evtTabFuncao"),
	S1050("s1050","evtTabHorTur.xsd","evtTabHorTur"),
	S1060("s1060","evtTabAmbiente.xsd","evtTabAmbiente"),
	S1070("s1070","evtTabProcesso.xsd","evtTabProcesso"),
	S2200("s2200","evtAdmissao.xsd","evtAdmissao");
	
	private String evento, xsd, rootElement;
	

	TipoEventoEnum(String evento, String xsd, String rootElement) {
        this.evento = evento;
        this.xsd = xsd;
        this.rootElement = rootElement;
    }

    public String evento() {
        return evento;
    }
    
    public String xsd() {
        return xsd;
    }
    
    public String rootElement() {
        return rootElement;
    }
}
