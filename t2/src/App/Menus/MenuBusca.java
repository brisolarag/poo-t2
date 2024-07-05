package App.Menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.DataUpdater;
import models.Categoria;
import models.midia.Midia;
import models.midia.Midiateca;
import models.midia.Musica;
import models.midia.Video;

public class MenuBusca extends Menu {
//  Mostrar os dados de uma determinada mídia: lê o código de uma mídia. Se não
//  existir uma mídia com o código indicado, mostra a mensagem de erro: 3:Codigo
//  inexistente. 

    private Midiateca midiateca;
    private DataUpdater du;
    public MenuBusca(Midiateca m, DataUpdater du) {
        this.midiateca = m;
        this.du = du;
    }

    public void mostraMidias() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Mostra todas midias...");

                System.out.println();
                StringBuilder b = new StringBuilder();
                b.append("[Mostrar midias]: ");

                ArrayList<Midia> todasMidias = this.midiateca.getMidias();
                for (Midia midia : todasMidias) {
                    System.out.println(midia.toString());
                    b.append(midia.getCodigo());
                    b.append(" ");
                }
                du.gravaOut(b.toString());

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
                StringBuilder b = new StringBuilder();
                
                System.out.println();
                
                System.out.print("- Digite o codigo: ");
                int codigo = Integer.parseInt(tecladoCadastro.nextLine());

                b.append("[Busca midia codigo(" + codigo + ")]: ");


                Midia buscada = this.midiateca.consultaMidiaCodigo(codigo);
                if (buscada == null) {
                    System.out.println("3. Codigo inexistente");
                } else {
                    System.out.println(buscada.toString());
                    b.append(buscada.toString());
                    du.gravaOut(b.toString());
                }
        
    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscaMidiaCategoria() {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Busca por categoria...");
                StringBuilder b = new StringBuilder();

                System.out.println();
        
                System.out.println("[1] Acao      [2] Drama");
                System.out.println("[3] Ficcao    [4] Romance");
                System.out.print("Selecione uma opcao: ");
                int opcao = Integer.parseInt(tecladoCadastro.nextLine());
                Categoria categoria = Categoria.ACA;
                if (opcao == 1) {
                    categoria = Categoria.ACA;
                    b.append("[Busca midia categoria(Acao)]: ");
                } 
                if (opcao == 2) {
                    categoria = Categoria.DRA;
                    b.append("[Busca midia categoria(Drama)]: ");
                }
                if (opcao == 3) {
                    categoria = Categoria.FIC;
                    b.append("[Busca midia categoria(Ficcao)]: ");
                }
                if (opcao == 4) {
                    categoria = Categoria.ROM;
                    b.append("[Busca midia categoria(Romance)]: ");
                }


                ArrayList<Midia> destaCategoria = midiateca.consultaMidiaCategoria(categoria);
                System.out.println();
                System.out.println("Resultado:");
                for (Midia midia : destaCategoria) {
                    System.out.println("- " + midia.toString());
                    b.append(midia.getCodigo());
                    b.append(" ");
                }

                du.gravaOut(b.toString());
                System.out.println();

    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void buscaVideoQualidade () {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Busca por video por qualidade...");
                StringBuilder b = new StringBuilder();

                System.out.println();

                System.out.print("Digite uma qualidade (ex.: 1080): ");
                int qualidade = Integer.parseInt(tecladoCadastro.nextLine());
                b.append("[Busca midia qualidade("+ qualidade +")]: ");

                ArrayList<Video> videos = midiateca.consultaMidiaQualidade(qualidade);
                for (Video video : videos) {
                    System.out.println("- " + video.toString());
                    b.append(video.getCodigo());
                    b.append(" ");
                }
                du.gravaOut(b.toString());

    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buscaMaiorDuracao () {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Busca por musica maior duracao...");
                StringBuilder b = new StringBuilder();
                b.append("[Busca midia maior duracao]: ");

                System.out.println();

                System.out.println("Resultado:");
                Musica maiorD = midiateca.consultaMusicaMaiorDuracao();
                if (maiorD == null) {
                    System.out.println("6: Nenhuma musica encontrada.");
                    b.append("6: Nenhuma musica encontrada.");
                } else {
                    System.out.println(maiorD.toString());
                    b.append(maiorD.toString());
                }
                du.gravaOut(b.toString());

                System.out.println();
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void somatorio() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Somatorio de locacoes...");
                StringBuilder b = new StringBuilder();
                b.append("[Somatorio de locacoes]: ");

                System.out.println();

                System.out.println("Resultado:");

                try {
                    double somatorio = this.midiateca.todasLocacoes();
                    System.out.println("8: R$" + somatorio);
                    b.append("8: R$" + somatorio);
                } catch (NullPointerException e) {
                    System.out.println("8: Nenhuma midia encontrada.");
                    b.append("8: Nenhuma midia encontrada.");
                }
                du.gravaOut(b.toString());

                System.out.println();
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void maisProximoMedia() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Mais proximo da media de locacoes...");
                StringBuilder b = new StringBuilder();
                b.append("[Mais proximo media locacoes]: ");

                System.out.println();

                System.out.println("Resultado:");

                try {
                    Midia maisProximo = this.midiateca.maisProximoMedia();
                    System.out.println("10: " + maisProximo);
                    b.append("10: " + maisProximo);
                } catch (NullPointerException e) {
                    System.out.println("10: Nenhuma midia encontrada.");
                    b.append("10: Nenhuma midia encontrada.");
                }
                du.gravaOut(b.toString());

                System.out.println();
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void maisRecente() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Mais recente adicionado...");
                StringBuilder b = new StringBuilder();
                b.append("[Mais recente adicionado]: ");

                System.out.println();

                System.out.println("Resultado:");

                Midia maisRecente = this.midiateca.maisRecente();
                if (maisRecente == null) {
                    System.out.println("11: Nenhuma midia encontrada.");
                    b.append("11: Nenhuma midia encontrada.");
                }
                else {
                    System.out.println("11: " + maisRecente);
                    b.append("11: " + maisRecente);
                }
                du.gravaOut(b.toString());


                System.out.println();
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
