fun selecionarFim(): Any? {
    var dadoTemporario: Any? = null
    if (!estaVazia()) {
        dadoTemporario = ponteiroFim?.dado
    } else {
        System.err.println("Lista Vazia!")
    }
    return dadoTemporario
}
