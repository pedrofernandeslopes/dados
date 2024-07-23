fun insertBegin(data: Any) {
    if (!estaCheia()) {
        val novoNodo = Nodo()
        novoNodo.dado = data
        novoNodo.proximo = ponteiroInicio
        if (!estaVazia()) {
            ponteiroInicio?.anterior = novoNodo
        } else { // para 0 elementos
            ponteiroFim = novoNodo
        }
        ponteiroInicio = novoNodo
        quantidade++
    } else { // para (tamanho-1) elementos
        System.err.println("List is full!")
    }
}

