fun selecionarInicio(): Any? {
    var dadoTemporario: Any? = null
    if (!estaVazia()) {
        dadoTemporario = ponteiroInicio?.dado
    } else {
        System.err.println("Lista Vazia!")
    }
    return dadoTemporario
}
