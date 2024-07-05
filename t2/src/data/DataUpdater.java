package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.Categoria;
import models.midia.Midiateca;
import models.midia.Musica;
import models.midia.Video;

public class DataUpdater implements IFile {
    private String pathIn;
    private String pathOut;
    private Midiateca midiateca;
    
    public DataUpdater(String pathIn, String pathOut, Midiateca midiateca) {
        this.pathIn = pathIn;
        this.pathOut = pathOut;
        this.midiateca = midiateca;
    }

    public boolean cadastraIn() {
        boolean sucess = false;
        try (BufferedReader br = new BufferedReader(new FileReader(this.pathIn))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");


                String tipo = partes[0];
                String titulo = partes[1];

                int ano = Integer.parseInt(partes[2]);
                Categoria categoria = null;
                if (partes[3].equals("Acao"))
                    categoria = Categoria.ACA;
                else if (partes[3].equals("Drama"))
                    categoria = Categoria.DRA;
                else if (partes[3].equals("Ficcao"))
                    categoria = Categoria.FIC;
                else if (partes[3].equals("Romance"))
                    categoria = Categoria.ROM;

                


                if (tipo.equals("video")) {
                    int qualidade = Integer.parseInt(partes[4]);

                    Video novoVideo = new Video(titulo, ano, categoria, qualidade);
                    this.midiateca.cadastraMidia(novoVideo);
                    sucess = true;
                } else if (tipo.equals("musica")) {
                    double duracao = Double.parseDouble(partes[4]);
                    Musica novaMusica = new Musica (titulo, ano, categoria, duracao);
                    this.midiateca.cadastraMidia(novaMusica);
                    sucess = true;
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sucess;
    }


    public boolean cadastraMusica(Musica novaMusica) {
        boolean sucesso = false;
    
    
        this.midiateca.cadastraMidia(novaMusica);
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.pathIn, true))) {
            String linha = String.format("musica,%s,%d,%s,%.2f", novaMusica.getTitulo(), novaMusica.getAno(), novaMusica.getCategoriaString(), novaMusica.getDuracao());
            bw.newLine();
            bw.write(linha);
            sucesso = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return sucesso;
    }

    public boolean cadastraVideo(Video novoVideo) {
        boolean sucesso = false;
    
    
        this.midiateca.cadastraMidia(novoVideo);
    
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.pathIn, true))) {
            String linha = String.format("musica,%s,%d,%s,%d", novoVideo.getTitulo(), novoVideo.getAno(), novoVideo.getCategoriaString(), novoVideo.getQualidade());
            bw.newLine();
            bw.write(linha);
            sucesso = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return sucesso;
    }

    public boolean gravaOut(String escrita) {
        boolean sucesso = false;

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(this.pathOut, true))) {
            String linha = printLog(escrita);
            bw.newLine();
            bw.write(linha);
            sucesso = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sucesso;
    }



    private String getNowString() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM | HH:mm:ss");
        String dataHoraFormatada = agora.format(formatter);
        return dataHoraFormatada;
    }

    private String printLog(String log) {
        StringBuilder b = new StringBuilder(getNowString());
        b.append(" ==> ");
        b.append(log);
        return b.toString();
    }

    

}
