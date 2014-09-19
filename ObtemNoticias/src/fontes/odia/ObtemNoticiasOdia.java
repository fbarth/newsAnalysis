package fontes.odia;

import fontes.ObtemNoticias;

public class ObtemNoticiasOdia extends ObtemNoticias{

	public ObtemNoticiasOdia(){
		super();
	}
	
	public static void main(String[] args) {
		try{
			new ObtemNoticiasOdia().obtemNoticias(args[0],args[1],args[2],args[3],new NoticiaOdia());
		}catch(Exception e){
			System.out.println("Error at ObtemNoticiasOdia.main: "+e);
		}
	}

}
