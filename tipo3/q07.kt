fun atualizarInicio(dado: Any) {
    if (!estaVazia()) {
        ponteiroInicio?.dado = dado
    } else {
        System.err.println("Lista Vazia!")
    }
}
