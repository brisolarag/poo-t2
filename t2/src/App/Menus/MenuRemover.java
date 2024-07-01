package App.Menus;

import java.io.IOException;
import java.util.Scanner;

import models.midia.Midia;
import models.midia.Midiateca;

public class MenuRemover extends Menu {
    private Midiateca midiateca;
    public MenuRemover (Midiateca midiateca) {
        this.midiateca = midiateca;
    }

    public void removerPorCodigo() {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Removendo por codigo...");

                System.out.println();
        
                System.out.print("- Digite o codigo: ");
                int codigo = Integer.parseInt(tecladoCadastro.nextLine());
                Midia buscada = this.midiateca.consultaMidiaCodigo(codigo);

                if (buscada == null) {
                    System.out.println("7. Codigo inexistente");
                } else {
                    System.out.println("Removendo: " + buscada.toString());;
                    this.midiateca.remove(buscada);
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

