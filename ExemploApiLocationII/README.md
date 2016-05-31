Location API no Android, Atualização de Localização - Parte 2




Opa, blz?

Nesse vídeo parte 2 da série de vídeos sobre a Location API no Android mostro como utilizar as entidades LocationRequest e LocationListener para manter o objeto de coordenadas da APP atualizado quanto ao local do usuário, mais precisamente do device. É importante entender o funcionamento dos métodos setInterval() e setFastestInterval() para não se perder quanto as atualizações de coordenadas enviadas ao listener onLocationChanged() (que de vez em quando eu chamo de trigger no vídeo, mas ele é o listener). Fique atento também ao método setPriority() que nos permiti setar qual será a forma prioritária de se utilizar o Fused Provider e não qual é o provider a ser utilizado. Nesse vídeo novamente não consegui ficar dentro dos 8 minutos, mas mesmo assim 14 minutos acredito que ficou em um tempo aceitável. Nessa implementação o update coordenadas está rodando somente com a aplicação aberta, provavelmente no último vídeo da série eu vou postar uma implementação com ele rodando no background com um Service e ResultReceiver (esse último para quando a APP estiver aberta). Sem mais delongas, vou deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Segue links das páginas apresentadas no vídeo:

Página de implementação do Location updates no Android

https://developer.android.com/training/location/receive-location-updates.html

Página da classe LocationRequest no site de documentação do Android

https://developer.android.com/reference/com/google/android/gms/location/LocationRequest.html

Área sobre o método getSpeed() da classe Location no site de documentação do Android

http://developer.android.com/reference/android/location/Location.html#getSpeed()

Vlw