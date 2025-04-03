package pilhajava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Recorde {
    
    private LocalDate data;
    private double tempo;
    private String nome;

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
   @Override
   public String toString(){
       String dataFormatada = data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
       return "Nome: " +this.nome + "Data: " +dataFormatada + "Tempo: "+this.tempo;
   }
    
}
