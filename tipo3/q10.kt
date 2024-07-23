fun atualizarTodos(dado: Any) {
    if (!estaVazia()) {
        var ponteiroAuxiliar = ponteiroInicio
        for (i in 0 until quantidade) {
            ponteiroAuxiliar?.dado = dado
            ponteiroAuxiliar = ponteiroAuxiliar?.proximo
        }
    } else {
        System.err.println("Lista Vazia!")
    }
}
