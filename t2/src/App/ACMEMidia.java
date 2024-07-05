package App;

import java.util.Scanner;

import App.Menus.Menu;
import App.Menus.Menu404;
import App.Menus.MenuBusca;
import App.Menus.MenuCadastro;
import App.Menus.MenuRemover;
import data.DataUpdater;
import models.midia.Midiateca;

public class ACMEMidia {
    private Midiateca m;
    private DataUpdater du;
    public ACMEMidia() {
        this.m = new Midiateca();
        this.du = new DataUpdater("t2/src/data/in.txt", "t2/src/data/out.txt", this.m);
    }

    public void executar() {
        this.du.cadastraIn();
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
                MenuCadastro video = new MenuCadastro(this.du);
                video.cadastrarVideo();
                break;
            
            case 2:
                MenuCadastro musica = new MenuCadastro(this.du);
                musica.cadastrarMusica();
                break;
            case 3:
                MenuBusca codigo = new MenuBusca(this.m, this.du);
                codigo.buscaMidiaCodigo();
                break;
            case 4:
                MenuBusca categoria = new MenuBusca(this.m, this.du);
                categoria.buscaMidiaCategoria();
                break;
            case 5:
                MenuBusca qualidade = new MenuBusca(this.m, this.du);
                qualidade.buscaVideoQualidade();
                break;
            case 6:
                MenuBusca maiorDuracao = new MenuBusca(this.m, this.du);
                maiorDuracao.buscaMaiorDuracao();
                break;
            case 7:
                MenuRemover remover = new MenuRemover(this.m);
                remover.removerPorCodigo();
                break;
            case 8:
                MenuBusca somatorio = new MenuBusca(this.m, this.du);
                somatorio.somatorio();
                break;
    
            case 9:
                MenuBusca todas = new MenuBusca(this.m, this.du);
                todas.mostraMidias();
                break;

            case 10:
                MenuBusca maisProximoMedia = new MenuBusca(this.m, this.du);
                maisProximoMedia.maisProximoMedia();
                break;
            case 11:
                MenuBusca maisRecente = new MenuBusca(this.m, this.du);
                maisRecente.maisRecente();
                break;

        
            default:
                Menu404 m404 = new Menu404();
                m404.show404();
                break;
        }
    }
}



