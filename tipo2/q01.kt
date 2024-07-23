fun removeEnd(): Any? {
    var temp: Any? = null
    if (!estaVazia()) {
        temp = ponteiroFim?.dado
        if (quantidade > 1) {
            ponteiroFim = ponteiroFim?.anterior
            ponteiroFim?.proximo = null
        } else { // para 1 único elemento
            ponteiroFim = null
            ponteiroInicio = null
        }
        quantidade--
    } else { // para 0 elementos
        System.err.println("Queue is empty!")
    }
    return temp
}
