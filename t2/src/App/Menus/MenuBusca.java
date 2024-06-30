package App.Menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import models.midia.Midia;
import models.midia.Midiateca;

public class MenuBusca extends Menu {
//  Mostrar os dados de uma determinada mídia: lê o código de uma mídia. Se não
//  existir uma mídia com o código indicado, mostra a mensagem de erro: 3:Codigo
//  inexistente. 

    private Midiateca midiateca;
    public MenuBusca(Midiateca m ) {
        this.midiateca = m;
    }

    public void mostraMidias() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Mostra todas midias...");

                System.out.println();

                ArrayList<Midia> todasMidias = this.midiateca.getMidias();
                for (Midia midia : todasMidias) {
                    System.out.println(midia.toString());
                }

                System.out.println();
    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscaMidiaCodigo() {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Busca por codigo...");

                System.out.println();
        
                System.out.print("- Digite o codigo: ");
                int codigo = Integer.parseInt(tecladoCadastro.nextLine());
                Midia buscada = this.midiateca.consultaMidiaCodigo(codigo);
                if (buscada == null) {
                    System.out.println("3. Codigo inexistente");
                } else {
                    System.out.println(buscada.toString());
                }
        
    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
