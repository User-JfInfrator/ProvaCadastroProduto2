import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) throws Exception {
        List<Produto> listaProduto = new ArrayList<>();
        List<Venda> listaVendas = new ArrayList<>();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        int opcao;
        

        System.out.print("\033[H\033[2J");
            System.out.flush();

       do{
        System.out.println("\n**MENU**\n");

        System.out.println("1 - Incluir produto");
        System.out.println("2 - Consultar produto");
        System.out.println("3 - Listagem de produto");
        System.out.println("4 - Vendas por período");
        System.out.println("5 - Realizar venda");
        System.out.println("0 - Sair do programa");

        opcao = sc.nextInt();

        if(opcao==1){
            System.out.println("Digite o código do produto: ");
            String codigo = sc.next();

            System.out.println("Digite o nome do produto: ");
            String nome= sc.next();

            System.out.println("Digite o valor do produto: ");
            Double valor = sc.nextDouble();

            System.out.println("Digite a quantidade em estoque do produto: ");
            int qtdEstoque = sc.nextInt();

            listaProduto.add(new Produto(codigo,nome,valor,qtdEstoque));

            System.out.println("\n**Produto Cadastrado**\n");
            


        }

        else if(opcao==2){
            System.out.println("Digite o código do produto: ");
            String codigo = sc.next();

            List<Produto> novaList = listaProduto.stream()
            .filter(p -> p .getCodigo().equals(codigo)).collect(Collectors.toList());;
            if(novaList.isEmpty()){
                System.out.println("Produto não localizado!");
            }
            else{
                for (Produto produto : novaList) {
                    System.out.println("\nProdutos cadastrados: \n");
                    System.out.println(produto);
                    
                }
            }

           }
            
    
        else if(opcao==3){
            System.out.println("\nProdutos Cadastrados: \n");
            for (Produto produto : listaProduto) {
                System.out.println(produto);
            }
            DoubleSummaryStatistics resumo = listaProduto.stream()
            .filter(p -> p instanceof Produto)
            .collect(Collectors.summarizingDouble(Produto::getValor));
            System.out.println("\n- Valores dos produtos: \n");
            System.out.println("- Média: " + resumo.getAverage());
            System.out.println("- Maior valor: " + resumo.getMax());
            System.out.println("- Menor valor: " + resumo.getMin() + "\n");
            
        }

        else if(opcao==4){
            
            System.out.println("Digite a primeira data: " + "| Formato: dd/MM/yyyy");
            String primeiraDt = sc.next();

            System.out.println("Digite a segunda data: " + "| Formato: dd/MM/yyyy");
            String segundaDt = sc.next();

            DoubleSummaryStatistics valores = listaProduto.stream()
            .filter(p -> p instanceof Produto)
            .collect(Collectors.summarizingDouble(Produto::getValor));

            LocalDate primeiraData = LocalDate.parse(primeiraDt, df);
            LocalDate segundaData = LocalDate.parse(segundaDt, df);

            for (Venda venda : listaVendas) {
                if(venda.getDataDaVenda().isAfter(primeiraData) && venda.getDataDaVenda().isBefore(segundaData));{
                    System.out.println(venda);
                    
                }
                 
            }
            
            System.out.println("\n- Valor médio das vendas: " + valores.getAverage());
            System.out.println("- Valor total das vendas: " + valores.getSum() + "\n");
            
        }
           

        else if(opcao==5){
            System.out.println("Digite o código do produto que deseja vender: ");
            String codigoVenda = sc.next();

            List<Produto> novaList = listaProduto.stream()
            .filter(p -> p .getCodigo().equals(codigoVenda)).collect(Collectors.toList());
            if(novaList.isEmpty()){
                System.out.println("Produto não localizado!");
            }
            
            else{
                System.out.println("Informe a data da venda: ");
                String data = sc.next();
                LocalDate dataVenda = LocalDate.parse(data, df);

                System.out.println("Informe a quantidade que deseja vender: ");
                int qtdVenda = sc.nextInt();
            
                Produto produto = novaList.get(0);
                Venda venda = new Venda(dataVenda, produto, qtdVenda);
                if(produto.getQtdEstoque() < qtdVenda){
                    System.out.println("\nQuantidade para venda insuficiente! ");
                }
                else {

                listaVendas.add(venda);
                produto.setQtdEstoque(produto.getQtdEstoque() - qtdVenda);
                System.out.println("\n **Venda Realizada** \n");
        }
                
            }

         
        }

    }while(opcao!=0);

    System.out.println("Programa finalizado!");

        
    }
}
