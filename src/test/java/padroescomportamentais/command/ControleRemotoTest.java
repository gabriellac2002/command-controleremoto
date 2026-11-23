package padroescomportamentais.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ControleRemotoTest {

    private Lampada lampada;
    private Portao portao;
    private ControleRemoto controle;

    @BeforeEach
    void preparar() {
        lampada = new Lampada();
        portao = new Portao();
        controle = new ControleRemoto();
    }

    @Test
    void deveLigarLampada() {
        controle.pressionar(new ComandoLigarLampada(lampada));
        assertTrue(lampada.isLigada());
    }

    @Test
    void deveDesligarLampada() {
        controle.pressionar(new ComandoLigarLampada(lampada));
        controle.pressionar(new ComandoDesligarLampada(lampada));
        assertFalse(lampada.isLigada());
    }

    @Test
    void deveAbrirEFecharPortao() {
        controle.pressionar(new ComandoAbrirPortao(portao));
        assertTrue(portao.isAberto());
        controle.pressionar(new ComandoFecharPortao(portao));
        assertFalse(portao.isAberto());
    }

    @Test
    void deveDesfazerUltimoComando() {
        controle.pressionar(new ComandoLigarLampada(lampada));
        controle.pressionar(new ComandoAbrirPortao(portao));
        controle.desfazer();
        assertFalse(portao.isAberto());
        assertTrue(lampada.isLigada());
        assertEquals(1, controle.getTamanhoHistorico());
    }

    @Test
    void desfazerSemHistoricoNaoDeveFazerNada() {
        controle.desfazer();
        assertEquals(0, controle.getTamanhoHistorico());
    }
}
