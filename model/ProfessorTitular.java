package br.edu.fateczl.salarioprofessor.model;

public class ProfessorTitular extends Professor {
    private int anosInstituicao;
    private double salario;
    public ProfessorTitular(String nome, int matricula, int idade, int anosInstituicao, double salario){
        super(nome, matricula, idade);
        this.anosInstituicao = anosInstituicao;
        this.salario = salario;
    }

    public int getAnosInstituicao() {
        return anosInstituicao;
    }

    public void setAnosInstituicao(){
        this.anosInstituicao = anosInstituicao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario){
        this.salario = salario;
    }

    @Override
    public double CalcSalario() {
        int ciclosDeCincoAnos = anosInstituicao / 5;
        return salario * (1 + (0.05 * ciclosDeCincoAnos));
    }
}
