fun ultimaOcorrencia(dado: Any): Int {
    var ocorrencia = quantidade
    if (!estaVazia()) {
        var temp = ponteiroFim
        var i = quantidade - 1
        while (temp != null) {
            if (temp.dado == dado) {
                ocorrencia = i
                break
            }
            i--
            temp = temp.anterior
        }
    } else {
        System.err.println("Lista Vazia!")
    }
    return ocorrencia
}
