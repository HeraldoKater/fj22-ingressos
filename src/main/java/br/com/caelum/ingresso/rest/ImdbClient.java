package br.com.caelum.ingresso.rest;

public class ImdbClient {

	@Component
	public class ImdbClient	{
	
		private	Logger logger =	Logger.getLogger(ImdbClient.class);

		public Optional<DetalhesDoFilme> request(Filme filme){
						
			RestTemplate client	= new RestTemplate();
			
			String titulo = filme.getNome().replace(" ", "+");
			
			String url = String.format("https://imdb-fj22.herokuapp.com/imdb?title=%s",	titulo);
			
				try	{
					DetalhesDoFilme	detalhesDoFilme	= client.getForObject(url, DetalhesDoFilme.class);
					return	Optional.of(detalhesDoFilme);
				
				}catch	(RestClientException	e){
					logger.error(e.getMessage(),	e);
					return	Optional.empty();
				}
		}
	}
}
