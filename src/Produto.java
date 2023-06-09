public class Produto {

    private String codigo;
    private String nome;
    private double valor;
    private int qtdEstoque;

    public Produto(String codigo, String nome, double valor, int qtdEstoque){
        this.codigo = codigo;
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
    }

    @Override
    public String toString() {
        return String.format("\n- Nome: %s\n- Codigo: %s \n- Valor: %.2f \n- Quantidade em estoque: %d\n",nome,codigo,valor,qtdEstoque);
    
    }


    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    
}
