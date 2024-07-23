fun apagarFim(): Any? {
    var dadoTemporario: Any? = null
    if (!estaVazia()) {
        dadoTemporario = ponteiroFim?.dado
        ponteiroFim = ponteiroFim?.anterior
        if (ponteiroFim != null) {
            ponteiroFim?.proximo = null
        } else {
            ponteiroInicio = null
        }
        quantidade--
    } else {
        System.err.println("Lista Vazia!")
    }
    return dadoTemporario
}
