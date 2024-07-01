package App.Menus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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

    public void buscaMidiaCategoria() {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Busca por categoria...");

                System.out.println();
        
                System.out.println("[1] Acao      [2] Drama");
                System.out.println("[3] Ficcao    [4] Romance");
                System.out.print("Selecione uma opcao: ");
                int opcao = Integer.parseInt(tecladoCadastro.nextLine());
                Categoria categoria = Categoria.ACA;
                if (opcao == 1)
                    categoria = Categoria.ACA;
                if (opcao == 2)
                    categoria = Categoria.DRA;
                if (opcao == 3)
                    categoria = Categoria.FIC;
                if (opcao == 4)
                    categoria = Categoria.ROM;
                ArrayList<Midia> destaCategoria = midiateca.consultaMidiaCategoria(categoria);
                System.out.println();
                System.out.println("Resultado:");
                for (Midia midia : destaCategoria) {
                    System.out.println("- " + midia.toString());
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


    public void buscaVideoQualidade () {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Busca por video por qualidade...");

                System.out.println();

                System.out.print("Digite uma qualidade (ex.: 1080): ");
                int qualidade = Integer.parseInt(tecladoCadastro.nextLine());
                ArrayList<Video> videos = midiateca.consultaMidiaQualidade(qualidade);
                for (Video video : videos) {
                    System.out.println("- " + video.toString());
                }

    
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

                System.out.println();

                System.out.println("Resultado:");
                Musica maiorD = midiateca.consultaMusicaMaiorDuracao();
                if (maiorD == null) {
                    System.out.println("6: Nenhuma musica encontrada.");
                } else {
                    System.out.println(maiorD.toString());
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

    public void somatorio() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Somatorio de locacoes...");

                System.out.println();

                System.out.println("Resultado:");

                try {
                    double somatorio = this.midiateca.todasLocacoes();
                    System.out.println("8: R$" + somatorio);
                } catch (NullPointerException e) {
                    System.out.println("8: Nenhuma midia encontrada.");
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

    public void maisProximoMedia() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Mais proximo da media de locacoes...");

                System.out.println();

                System.out.println("Resultado:");

                try {
                    Midia maisProximo = this.midiateca.maisProximoMedia();
                    System.out.println("10: " + maisProximo);
                } catch (NullPointerException e) {
                    System.out.println("10: Nenhuma midia encontrada.");
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
    public void maisRecente() {
        try {
            while (true) {

                showLogo();
                System.out.println();
                System.out.println("Mais recente adicionado...");

                System.out.println();

                System.out.println("Resultado:");

                Midia maisRecente = this.midiateca.maisRecente();
                if (maisRecente == null)
                    System.out.println("11: Nenhuma midia encontrada.");
                else
                    System.out.println("11: " + maisRecente);


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
