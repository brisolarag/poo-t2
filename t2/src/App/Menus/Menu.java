package App.Menus;


public class Menu {
    public void cls() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    public void showLogo() {
        cls();
        System.out.println(" $$$$$$\\   $$$$$$\\  $$\\      $$\\ $$$$$$$$\\       $$\\      $$\\ $$\\       $$\\ $$\\           \r\n" + //
                        "$$  __$$\\ $$  __$$\\ $$$\\    $$$ |$$  _____|      $$$\\    $$$ |\\__|      $$ |\\__|          \r\n" + //
                        "$$ /  $$ |$$ /  \\__|$$$$\\  $$$$ |$$ |            $$$$\\  $$$$ |$$\\  $$$$$$$ |$$\\  $$$$$$\\  \r\n" + //
                        "$$$$$$$$ |$$ |      $$\\$$\\$$ $$ |$$$$$\\          $$\\$$\\$$ $$ |$$ |$$  __$$ |$$ | \\____$$\\ \r\n" + //
                        "$$  __$$ |$$ |      $$ \\$$$  $$ |$$  __|         $$ \\$$$  $$ |$$ |$$ /  $$ |$$ | $$$$$$$ |\r\n" + //
                        "$$ |  $$ |$$ |  $$\\ $$ |\\$  /$$ |$$ |            $$ |\\$  /$$ |$$ |$$ |  $$ |$$ |$$  __$$ |\r\n" + //
                        "$$ |  $$ |\\$$$$$$  |$$ | \\_/ $$ |$$$$$$$$\\       $$ | \\_/ $$ |$$ |\\$$$$$$$ |$$ |\\$$$$$$$ |\r\n" + //
                        "\\__|  \\__| \\______/ \\__|     \\__|\\________|      \\__|     \\__|\\__| \\_______|\\__| \\_______|\r\n" + //
                        "                                                                                          \r\n" + //
                        "                                                                                          \r\n" + //
                        "                                                                                          ");
    } 
    public void showOptions() {
        System.out.println("[1] Cadastrar Videos");
        System.out.println("[2] Cadastrar Musicas");
        System.out.println("[3] Mostrar dados de uma determinada midia");
        System.out.println("[4] Mostrar os dados de midia(s) de uma determinada categoria");
        System.out.println("[5] Mostrar os dados de video(s) de uma determinada qualidade");
        System.out.println("[6] Mostrar os dados da musica de maior duracao");
        System.out.println("[7] Remover midia");
        System.out.println("[8] Mostrar o somatorio de locacoes de todas as midias");
        System.out.println("[9] Mostra todas midias");
        System.out.println("------------------------");
        System.out.println("Extras:");
        System.out.println("[10] Mostrar os dados da musica com valor de locacao mais proximo da media dos valores de locacao");
        System.out.println("[11] Mostrar os dados da midia mais nova");
        System.out.println();
        System.out.println("[0] Sair do programa");
    }




}

