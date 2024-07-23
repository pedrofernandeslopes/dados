fun inverter() {
    if (!estaVazia()) {
        var ponteiroAuxInicio = ponteiroInicio
        var ponteiroAuxFim = ponteiroFim
        for (i in 0 until quantidade / 2) {
            val dadoAux = ponteiroAuxInicio?.dado
            ponteiroAuxInicio?.dado = ponteiroAuxFim?.dado
            ponteiroAuxFim?.dado = dadoAux

            ponteiroAuxInicio = ponteiroAuxInicio?.proximo
            ponteiroAuxFim = ponteiroAuxFim?.anterior
        }
    } else {
        System.err.println("Lista Vazia!")
    }
}
