package App;

import java.util.Scanner;

import App.Menus.Menu;
import App.Menus.Menu404;
import App.Menus.MenuBusca;
import App.Menus.MenuCadastro;
import App.Menus.MenuRemover;
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
                MenuCadastro video = new MenuCadastro(this.m);
                video.cadastrarVideo();
                break;
            
            case 2:
                MenuCadastro musica = new MenuCadastro(this.m);
                musica.cadastrarMusica();
                break;
            case 3:
                MenuBusca codigo = new MenuBusca(this.m);
                codigo.buscaMidiaCodigo();
                break;
            case 4:
                MenuBusca categoria = new MenuBusca(this.m);
                categoria.buscaMidiaCategoria();
                break;
            case 5:
                MenuBusca qualidade = new MenuBusca(this.m);
                qualidade.buscaVideoQualidade();
                break;
            case 6:
                MenuBusca maiorDuracao = new MenuBusca(this.m);
                maiorDuracao.buscaMaiorDuracao();
                break;
            case 7:
                MenuRemover remover = new MenuRemover(this.m);
                remover.removerPorCodigo();
                break;
            case 8:
                MenuBusca somatorio = new MenuBusca(this.m);
                somatorio.somatorio();
                break;
    
            case 9:
                MenuBusca todas = new MenuBusca(this.m);
                todas.mostraMidias();
                break;

            case 10:
                MenuBusca maisProximoMedia = new MenuBusca(this.m);
                maisProximoMedia.maisProximoMedia();
                break;
            case 11:
                MenuBusca maisRecente = new MenuBusca(this.m);
                maisRecente.maisRecente();
                break;

        
            default:
                Menu404 m404 = new Menu404();
                m404.show404();
                break;
        }
    }
}



