fun atualizar(posicao: Int, novoDado: Any) {
    if (!estaVazia()) {
        if (posicao >= 0 && posicao < quantidade) {
            var ponteiroAuxiliar = ponteiroInicio
            for (i in 0 until posicao) {
                ponteiroAuxiliar = ponteiroAuxiliar?.proximo
            }
            ponteiroAuxiliar?.dado = novoDado
        } else {
            System.err.println("Indice Invalido!")
        }
    } else {
        System.err.println("Lista Vazia!")
    }
}
