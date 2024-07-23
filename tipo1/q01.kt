fun sort() {
    if (quantidade > 1) {
        for (i in 0 until (quantidade - 1)) {
            var atual = ponteiroInicio
            var proximo = atual?.proximo
            for (j in 0 until (quantidade - 1 - i)) {
                if (atual?.dado ?: 0 > proximo?.dado ?: 0) {
                    val aux = atual?.dado
                    atual?.dado = proximo?.dado
                    proximo?.dado = aux
                }
                atual = atual?.proximo
                proximo = atual?.proximo
            }
        }
    }
}


