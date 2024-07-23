fun inserirInicio(dado: Any) {
    if (!estaCheia()) {
        val noTemporario = NoDuplo()
        noTemporario.dado = dado
        if (!estaVazia()) {
            ponteiroInicio?.anterior = noTemporario
        } else {
            ponteiroFim = noTemporario
        }
        noTemporario.proximo = ponteiroInicio
        ponteiroInicio = noTemporario
        quantidade++
    } else {
        System.err.println("Lista Cheia!")
    }
}
