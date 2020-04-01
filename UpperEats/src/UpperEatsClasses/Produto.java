package UpperEatsClasses;

public class Produto {
    private String nome;
    private float preco;
    private int idProduto;
    
    public Produto(){
        nome ="";
        preco = 0.0f;
        idProduto = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    
    
}
