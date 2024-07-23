fun selecionar(posicao: Int): Any? {
    var dadoTemporario: Any? = null
    if (!estaVazia()) {
        if (posicao >= 0 && posicao < quantidade) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until posicao) {
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }
            dadoTemporario = ponteiroAuxiliar?.dado
        } else {
            System.err.println("Indice Invalido!")
        }
    } else {
        System.err.println("Lista Vazia!")
    }
    return dadoTemporario
}
