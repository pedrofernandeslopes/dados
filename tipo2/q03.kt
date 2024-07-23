fun decToBin(data: String): String {
    val p = PilhaDinamica(100)
    var dividendo = data.toInt()
    while (dividendo > 1) {
        val resto = dividendo % 2
        val quociente = dividendo / 2
        dividendo = quociente
        p.empilha(resto)
    }
    p.empilha(dividendo)
    return p.imprimir()
}
