fun ordenarCrescente() {
    if (!estaVazia()) {
        for (i in 0 until quantidade - 1) {
            var atual = ponteiroInicio
            var proximo = atual?.proximo
            for (j in 0 until quantidade - 1) {
                if ((atual?.dado as? Int ?: 0) > (proximo?.dado as? Int ?: 0)) {
                    val aux = atual?.dado
                    atual?.dado = proximo?.dado
                    proximo?.dado = aux
                }
                atual = atual?.proximo
                proximo = atual?.proximo
            }
        }
    } else {
        System.err.println("Lista Vazia!")
    }
}
