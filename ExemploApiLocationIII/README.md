Obtendo Endere�os Com Geocoder em Location API Android - Parte 3





Opa, blz?

Nesse v�deo apresento uma maneira de como obter o endere�o ou as coordenadas (quando for informado o endere�o) da classe Geocoder do Location API no Android. Apesar da documenta��o ressaltar a utiliza��o do FINE_LOCATION o Geocoder / Location API trabalha sem problemas com o FUSED_PROVIDER sem essa permiss�o (sem o uso do GPS), por�m o resultado tende a ser desastroso (localidade obtida bem distante da real), logo recomendo que utilize o FINE_LOCATION e se for uma feature cr�tica as coordenadas do usu�rio em sua APP, solicite que ele ligue o GPS caso esteja desativado (h� intent especifica somente para essa chamada ao usu�rio para ligar o GPS). A principio n�o h� possibilidade de trabalhar com WayPoints ou com caminhos entre dois pontos (rotas), por�m essa � uma funcionalidade que o Google Maps V2 nos permite realizar sem problemas.

Entenda que devido as chamadas do geocoder aos m�tods de captura de informa��o (getFromLocation, getFromLocationName, getFromLocationName) serem s�ncronos, h� a necessidade de realizarmos estas dentro de uma worker thread, logo, indo pelo mesmo caminho que a documenta��o, optei por utilizar tamb�m um IntentService por j� trabalhar fora da Thread principal quando dentro do m�todo onHandleIntent() tendo em mente tamb�m que o script n�o foi criado para trabalhar com concorr�ncia ou com aplica��es externas acessando o Service. A principio � isso, vou dar continuidade a s�rie colocando o Location API trabalhando em uma necessidade real ao inv�s de somente exemplos, sem mais delongas vou deixar voc� assistir ao v�deo.

Obs. : se poss�vel tente a implementa��o com o ResultReceiver (presente da p�gina de documenta��o da API) e depois tente com o EventBus lib, como no v�deo. Note a facilidade quando est� utilizando o EventBus, sem aquele caminh�o de c�digo necess�rio do ResultReceiver. Outra implementa��o que voc� poderia testar � a dos m�todos de resultado da classe Address, verifique quais realmente s�o retornados e quais s�o iguais a null.

O link para download do projeto se encontra logo abaixo no post.

Segue links dos primeiros v�deos da s�rie:

Obtendo Localiza��o Com Location API no Android - Parte 1

Location API no Android, Atualiza��o de Localiza��o - Parte 2

Segue links de v�deos que complementam o entendimento melhor das entidades utilizadas nesse v�deo como apoio a Location API / Geocoder:

EventBus Lib, Comunica��o Entre Entidades Android

IntentService no Android, Entendendo e Utilizando

runOnUiThread, Atalho de Acesso a Thread Principal no Android

Segue links apresentados no v�deo:

P�gina de implmenta��o do Geocoder utilizando ResultReceiver, no site do Android

https://developer.android.com/training/location/display-address.html

P�gina da classe final Geocoder no site do Android

https://developer.android.com/reference/android/location/Geocoder.html

P�gina da classe Address no site do Android

http://developer.android.com/reference/android/location/Address.html

Vlw