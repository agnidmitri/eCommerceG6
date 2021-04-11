package entities;

public class Produto
{
		
		//atributes
	
		private String descricao; 
		private String codigo;
		private double valorUnid;
		private int estoque = 0;
	

		
		//constructor
		
		public Produto (String codigo, String descricao, double valorUnid, int estoque) 
		{
			super(); 
			this.descricao = descricao;
			this.valorUnid = valorUnid;		
			this.estoque = estoque;
		//
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		public String getCodigo() {
			return codigo;
		}
	
		public double getValorUnid() {
			return valorUnid;
		}
		public void setValorUnid(double valorUnid) {
			this.valorUnid = valorUnid;
		}
		public int getEstoque() {
			return estoque;
		}
		
		//
		
		public void addEstoque(int addEstoque) 
		{
			this.estoque = this.estoque + addEstoque;
		}
		
		public void tiraEstoque(int tiraEstoque)
		{
			if (this.estoque >= tiraEstoque) 
			{
				this.estoque = this.estoque - tiraEstoque;
				
			}
			
			else 
			{
				System.out.println("Sem estoque disponível.");
			}
		}
	
		
}
