package br.edu.fateczl.salarioprofessor.model;

public abstract class Professor {
    private String nome;
    private int matricula;
    private int idade;

    public Professor(String nome, int matricula, int idade){
        this.nome = this.nome;
        this.matricula = this.matricula;
        this.idade = this.idade;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade){
        this.idade = idade;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula){
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public abstract double CalcSalario();
}
