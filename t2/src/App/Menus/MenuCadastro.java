package App.Menus;

import java.io.IOException;
import java.util.Scanner;

import models.Categoria;
import models.midia.Musica;
import models.midia.Video;

public class MenuCadastro extends Menu {
    public void cadastrarMusica() {
        try {
            while (true) {

                showLogo();
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
    
                System.out.println("Digite qualquer tecla para sair...");
                System.in.read();
    
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
