Obtendo Localiza��o Com Location API no Android - Parte 1




Opa, blz?

Nesse v�deo apresento a nova api de localiza��o do Android, Location API (Fused Location Provider) mais precisamente um novo provider fornecido pela nova Location API do Google Play Services. Nesse v�deo tamb�m come�o com uma nova estrat�gia de v�deos que � reduzir o tamanho do v�deo e encaixar as partes em uma s�rie de v�deos, dessa maneira n�o fica desgastante como um v�deo de 30 minutos ou mais. Mas enfim, com a nova API de localiza��o do Google Play Services a funcionalidade de obter localiza��o (coordenadas) ficou mais f�cil (menos c�digo), ainda precisa (tamb�m utilizando o GPS_PROVIDER via ACCESS_FINE_LOCATION) e r�pida (segundo a documenta��o, a devolu��o dos dados � imediata). Com o falecido LocationManager, muitas vezes tinhamos de escolher qual provider utilizar ou ent�o quando utilizando os dois tinhamos de implmentar um algoritmo para saber como utiliza-los em nosso APP sem perder a consist�ncia dos dados. Com o Location API as coisas ficam bem mais simples.

Note que a palavra reservada synchronized � para permitir que mesmo em ambiente assincrono nossos m�todo execute de forma sincrona. Observa��o: a documenta��o indique a mudan�a imediata de API se estiver utilizando em sua APP a caracteristica de obten��o de localiza��o, ou seja, alterar o uso do antigo LocationManager para o uso do Location API via Google Play Services. Ent�o � isso.

O link para download do projeto se encontra logo abaixo no post.

Segue links das p�ginas apresentadas no v�deo:

P�gina oficial da Location API no site do Android

https://developer.android.com/google/play-services/location.html

P�gina de instala��o do Google Play Services na APP Android

https://developer.android.com/google/play-services/setup.html

P�gina Dashboard de estatisticas de vers�es do Android em uso

https://developer.android.com/about/dashboards/index.html

Implementa��o do Location API no Eclipse no Blog AndroidHive

http://www.androidhive.info/2015/02/android-location-api-using-google-play-services/

Obs. : foi inevit�vel ultrapassar os 8 minutos, mas no pr�ximo acredito que fico dentro deles sem problemas.

Vlw