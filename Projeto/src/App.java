
/*
Elyelson Myslle Mesquita de Sousa Soares – 2327162.
João Lucas Oliveira Silva – 2323862.
Julia Kamila Izequiel Gomes – 2317513.
Nicolas Pereira da Silva – 2323866.
Maria Elenilza Dias Gomes – 2319451.
Risoleta Pereira Pinto – 2323869.
 */
import java.util.ArrayList;

// Questão 1: Classes e Objetos
abstract class Pessoa {
    private String cpf;
    private String nome;
    private int idade;

    public Pessoa(String cpf, String nome, int idade) {
        this.cpf = cpf;
        this.nome = nome;
        this.idade = idade;
    }

    public void fazerAniversario() {
        setIdade(getIdade() + 1);
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}

class Disciplina {
    private int codigo;
    private String nome;
    private int semestre;

    public Disciplina(int codigo, String nome, int semestre) {
        this.codigo = codigo;
        this.nome = nome;
        this.semestre = semestre;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }
}

// Questão 3: Herança e Polimorfismo
class Aluno extends Pessoa {
    private String matricula;

    public Aluno(String cpf, String nome, int idade, String matricula) {
        super(cpf, nome, idade);
        this.matricula = matricula;
    }

    public void pagarMensalidade() {
        System.out.println("Mensalidade paga pelo aluno " + getNome());
    }

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
         this.matricula = matricula;
    }
}

class Bolsista extends Aluno {
    public Bolsista(String cpf, String nome, int idade, String matricula) {
        super(cpf, nome, idade, matricula);
    }

    @Override
    public void pagarMensalidade() {
        System.out.println("Bolsista " + getNome() + " está isento de pagar mensalidade.");
    }
}

class Professor extends Pessoa {
    private String centro;

    public Professor(String cpf, String nome, int idade, String centro) {
        super(cpf, nome, idade);
        this.centro = centro;
    }

    public void darAula() {
        System.out.println(getNome() + " está dando aula.");
    }
}

class Visitante extends Pessoa {
    public Visitante(String cpf, String nome, int idade) {
        super(cpf, nome, idade);
    }
}

// Questão 4: Associação e Composição
class Turma {
    public int codigo;
    public Disciplina disciplina;
    public Professor professor;
    public ArrayList<Aluno> alunos;

    public Turma(int codigo, Disciplina disciplina, Professor professor) {
        this.codigo = codigo;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        alunos.remove(aluno);
    }

    public void listarAlunos() {
        for (Aluno aluno : alunos) {
            System.out.println(aluno.getNome());
        }
    }
}

public class App {
    public static void main(String[] args) {
        // Criando objetos de disciplina
        Disciplina disciplina1 = new Disciplina(1, "Matemática", 1);
        Disciplina disciplina2 = new Disciplina(2, "História", 2);
        Disciplina disciplina3 = new Disciplina(3, "Ciências", 3);

        // Criando objetos de aluno
        Aluno aluno1 = new Aluno("123456789", "João", 18, "2021001");
        Aluno aluno2 = new Aluno("987654321", "Maria", 20, "2021002");
        Bolsista bolsista1 = new Bolsista("135792468", "Pedro", 19, "2021003");

        // Criando objeto de professor
        Professor professor = new Professor("987654321", "Carlos", 35, "Departamento de Física");

        // Criando objetos de visitante
        Visitante visitante1 = new Visitante("111111111", "Visitante 1", 30);
        Visitante visitante2 = new Visitante("222222222", "Visitante 2", 25);

        // Criando objetos de turma
        Turma turma1 = new Turma(101, disciplina1, professor);
        turma1.adicionarAluno(aluno1);
        turma1.adicionarAluno(aluno2);
        turma1.adicionarAluno(bolsista1);

        Turma turma2 = new Turma(102, disciplina2, professor);
        turma2.adicionarAluno(aluno1);
        turma2.adicionarAluno(aluno2);
        turma2.adicionarAluno(bolsista1);

        Turma turma3 = new Turma(103, disciplina3, professor);
        turma3.adicionarAluno(aluno1);
        turma3.adicionarAluno(aluno2);
        turma3.adicionarAluno(bolsista1);

        // Imprimindo informações das turmas
        System.out.println("Turma 1:");
        System.out.println("Código: " + turma1.getCodigo());
        System.out.println("Professor: " + turma1.professor.getNome());
        System.out.println("Disciplina: " + turma1.disciplina.getNome());
        System.out.println("Alunos: ");
        turma1.listarAlunos();

        System.out.println("\nTurma 2:");
        System.out.println("Código: " + turma2.getCodigo());
        System.out.println("Professor: " + turma2.professor.getNome());
        System.out.println("Disciplina: " + turma2.disciplina.getNome());
        System.out.println("Alunos: ");
        turma2.listarAlunos();

        System.out.println("\nTurma 3:");
        System.out.println("Código: " + turma3.getCodigo());
        System.out.println("Professor: " + turma3.professor.getNome());
        System.out.println("Disciplina: " + turma3.disciplina.getNome());
        System.out.println("Alunos: ");
        turma3.listarAlunos();
    }
}