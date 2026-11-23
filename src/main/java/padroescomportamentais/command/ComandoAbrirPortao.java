package padroescomportamentais.command;

public class ComandoAbrirPortao implements Comando {

    private final Portao portao;

    public ComandoAbrirPortao(Portao portao) {
        this.portao = portao;
    }

    @Override
    public void executar() {
        portao.abrir();
    }

    @Override
    public void desfazer() {
        portao.fechar();
    }
}
