fun primeiraOcorrencia(dado: Any): Int {
    var ocorrencia = -1
    if (!estaVazia()) {
        var temp = ponteiroFim
        var i = 0
        while (temp != null) {
            if (temp.dado == dado) {
                ocorrencia = i
                break
            }
            i++
            temp = temp.proximo
        }
    } else {
        System.err.println("Lista Vazia!")
    }
    return ocorrencia
}
