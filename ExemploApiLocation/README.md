Obtendo Localização Com Location API no Android - Parte 1




Opa, blz?

Nesse vídeo apresento a nova api de localização do Android, Location API (Fused Location Provider) mais precisamente um novo provider fornecido pela nova Location API do Google Play Services. Nesse vídeo também começo com uma nova estratégia de vídeos que é reduzir o tamanho do vídeo e encaixar as partes em uma série de vídeos, dessa maneira não fica desgastante como um vídeo de 30 minutos ou mais. Mas enfim, com a nova API de localização do Google Play Services a funcionalidade de obter localização (coordenadas) ficou mais fácil (menos código), ainda precisa (também utilizando o GPS_PROVIDER via ACCESS_FINE_LOCATION) e rápida (segundo a documentação, a devolução dos dados é imediata). Com o falecido LocationManager, muitas vezes tinhamos de escolher qual provider utilizar ou então quando utilizando os dois tinhamos de implmentar um algoritmo para saber como utiliza-los em nosso APP sem perder a consistência dos dados. Com o Location API as coisas ficam bem mais simples.

Note que a palavra reservada synchronized é para permitir que mesmo em ambiente assincrono nossos método execute de forma sincrona. Observação: a documentação indique a mudança imediata de API se estiver utilizando em sua APP a caracteristica de obtenção de localização, ou seja, alterar o uso do antigo LocationManager para o uso do Location API via Google Play Services. Então é isso.

O link para download do projeto se encontra logo abaixo no post.

Segue links das páginas apresentadas no vídeo:

Página oficial da Location API no site do Android

https://developer.android.com/google/play-services/location.html

Página de instalação do Google Play Services na APP Android

https://developer.android.com/google/play-services/setup.html

Página Dashboard de estatisticas de versões do Android em uso

https://developer.android.com/about/dashboards/index.html

Implementação do Location API no Eclipse no Blog AndroidHive

http://www.androidhive.info/2015/02/android-location-api-using-google-play-services/

Obs. : foi inevitável ultrapassar os 8 minutos, mas no próximo acredito que fico dentro deles sem problemas.

Vlw