package entities;

import java.util.*;
public class Loja {
	
	private String nome; 
	private String cnpj;
	
	Scanner leia = new Scanner(System.in);
	List<Roupa> lista = new ArrayList<>();
	
	public Loja(String nome, String cnpj) 
	{
		super();
		this.nome = nome; 
		this.cnpj = cnpj;		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void emitirNota(List<Roupa> lista) 
	{
		double total = 0;
		double desconto;
		double juros10, juros20;
		double imposto;
		int opcao;
		
		System.out.printf("Loja: %s - G6\n%s\n",nome,cnpj);
		for (Roupa itens : lista)
		{
			System.out.printf("Produto: %s | Valor Unit: R$%.2f | Qtde: %d | Valor total: R$%.2f\n",itens.getDescricao(),itens.getValorUnid(),itens.getEstoque(),itens.getValorUnid()*itens.getEstoque());
			total = total + (itens.getValorUnid()*itens.getEstoque());
		}
		imposto = total*0.09;
		do {
			System.out.printf("\nTotal da compra: %.2f\n",total);
			System.out.println("Forma de pagamento");
			System.out.println("1 - Transferência/Pix/Boleto (10% de desconto)\n2 - Débito\n3 - Crédito: ");
			opcao = leia.nextInt();
			
		
			if (opcao == 1) 
			{
				desconto = total*0.1;
				System.out.println("NOTA FISCAL 985506042021");
				System.out.println("ESTABELECIMENTO: "+nome+"- G6");
				System.out.println("CNPJ: 489.5765.3350-54");
				System.out.printf("\nTaxa de imposto: R$%.2f\nDesconto: R$%.2f\nTotal da compra: R$%.2f",imposto, desconto, (total-desconto));
			}
			else if (opcao==2) 
			{
				System.out.println("NOTA FISCAL 985506042021");
				System.out.println("ESTABELECIMENTO: "+nome+"- G6");
				System.out.println("CNPJ: 489.5765.3350-54");
				System.out.printf("Taxa de imposto: R$%.2f\nTotal da compra: R$%.2f",imposto, total);
			}
			else if (opcao == 3) 
			{
				do
				{
					System.out.println("Quantas vezes deseja parcelar?");
					System.out.println("1 - 1x (juros 10%)\n2 - 2x (juros 20%): ");
					opcao = leia.nextInt();
					
					if(opcao == 1)
					{
						juros10 = total*0.1;
						System.out.println("NOTA FISCAL 987506042021");
						System.out.println("ESTABELECIMENTO: "+nome+"- G6");
						System.out.println("CNPJ: 489.5765.3350-54");
						System.out.printf("Taxa de imposto: R$%.2f\nJuros: R$%.2f\nTotal da compra: R$%.2f",imposto, juros10, (total+juros10));
					}
					else if (opcao == 2)
					{
						juros20 = total*0.2;
						System.out.println("NOTA FISCAL 995506042021");
						System.out.println("ESTABELECIMENTO: "+nome+"- G6");
						System.out.println("CNPJ: 489.5765.3350-54");
						System.out.printf("Taxa de imposto: R$%.2f\nJuros: R$%.2f\nValor parcela: R$ %.2f\nTotal da compra: R$%.2f",imposto, juros20, ((total+juros20)/2),(total+juros20));
					}
					else
					{
						System.out.println("Opção de parcelamento não disponível.");
					}
				}while(opcao != 1 && opcao != 2);
			}
			else {
				System.out.println("Opção invalida");
			}
		}
		while(opcao !=1 && opcao !=2 && opcao !=3);
		System.out.println("\nDigite qualquer tecla para continuar: ");
		leia.next();
	}
	
}
