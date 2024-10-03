package Main_Package.model;

public class Curriculo {
      public Experiencias experiencias;
      public FormacaoAcademica formacaoAcademica;
      public Competencias competencias;
      public String AreaDeInteresse;
      
      
      public void alterarCurriculo(Experiencias experiencias,FormacaoAcademica formacaoAcademica,Competencias competencias) {
    	 // return curriculoAlterado;
      }


	public Curriculo(Experiencias experiencias, FormacaoAcademica formacaoAcademica, Competencias competencias,
			String areaDeInteresse) {
		super();
		this.experiencias = experiencias;
		this.formacaoAcademica = formacaoAcademica;
		this.competencias = competencias;
		AreaDeInteresse = areaDeInteresse;
	}


	public Experiencias getExperiencias() {
		return experiencias;
	}


	public void setExperiencias(Experiencias experiencias) {
		this.experiencias = experiencias;
	}


	public FormacaoAcademica getFormacaoAcademica() {
		return formacaoAcademica;
	}


	public void setFormacaoAcademica(FormacaoAcademica formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}


	public Competencias getCompetencias() {
		return competencias;
	}


	public void setCompetencias(Competencias competencias) {
		this.competencias = competencias;
	}


	public String getAreaDeInteresse() {
		return AreaDeInteresse;
	}


	public void setAreaDeInteresse(String areaDeInteresse) {
		AreaDeInteresse = areaDeInteresse;
	}
      
      
      
      
}
