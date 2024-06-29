package App;

import java.util.Scanner;

import App.Menus.Menu;
import App.Menus.Menu404;
import App.Menus.MenuCadastro;

public class ACMEMidia {

    public void executar() {
        this.menuPrincipal();
    }
    
    public void menuPrincipal() {
        Menu m = new Menu();
        while (true) {
            Scanner tecladoPrincipal = new Scanner(System.in);
            m.cls();
            m.showLogo();
            m.showOptions();
            System.out.println();
            System.out.print("escolha: ");
            int escolha = tecladoPrincipal.nextInt();
            if (escolha == 0) break;
            trataEscolha(escolha);

        }

    }

    private void trataEscolha(int e) {
        switch (e) {
            case 1:
                MenuCadastro mc = new MenuCadastro();
                mc.cadastrarMusica();
                break;
        
            default:
                Menu404 m404 = new Menu404();
                m404.show404();
                break;
        }
    }

}

