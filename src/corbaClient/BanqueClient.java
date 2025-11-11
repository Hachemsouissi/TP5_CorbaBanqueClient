package corbaClient;

import corbaBanque.Compte;
import corbaBanque.IBanqueRemote;
import corbaBanque.IBanqueRemoteHelper;

import javax.naming.Context;
import javax.naming.InitialContext;

public class BanqueClient {
    public static void main(String[] args) {
        try {
            System.out.println("Démarrage du Client CORBA Banque");
            Context ctx = new InitialContext();
            Object ref = ctx.lookup("BK");
            IBanqueRemote stub= IBanqueRemoteHelper.narrow((org.omg.CORBA.Object)ref);
            Compte c1 = new Compte(1, 1000);
            Compte c2 = new Compte(2, 200);
            stub.creerCompte(c1);
            stub.creerCompte(c2);
            System.out.println("Comptes créés avec succès.");
            stub.verser(100, 1);
            System.out.println("Versement de 100  sur le compte 1.");
            System.out.println("Résultat de conversion :"+stub.conversion(600));

        }catch (Exception e) { e.printStackTrace(); }
    }
}

