package py.com.prestosoftware.facepet.data.remote;

import java.util.List;

import py.com.prestosoftware.facepet.data.model.Empresa;
import py.com.prestosoftware.facepet.data.model.Evento;
import py.com.prestosoftware.facepet.data.model.Favoritos;
import py.com.prestosoftware.facepet.data.model.Login;
import py.com.prestosoftware.facepet.data.model.Token;
import py.com.prestosoftware.facepet.data.model.Usuario;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

public interface FacePetService {

    String LOGIN_URL = "login";
    String REGISTER_URL = "usuarios";
    String User_url="usuarios/{id}";
    String GET_EMPRESAS_URL = "empresas";
    String GET_EVENTOS_URL = "eventos";
    String POST_FAVORITO = "favoritos/{usuario_id}/{evento_id}";

    @POST(LOGIN_URL)
    Observable<Token> sigIn(@Body Login login);


    @GET(User_url)
    Observable<Usuario> getUserData(@Path("id") int usuarioid);


    @POST(REGISTER_URL)
    Observable<Token> registerUser(@Body Usuario usuario);

    @GET(GET_EMPRESAS_URL)
    Observable<List<Empresa>> getEmpresas();

    @GET(GET_EVENTOS_URL)
    Observable<List<Evento>> getEvents();

    @POST(POST_FAVORITO)
    Observable<Favoritos> setFav(@Path("usuario_id") int idUsuario, @Path("evento_id") int idEvento);

}
