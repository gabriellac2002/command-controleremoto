package padroescomportamentais.command;

public class Portao {

    private boolean aberto;

    public void abrir() {
        aberto = true;
    }

    public void fechar() {
        aberto = false;
    }

    public boolean isAberto() {
        return aberto;
    }
}
