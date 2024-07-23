fun atualizarFim(dado: Any) {
    if (!estaVazia()) {
        ponteiroFim?.dado = dado
    } else {
        System.err.println("Lista Vazia!")
    }
}
