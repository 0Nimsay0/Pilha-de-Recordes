
package pilhajava;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PilhaJava {
    static Scanner scanner = new Scanner(System.in);
    
    private static int menu() 
    {
        System.out.println("\n--- Menu Pilha ---");
        System.out.println("1. Inserir elemento");
        System.out.println("2. Remover elemento");
        System.out.println("3. Mostrar topo");
        System.out.println("4. Mostrar pilha");
        System.out.println("0. Sair");
        System.out.printf("Digite a opção desejada: " );
    	return scanner.nextInt();
    }
    
    public static void lerRecorde(Recorde recorde) {
          System.out.print("Digite o nome do atleta: ");
          recorde.setNome(scanner.next());
 
          System.out.print("Digite a data do recorde (dd/MM/yyyy): ");
          String dataStr = scanner.next();
          LocalDate dataFormatada = LocalDate.parse(dataStr,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          recorde.setData(dataFormatada);
          
          System.out.print("Digite o tempo do recorde (em segundos): ");
          recorde.setTempo(scanner.nextDouble());
}


    public static void main(String[] args)
    {
        
        System.out.print("Tamanho da Pilha: ");
        int tamanho = scanner.nextInt();
        
        Pilha<Recorde> minhaPilha = new Pilha(tamanho);
        
        int opcao;
        do{
            opcao = menu();
            
            switch(opcao)
            {
                case 1:
                    Recorde novoRecorde = new Recorde();
                    lerRecorde(novoRecorde);
                    if(minhaPilha.isFull()){
                        minhaPilha.resize();
                    }
                    if(novoRecorde.getTempo() < minhaPilha.peek().getTempo() || !minhaPilha.isEmpty()){
                            minhaPilha.push(novoRecorde);
                    }
                    break;
                
                case 2:
                    if(!minhaPilha.isEmpty())
                    {
                        System.out.println("Topo removido: " + minhaPilha.pop());
                    }else{
                        System.out.println("Pilha Vazia!");
                    }
                    break;
                
                case 3:
                    if(!minhaPilha.isEmpty())
                    {
                        System.out.print("Topo: " + minhaPilha.peek());
                    }else{
                        System.out.println("Pilha Vazia!");
                    }
                    break;
                    
                case 4:
                    System.out.println(minhaPilha);
                    break;
                
                case 0:
                    System.out.println("Saindo...");
                    break;
            }
            scanner.nextLine();
        }while(opcao!= 0);

    }
    
}
