package App.Menus;

import java.io.IOException;

public class Menu404 extends Menu {
    public void show404() {
        try {
            while (true) {
                super.showLogo();
                System.out.println();
                System.out.println("Erro 404");
                System.out.println("Opcao nao encontrada");
                System.out.println();
                System.out.println("Digite qualquer tecla para voltar... ");

                System.in.read();

                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
