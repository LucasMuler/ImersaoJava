import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Key;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception{

        /*
            fazer uma conexão HTTP e buscar os top 250 filmes
            --------------------------------------------------------------------------------------------------
         */

        String url = "https://imdb-api.com/en/API/Top250Movies/k_f6uutxwi"; // armazenando a URL
        var endereco = URI.create(url); // criando uma URI a partir da URL
        HttpClient client = HttpClient.newHttpClient(); // cria uma variavel que pode fazer requisições basicas do tipo HTTP
        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build(); //cria uma requisição do tipo get no seguinte
        // endereco HTTP
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString()); // cria uma resposta
        // HTTP e transforma a mesma em uma String
        String body = response.body(); // pega o body da String e armazena em uma variável
        // (no caso o body é a String inteira)
        System.out.println(body);

        // --------------------------------------------------------------------------------------------------

        /*
            Parseando o arquivo de String para poder dividrmos
            --------------------------------------------------------------------------------------------------
         */

        JsonParser parser = new JsonParser();
        List<Map<String,String>> listaDeFilmes = parser.parse(body);


        /*
            Trabalhando com as Strings
            --------------------------------------------------------------------------------------------------
         */

        for (Map<String,String> filme: listaDeFilmes) {
            System.out.println("\u001b[371m \u001b[45mClassificação:" + filme.get("imDbRating") + "\u001b[m");

            int classificacao = (int) Double.parseDouble(filme.get("imDbRating"));
            for(int i = 0; i < classificacao; i++){
                System.out.print("⭐");
            }
            System.out.println();
            System.out.println("Titulo : " + filme.get("title"));
            System.out.println("Poster : " + filme.get("image"));
            System.out.println();
        }

    }
}