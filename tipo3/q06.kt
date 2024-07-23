fun selecionarTodos(): Array<Any?> {
    val dadosTemp = arrayOfNulls<Any?>(quantidade)
    if (!estaVazia()) {
        var ponteiroAuxiliar = ponteiroInicio
        for (i in 0 until quantidade) {
            dadosTemp[i] = ponteiroAuxiliar?.dado
            ponteiroAuxiliar = ponteiroAuxiliar?.proximo
        }
    } else {
        System.err.println("Lista Vazia!")
    }
    return dadosTemp
}
