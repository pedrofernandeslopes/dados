fun isPalindrome(data: String): Boolean {
    var retorno = true
    val p = PilhaDinamica(100) // Supondo que PilhaDinamica é uma classe que você tem definida

    for (i in 0 until (data.length / 2)) {
        p.empilhar(data[i])
    }

    for (i in (data.length / 2) + 1 until data.length) {
        val parte1 = p.desempilhar() as Char
        val parte2 = data[i]
        if (parte1 != parte2) {
            retorno = false
            break
        }
    }
    return retorno
}


fun is isPalindrome(data: String): Boolean {
    var retorno = true
    val p = PilhaDinamica(100)

    for (i in 0 until (data.length / 2)) {
        p.empilhar(data[i])
    }

    for (i in (data.length / 2) + 1 until data.length) {
        val parte1 = p.desempilhar() as Char
        val parte2 = data[i]
        if (parte 1 != parte2) {
            retorno = false
            break
        }
    }
    return retorno
 }