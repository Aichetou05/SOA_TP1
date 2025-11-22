package mr.supnum.biblio_soap.endpoint;


import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mr.supnum.biblio_soap.service.LivreService;
import mr.supnum.server_manager.wsdl.AddLivreRequest;
import mr.supnum.server_manager.wsdl.AddLivreResponse;
import mr.supnum.server_manager.wsdl.DeleteLivreRequest;
import mr.supnum.server_manager.wsdl.DeleteLivreResponse;
import mr.supnum.server_manager.wsdl.EmpruntLivreRequest;
import mr.supnum.server_manager.wsdl.EmpruntLivreResponse;
import mr.supnum.server_manager.wsdl.GetAllLivresRequest;
import mr.supnum.server_manager.wsdl.GetAllLivresResponse;
import mr.supnum.server_manager.wsdl.GetLivreRequest;
import mr.supnum.server_manager.wsdl.GetLivreResponse;
import mr.supnum.server_manager.wsdl.Livre;
import mr.supnum.server_manager.wsdl.ReturnLivreRequest;
import mr.supnum.server_manager.wsdl.ReturnLivreResponse;
import mr.supnum.server_manager.wsdl.UpdateLivreRequest;
import mr.supnum.server_manager.wsdl.UpdateLivreResponse;

@Endpoint
public class LivreEndpoint {

    private static final String NAMESPACE_URI = "http://supnum.mr/livres";

    private final LivreService livreService;

    public LivreEndpoint(LivreService livreService) {
        this.livreService = livreService;
    }

    // GetLivre(isbn)
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLivreRequest")
    @ResponsePayload
    public GetLivreResponse getLivre(@RequestPayload GetLivreRequest request) {
        Livre livre = livreService.getLivre(request.getIsbn());
        GetLivreResponse response = new GetLivreResponse();
        response.setLivre(livre);
        return response;
    }

    // GetAllLivres()
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllLivresRequest")
    @ResponsePayload
    public GetAllLivresResponse getAllLivres(@RequestPayload GetAllLivresRequest request) {
        GetAllLivresResponse response = new GetAllLivresResponse();
        response.getLivres().addAll(livreService.getAllLivres());
        return response;
    }

    // AddLivre(livre)
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addLivreRequest")
    @ResponsePayload
    public AddLivreResponse addLivre(@RequestPayload AddLivreRequest request) {
        Livre saved = livreService.addLivre(request.getLivre());
        AddLivreResponse response = new AddLivreResponse();
        response.setLivre(saved);
        return response;
    }

    // UpdateLivre(isbn, livre)
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateLivreRequest")
    @ResponsePayload
    public UpdateLivreResponse updateLivre(@RequestPayload UpdateLivreRequest request) {
        Livre updated = livreService.updateLivre(request.getIsbn(), request.getLivre());
        UpdateLivreResponse response = new UpdateLivreResponse();
        response.setLivre(updated);
        return response;
    }

    // DeleteLivre(isbn)
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteLivreRequest")
    @ResponsePayload
    public DeleteLivreResponse deleteLivre(@RequestPayload DeleteLivreRequest request) {
        boolean ok = livreService.deleteLivre(request.getIsbn());
        DeleteLivreResponse response = new DeleteLivreResponse();
        response.setSuccess(ok);
        return response;
    }

    // EmpruntLivre(isbn)
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "empruntLivreRequest")
    @ResponsePayload
    public EmpruntLivreResponse empruntLivre(@RequestPayload EmpruntLivreRequest request) {
        Livre livre = livreService.empruntLivre(request.getIsbn());
        EmpruntLivreResponse response = new EmpruntLivreResponse();
        response.setLivre(livre);
        return response;
    }

    // ReturnLivre(isbn)
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "returnLivreRequest")
    @ResponsePayload
    public ReturnLivreResponse returnLivre(@RequestPayload ReturnLivreRequest request) {
        Livre livre = livreService.returnLivre(request.getIsbn());
        ReturnLivreResponse response = new ReturnLivreResponse();
        response.setLivre(livre);
        return response;
    }
}
