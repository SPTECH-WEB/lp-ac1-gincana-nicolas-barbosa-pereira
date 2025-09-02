package school.sptech;

public class Gincana {
    private String nome= "Gincana";
    private Double premio= 10.0;
    private Integer qtdInscrito=0;
    private Boolean ativa=true;

    public Gincana(String nome, Double premio) {
        this.nome = nome;
        this.premio = premio;
    }

    public void inscrever(Integer qtd){
        if(qtd!=null && qtd>0 && ativa) {
            qtdInscrito += qtd;
        }
    }

    public Integer remover(Integer qtd){
        if(qtd !=null && qtd > 0 && ativa && qtd<=qtdInscrito) {
            qtdInscrito-= qtd;
            return qtd;
        }
        return null;
    }


    public Integer desativar(){
            if(ativa){
                ativa=false;
                int tinhaAlunos=qtdInscrito;
                qtdInscrito=0;
                return tinhaAlunos;
            }

        return null;
    }

    public void transferir(Gincana destino, Integer qtdATransferir){
        if(destino!=null&&destino.ativa){
            if(qtdATransferir!=null && qtdATransferir>0 ){
                if(qtdInscrito>=qtdATransferir&& ativa) {
                    destino.qtdInscrito+=qtdATransferir;
                    qtdInscrito-=qtdATransferir;
                }
            }

        }


    }


    public Boolean reajustarPremio(Double reajuste){

        if(reajuste!=null && reajuste>0){
        premio+= premio*reajuste;
        return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public Double getPremio() {
        return premio;
    }

    public Integer getQtdInscrito() {
        return qtdInscrito;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
