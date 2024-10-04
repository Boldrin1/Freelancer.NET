package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Competencias {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String tecnicas;   
   private String emocionais; 


   public Competencias(String tecnicas, String emocionais) {
       this.tecnicas = tecnicas;
       this.emocionais = emocionais;
   }


   public Competencias() {
   }

   // Getters e Setters
   public Long getId() {  
       return id;
   }

   public String getTecnicas() {
       return tecnicas;
   }

   public void setTecnicas(String tecnicas) {
       this.tecnicas = tecnicas;
   }

   public String getEmocionais() {
       return emocionais;
   }

   public void setEmocionais(String emocionais) {
       this.emocionais = emocionais;
   }
}
