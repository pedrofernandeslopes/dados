fun inserir(posicao: Int, dado: Any) {
    if (!estaCheia()) {
        if (posicao >= 0 && posicao <= quantidade) {
            val noTemporario = NoDuplo()
            noTemporario.dado = dado

            var ponteiroAnterior: NoDuplo? = null
            var ponteiroProximo = ponteiroInicio

            for (i in 0 until posicao) {
                ponteiroAnterior = ponteiroProximo
                ponteiroProximo = ponteiroProximo?.proximo
            }

            if (ponteiroAnterior != null) {
                ponteiroAnterior.proximo = noTemporario
            } else {
                ponteiroInicio = noTemporario
            }

            if (ponteiroProximo != null) {
                ponteiroProximo.anterior = noTemporario
            } else {
                ponteiroFim = noTemporario
            }

            noTemporario.anterior = ponteiroAnterior
            noTemporario.proximo = ponteiroProximo

            quantidade++
        } else {
            System.err.println("Indice Invalido!")
        }
    } else {
        System.err.println("Lista Cheia!")
    }
}
