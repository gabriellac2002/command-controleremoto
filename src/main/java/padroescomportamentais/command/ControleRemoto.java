package padroescomportamentais.command;

import java.util.ArrayDeque;
import java.util.Deque;

public class ControleRemoto {

    private final Deque<Comando> historico = new ArrayDeque<>();

    public void pressionar(Comando comando) {
        comando.executar();
        historico.push(comando);
    }

    public void desfazer() {
        if (!historico.isEmpty()) {
            historico.pop().desfazer();
        }
    }

    public int getTamanhoHistorico() {
        return historico.size();
    }
}
