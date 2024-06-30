package App;

import java.util.Scanner;

import App.Menus.Menu;
import App.Menus.Menu404;
import App.Menus.MenuBusca;
import App.Menus.MenuCadastro;
import models.midia.Midiateca;

public class ACMEMidia {
    private Midiateca m;
    public ACMEMidia() {
        this.m = new Midiateca();
    }

    public void executar() {
        this.menuPrincipal();
    }
    
    public void menuPrincipal() {
        Menu m = new Menu();
        while (true) {
            @SuppressWarnings("resource")
            Scanner tecladoPrincipal = new Scanner(System.in);
            m.cls();
            m.showLogo();
            m.showOptions();
            System.out.println();
            System.out.print("escolha: ");
            int escolha = tecladoPrincipal.nextInt();
            if (escolha == 0) {
                System.out.println("saindo...");
                break;
            }
            trataEscolha(escolha);

        }

    }

    private void trataEscolha(int e) {
        switch (e) {
            case 1:
                MenuCadastro mcv = new MenuCadastro(this.m);
                mcv.cadastrarVideo();
                break;
            
            case 2:
                MenuCadastro mcm = new MenuCadastro(this.m);
                mcm.cadastrarMusica();
                break;
            case 3:
                MenuBusca mb = new MenuBusca(this.m);
                mb.buscaMidiaCodigo();
                break;
            case 8:
                MenuBusca buscaTodas = new MenuBusca(this.m);
                buscaTodas.mostraMidias();
        
            default:
                Menu404 m404 = new Menu404();
                m404.show404();
                break;
        }
    }
}



