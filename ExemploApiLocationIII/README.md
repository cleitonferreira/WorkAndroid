Obtendo Endereços Com Geocoder em Location API Android - Parte 3





Opa, blz?

Nesse vídeo apresento uma maneira de como obter o endereço ou as coordenadas (quando for informado o endereço) da classe Geocoder do Location API no Android. Apesar da documentação ressaltar a utilização do FINE_LOCATION o Geocoder / Location API trabalha sem problemas com o FUSED_PROVIDER sem essa permissão (sem o uso do GPS), porém o resultado tende a ser desastroso (localidade obtida bem distante da real), logo recomendo que utilize o FINE_LOCATION e se for uma feature crítica as coordenadas do usuário em sua APP, solicite que ele ligue o GPS caso esteja desativado (há intent especifica somente para essa chamada ao usuário para ligar o GPS). A principio não há possibilidade de trabalhar com WayPoints ou com caminhos entre dois pontos (rotas), porém essa é uma funcionalidade que o Google Maps V2 nos permite realizar sem problemas.

Entenda que devido as chamadas do geocoder aos métods de captura de informação (getFromLocation, getFromLocationName, getFromLocationName) serem síncronos, há a necessidade de realizarmos estas dentro de uma worker thread, logo, indo pelo mesmo caminho que a documentação, optei por utilizar também um IntentService por já trabalhar fora da Thread principal quando dentro do método onHandleIntent() tendo em mente também que o script não foi criado para trabalhar com concorrência ou com aplicações externas acessando o Service. A principio é isso, vou dar continuidade a série colocando o Location API trabalhando em uma necessidade real ao invés de somente exemplos, sem mais delongas vou deixar você assistir ao vídeo.

Obs. : se possível tente a implementação com o ResultReceiver (presente da página de documentação da API) e depois tente com o EventBus lib, como no vídeo. Note a facilidade quando está utilizando o EventBus, sem aquele caminhão de código necessário do ResultReceiver. Outra implementação que você poderia testar é a dos métodos de resultado da classe Address, verifique quais realmente são retornados e quais são iguais a null.

O link para download do projeto se encontra logo abaixo no post.

Segue links dos primeiros vídeos da série:

Obtendo Localização Com Location API no Android - Parte 1

Location API no Android, Atualização de Localização - Parte 2

Segue links de vídeos que complementam o entendimento melhor das entidades utilizadas nesse vídeo como apoio a Location API / Geocoder:

EventBus Lib, Comunicação Entre Entidades Android

IntentService no Android, Entendendo e Utilizando

runOnUiThread, Atalho de Acesso a Thread Principal no Android

Segue links apresentados no vídeo:

Página de implmentação do Geocoder utilizando ResultReceiver, no site do Android

https://developer.android.com/training/location/display-address.html

Página da classe final Geocoder no site do Android

https://developer.android.com/reference/android/location/Geocoder.html

Página da classe Address no site do Android

http://developer.android.com/reference/android/location/Address.html

Vlw