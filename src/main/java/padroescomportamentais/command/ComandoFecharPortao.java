package padroescomportamentais.command;

public class ComandoFecharPortao implements Comando {

    private final Portao portao;

    public ComandoFecharPortao(Portao portao) {
        this.portao = portao;
    }

    @Override
    public void executar() {
        portao.fechar();
    }

    @Override
    public void desfazer() {
        portao.abrir();
    }
}
