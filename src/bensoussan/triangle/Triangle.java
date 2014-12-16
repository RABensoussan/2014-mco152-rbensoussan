package bensoussan.triangle;

public class Triangle {

	private int height;
	public Triangle(int height){
		this.height = height;
	}

	public String toString(){
		StringBuilder info = new StringBuilder();
		int ht = this.height;

		//first row: spaces equal to height - 1, then one star. No matter what!
		for(int i=0; i<ht-1; i++){
			info.append(" ");
		}
		info.append("*\n");

		//middle rows
		int outSpc = ht-2;
		int inSpc = 1;
		while(outSpc>0){
			for(int i=0; i<outSpc; i++){
				info.append(" ");
			}
			info.append("*");
			for(int i=0; i<inSpc; i++){
				info.append(" ");
			}
			info.append("*\n");
			outSpc--;
			inSpc+=2;
		}

		//end row
		for(int i=0; i<ht*2-1; i++){
			info.append("*");
		}

		return info.toString();
	}
	
	public static void main(String args[]){
		Triangle tri = new Triangle(13);
		System.out.println(tri.toString());
	}
}
