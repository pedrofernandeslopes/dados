fun apagarInicio(): Any? {
    var dadoTemporario: Any? = null
    if (!estaVazia()) {
        dadoTemporario = ponteiroInicio?.dado
        ponteiroInicio = ponteiroInicio?.proximo
        if (ponteiroInicio != null) {
            ponteiroInicio?.anterior = null
        } else {
            ponteiroFim = null
        }
        quantidade--
    } else {
        System.err.println("Lista Vazia!")
    }
    return dadoTemporario
}
