package ws;

import metier.Compte;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@WebService(name = "BanqueWS")
public class BanqueService {
    Compte compte = new Compte(1, Math.random() * 9000, new Date());
    List<Compte> comptes = listCompte();


    @WebMethod(operationName = "ConversionEuroToDh")
    public double coversion(@WebParam(name = "montant") double mt) {
        return mt * 11;
    }

    @WebMethod
    public List<Compte> listCompte() {
        List<Compte> comptes = new ArrayList<Compte>();
        comptes.add(new Compte(1, Math.random() * 9000, new Date()));
        comptes.add(new Compte(2, Math.random() * 9000, new Date()));
        comptes.add(new Compte(3, Math.random() * 9000, new Date()));
        return comptes;
    }

    public Compte getCompte( @WebParam int code) {
        for (int i = 0; i < comptes.size(); i++) {
            if (comptes.get(i).getCode() == code) {
                return comptes.get(i);
            }
        }
        return null;

    }

}
