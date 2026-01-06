// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String, val idade: Int, val sexo: String, val id: Int = gerarIdUnico() ){
    companion object{
        private var contador = 0
        
        fun gerarIdUnico(): Int {
            contador++
            return contador
        }
    }
}

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, val nivel : Nivel, val conteudos: List<ConteudoEducacional>, 
                    var matriculadosNum: Int = 0) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        try {
        inscritos.add(usuario)
        matriculadosNum++
        
        println("Usuario ${usuario.nome} matriculado com sucesso")
    
        } catch(e: Exception) {
            println(" Error ${e.message}")
        }
    }
}

fun main() {
    val conteudosAndroid = listOf(
    ConteudoEducacional("Introdução ao Kotlin e Sintaxe Básica", 60),
    ConteudoEducacional("Orientação a Objetos no Kotlin", 120),
    ConteudoEducacional("Dominando o Android Studio e Gradle", 90),
    ConteudoEducacional("Ciclo de Vida de Activities e Fragments", 100))
    
	val formacaoAndroid = Formacao("Android Master", nivel = Nivel.INTERMEDIARIO, conteudos = conteudosAndroid)
    val alunoCarlos = Usuario("Carlos", 19, "Mas")
    val alunaRebeca = Usuario("Rebeca", 20, "Fem")
    
    formacaoAndroid.matricular(alunoCarlos)
    formacaoAndroid.matricular(alunaRebeca)
    
    println( "\n \n")
    
    println("Na DIO temos a formação ${formacaoAndroid.nome} ")
    println( "ela é do nivel ${formacaoAndroid.nivel}, ")
    println( "alem disso essa formação conta com os seguintes conteudos:\n")
    println(formacaoAndroid.conteudos.joinToString(separator = "\n") { conteudo -> " - ${conteudo.nome} (${conteudo.duracao} min)"})
    
    println( "\n")
    
    println( "A formação ja possui ${formacaoAndroid.matriculadosNum} aluno(os) e eles são: ")
    println("${alunoCarlos.nome} do id ${alunoCarlos.id} e ${alunaRebeca.nome} do id ${alunaRebeca.id}")
    
}


