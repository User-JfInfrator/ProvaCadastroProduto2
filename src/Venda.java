import java.time.LocalDate;

public class Venda {

    private LocalDate dataDaVenda;
    private Produto produtoVendido;
    private int qtdVendida;


    public Venda(LocalDate dataDaVenda, Produto produtoVendido, int qtdVendida){
        this.dataDaVenda = dataDaVenda;
        this.produtoVendido = produtoVendido;
        this.qtdVendida = qtdVendida;
    }

    @Override
    public String toString() {
        return String.format("\n\n* Data: %s *\n \n**Produto Vendido**\n %s- Quantidade vendida: %d\n",dataDaVenda,produtoVendido,qtdVendida);
    }

    public LocalDate getDataDaVenda() {
        return dataDaVenda;
    }
    public void setDataDaVenda(LocalDate dataDaVenda) {
        this.dataDaVenda = dataDaVenda;
    }


    public Produto getProdutoVendido() {
        return produtoVendido;
    }
    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }


    public int getQuantidadeVendida() {
        return qtdVendida;
    }
    public void setQuantidadeVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }
    
    
}
