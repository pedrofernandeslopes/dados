fun inserirFim(dado: Any) {
    if (!estaCheia()) {
        val noTemporario = NoDuplo()
        noTemporario.dado = dado
        if (!estaVazia()) {
            ponteiroFim?.proximo = noTemporario
        } else {
            ponteiroInicio = noTemporario
        }
        noTemporario.anterior = ponteiroFim
        ponteiroFim = noTemporario
        quantidade++
    } else {
        System.err.println("Lista Cheia!")
    }
}
