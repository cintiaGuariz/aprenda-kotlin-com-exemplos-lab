enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }


class Usuario(val nomeAluno: String, val emailAluno: String, val nivelConhecimento:Nivel)


data class ConteudoEducacional(val nome: String, val duracaoHoras: Int)


data class Formacao(val nome: String, var conteudo: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        
        inscritos.add(usuario)
      
    }
}


fun main() {
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    
    val usuario1 = Usuario("José", "jose@email.com", Nivel.INTERMEDIARIO)
    val usuario2 = Usuario("Alice", "alice@email.com", Nivel.AVANCADO)
    val usuario3 = Usuario("Paulo", "paulo@email.com", Nivel.BASICO)
    
    //println(usuario1.nomeAluno)
    
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
    
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 15)
    val conteudo2 = ConteudoEducacional("Banco de Dados", 20)
    val conteudo3 = ConteudoEducacional("Orientação à Objetos", 30)
    
    val formacaoInicial = Formacao("Primeiro semestre", listOf(conteudo1, conteudo3))
    
    formacaoInicial.matricular(usuario1)
    formacaoInicial.matricular(usuario3)
    
    println("Usuários inscritos no ${formacaoInicial.nome}: ${formacaoInicial.inscritos.map{it.nomeAluno}}")
    
    
    val formacaoFinal = Formacao("Último semestre", listOf(conteudo3))
    
    formacaoFinal.matricular(usuario2)
    
    println("Usuários inscritos no ${formacaoFinal.nome}: ${formacaoFinal.inscritos.map{it.nomeAluno}}")
