fun existe(dado: Any): Boolean {
    var existeDado = false
    if (!estaVazia()) {
        var temp = ponteiroInicio
        while (temp != null) {
            if (temp.dado == dado) {
                existeDado = true
                break
            }
            temp = temp.proximo
        }
    } else {
        System.err.println("Lista Vazia!")
    }
    return existeDado
}
