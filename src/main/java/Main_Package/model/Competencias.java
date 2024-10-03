package Main_Package.model;

public class Competencias {
   public String Tecnicas;
   public String Emocionais;
   
   
public Competencias(String tecnicas, String emocionais) {
	super();
	Tecnicas = tecnicas;
	Emocionais = emocionais;
}


public String getTecnicas() {
	return Tecnicas;
}
public void setTecnicas(String tecnicas) {
	Tecnicas = tecnicas;
}
public String getEmocionais() {
	return Emocionais;
}
public void setEmocionais(String emocionais) {
	Emocionais = emocionais;
}
   
   
}
