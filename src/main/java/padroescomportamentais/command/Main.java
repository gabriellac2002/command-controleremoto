package padroescomportamentais.command;

public class Main {

    public static void main(String[] args) {
        Lampada lampada = new Lampada();
        Portao portao = new Portao();
        ControleRemoto controle = new ControleRemoto();

        controle.pressionar(new ComandoLigarLampada(lampada));
        controle.pressionar(new ComandoAbrirPortao(portao));
        System.out.println("Lampada ligada: " + lampada.isLigada() + " | Portao aberto: " + portao.isAberto());

        controle.desfazer();
        controle.desfazer();
        System.out.println("Lampada ligada: " + lampada.isLigada() + " | Portao aberto: " + portao.isAberto());
    }
}
