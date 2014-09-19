package fontes.correioBrasil;

import fontes.ObtemNoticias;

public class ObtemNoticiasCorreioBrasil extends ObtemNoticias{
	
	public ObtemNoticiasCorreioBrasil(){
		super();
	}
	
	public static void main(String[] args) {
		try{
			new ObtemNoticiasCorreioBrasil().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaCorreioBrasil());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasCorreioBrasil.main: "+e);
		}
	}

}
