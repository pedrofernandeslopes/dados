fun apagar(posicao: Int): Any? {
    var dadoTemporario: Any? = null
    if (!estaVazia()) {
        if (posicao >= 0 && posicao < quantidade) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until posicao) {
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }

            dadoTemporario = ponteiroAuxiliar?.dado

            val ponteiroAnterior = ponteiroAuxiliar?.anterior
            val ponteiroProximo = ponteiroAuxiliar?.proximo

            if (ponteiroAnterior != null) {
                ponteiroAnterior.proximo = ponteiroProximo
            } else {
                ponteiroInicio = ponteiroProximo
            }

            if (ponteiroProximo != null) {
                ponteiroProximo.anterior = ponteiroAnterior
            } else {
                ponteiroFim = ponteiroAnterior
            }

            quantidade--
        } else {
            System.err.println("Indice Invalido!")
        }
    } else {
        System.err.println("Lista Vazia!")
    }
    return dadoTemporario
}
