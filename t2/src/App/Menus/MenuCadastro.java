package App.Menus;

import java.io.IOException;
import java.util.Scanner;

import data.DataUpdater;
import models.Categoria;
import models.midia.Midiateca;
import models.midia.Musica;
import models.midia.Video;

public class MenuCadastro extends Menu {
    private DataUpdater du;

    public MenuCadastro(DataUpdater du) {
        this.du = du;
    }


    public void cadastrarMusica() {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Cadastrando Musica...");
        
                System.out.print("- Titulo: ");
                String titulo = tecladoCadastro.nextLine();
        
                System.out.print("- Ano: ");
                int ano = Integer.parseInt(tecladoCadastro.nextLine());
        
                System.out.println("[1] Acao | [2] Drama | [3] Ficcao | [4] Romance");
                System.out.print("- Categoria: ");
                int catInt = Integer.parseInt(tecladoCadastro.nextLine());
                Categoria cat;
                switch (catInt) {
                    case 1:
                        cat = Categoria.ACA;
                        break;
                    case 2:
                        cat = Categoria.DRA;
                        break;
                    case 3:
                        cat = Categoria.FIC;
                        break;
                    case 4:
                        cat = Categoria.ROM;
                        break;
                    default:
                        cat = Categoria.ACA;
                        break;
                }
                System.out.print("- Duracao (s): ");
                double duracao = Double.parseDouble(tecladoCadastro.nextLine());
        
        
                Musica musicaGerada = new Musica(titulo, ano, cat, duracao);
                System.out.println(musicaGerada.toString());
                du.gravaOut("[Criar musica]: " + musicaGerada.toString());
                du.cadastraMusica(musicaGerada);
    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cadastrarVideo() {
        try {
            while (true) {

                showLogo();
                @SuppressWarnings("resource")
                Scanner tecladoCadastro = new Scanner(System.in);
                System.out.println();
                System.out.println("Cadastrando Video...");
        
                System.out.print("- Titulo: ");
                String titulo = tecladoCadastro.nextLine();
        
                System.out.print("- Ano: ");
                int ano = Integer.parseInt(tecladoCadastro.nextLine());
        
                System.out.println("[1] Acao | [2] Drama | [3] Ficcao | [4] Romance");
                System.out.print("- Categoria: ");
                int catInt = Integer.parseInt(tecladoCadastro.nextLine());
                Categoria cat;
                switch (catInt) {
                    case 1:
                        cat = Categoria.ACA;
                        break;
                    case 2:
                        cat = Categoria.DRA;
                        break;
                    case 3:
                        cat = Categoria.FIC;
                        break;
                    case 4:
                        cat = Categoria.ROM;
                        break;
                    default:
                        cat = Categoria.ACA;
                        break;
                }
                System.out.print("- Qualidade (ex.: 1080): ");
                int qualidade = Integer.parseInt(tecladoCadastro.nextLine());
        
        
                Video videoGerado = new Video(titulo, ano, cat, qualidade);
                System.out.println(videoGerado.toString());
                du.gravaOut("[Criar video]: " + videoGerado.toString());
                du.cadastraVideo(videoGerado);
    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
