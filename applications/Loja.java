package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Roupa;

public class Loja 
{

	public static void main(String[] args) 
	{
		
		Roupa roupa;
		int opcao;
		int x;
		int quantidade;
		
		
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner (System.in); 
		List <Roupa> lista = new ArrayList<>();
		List <Roupa> carrinho = new ArrayList<>();
		
		lista.add(roupa = new Roupa ("P00154","Calças",80.95, 10,"Kemet"));
		lista.add(roupa = new Roupa ("S00155","Camisetas",45.50, 10,"Kemet"));
		lista.add(roupa = new Roupa ("J00156","Jaquetas",125.99, 10,"Kemet"));
		lista.add(roupa = new Roupa ("D00157","Vestidos",110.00, 10,"Kemet"));
		lista.add(roupa = new Roupa ("D00158","Shorts",55.00, 10,"Kemet"));

		boolean confirma[] = new boolean [lista.size()];
		for (x = 0; x<confirma.length;x++)
		{
			confirma[x]=true;
		}
		
		do {	
				System.out.println("KEMET - G6");
				System.out.println("\nCategorias\n");
				for (x=0; x <lista.size();x++) 
				{
					System.out.printf("%d - %s\n",x+1,lista.get(x).getDescricao());
				}
				System.out.printf("%d - Carrinho\n",x+1);
				System.out.printf("%d - Sair\n", x+2);
				System.out.println("\nSelecione uma categoria: ");
				opcao = leia.nextInt();
				opcao --;
				
				if(opcao < lista.size() && opcao >= 0) 
				{
					if (confirma[opcao] == true) 
					{
						if(lista.get(opcao).getEstoque()>0) 
						{
							System.out.printf("Descrição: %s %s | Valor Unit: R$%.2f | Disponível em estoque: %d\n", lista.get(opcao).getDescricao(),lista.get(opcao).getMarca(),lista.get(opcao).getValorUnid(), lista.get(opcao).getEstoque());
							System.out.print("\nQuantidade: ");
							quantidade = leia.nextInt();
							
							 if (quantidade <= lista.get(opcao).getEstoque() && quantidade >=0) 
							 {
								 lista.get(opcao).tiraEstoque(quantidade);
								 carrinho.add(roupa = new Roupa(lista.get(opcao).getCodigo(),lista.get(opcao).getDescricao(),lista.get(opcao).getValorUnid(),quantidade, lista.get(opcao).getMarca())); 
								
								 if(quantidade > 0) 
								 {
									confirma[opcao] = false; 
								 }
							 }
								 else if (quantidade > lista.get(opcao).getEstoque())
								 {
									 System.out.println("\nQuantidade não disponível em estoque.\n");
								 }
								 else 
								 {
									 System.out.println("\nOpção inválida.");
								 }
						}
						else {
							System.out.println("fora de estoque ");
						}
						}	 
					else 
					{
						System.out.println("Finalize seu carrinho antes de voltar a comprar este item.");
					}
				}
					
				else if (opcao == x) 
				{
					if(carrinho.size()==0) 
					{
						System.out.println("O carrinho esta vazio\nRedirecionado para menu pricipal\n");
					}
					else 
					{
						limpa();
						System.out.println("Carrinho");
						entities.Loja loja = new entities.Loja("Kemet - G6","CNPJ: 489.5765.3350-54");
						loja.emitirNota(carrinho);
						carrinho.clear();
						limpa();
						for(x = 0; x<confirma.length;x++)
						{
							confirma[x]=true;
						}
					}
						
				}
				else if (opcao == (x+1))
				{
					System.out.println("Fim do programa");
				}
		
				else 
				{
					System.out.println("\nOpção inválida. Tente outra opção.");
				}
		  } while (opcao !=(lista.size()+1));
	}
		
	public static void limpa ()
	{
		for (int y = 0; y <=10; y++)
		{
			System.out.println();
		}
	}
}
