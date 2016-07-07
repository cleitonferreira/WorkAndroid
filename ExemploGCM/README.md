GCM Downstream Messages. Push Message Android - Parte 1




Opa, blz?

Nesse v�deo dou inicio a uma nova s�rie, Push Message no Android, por�m n�o descartando futuras atualiza��es na APP de carros da s�rie anterior. No final dessa s�rie vou voltar a APP de carros e implementar uma feature de push message (GCM, SNS, Parser) que seja a melhor op��o para nossa APP de carros. Note que tamb�m separei esse conte�do de push message para n�o confundir seguidores que est�o buscando apenas uma implementa��o desse tipo de script e n�o uma completa como seria se utilizando a APP de carros.

Como apresentado no v�deo, a implementa��o do novo script do Google Cloud Message (GCM) est� mais simples que a vers�o anterior, tendo em mente que a vers�o anterior n�o mais funcionar�, logo a migra��o para o novo script � necess�ria o quanto antes. Apesar da utiliza��o da classe InstanceID no contexto de GCM ela pode ser utilizada para "n" outras entidades, n�o h� vinculo restrito com os scripts de GCM. O InstanceID nos informa um identificador �nico para nosso conjunto APP / Device al�m de outras features como autentica��o.

Fique atento quanto a configura��o inicial para utilizar o PlayServices na APP e consequentemente utilizar o GCM. Realize o registro do servi�o requisitado, GCM, dessa vez n�o h� necessidade de fingerprint (SHA1 gerado via shell script), apenas de cliques em "Ok" (ou o equivalente) e depois a atualiza��o dos gradles top level e app level. Utilize seus pr�prios API_KEY e SENDER_ID, provavelmente vc ter� de alterar o nome do package principal de seu projeto, pois nomes de package no Android s�o �nicos para toda a plataforma.

N�o comentei nesse v�deo (provavelmente vou falar nos pr�ximos), mas � poss�vel trabalhar com mensagens em t�picos (o registration id n�o teria muita relev�ncia nesse caso de assinatura em t�picos) e com o analytics do Developer Play Store Dashboard para obter dados de falhas e cia na utiliza��o do GCM na APP.

Note que a implementa��o de InstanceIDListenerService � necess�ria segundo a documenta��o, pois o registration id do APP / Device pode se tornar antigo e ent�o parar de funcionar, dessa forma, sem o InstanceIDListenerService, ou seu script realiza a verifica��o de todos os results no lado servidor para cada push message gerado, ou fica sem atualizar o registration id e consequentemente sem enviar novas push messages ao referente device. Note que esse primeiro v�deo foi tamb�m uma maneira de atualizar o primeiro v�deo de GCM que j� tinha no Blog. Sem mais delongas, vou deixar voc� assistir ao video.

GitHub do projeto: https://github.com/viniciusthiengo/push-message-serie

GitHub do projeto, parte Web: https://github.com/viniciusthiengo/push-message-serie-web

Segue link de v�deos que complementam conte�dos desse v�deo (caso ainda n�o os tenha implementado anteriormente):

Volley, Gson e RetryPolicy em Material Design Android S�rie APP

http://www.thiengo.com.br/volley-gson-e-retrypolicy-em-material-design-android-serie-app

SharedPreferences no Android, Entendendo e Utilizando

http://www.thiengo.com.br/sharedpreferences-no-android-entendendo-e-utilizando

EventBus Lib, Comunica��o Entre Entidades Android

http://www.thiengo.com.br/eventbus-lib-comunicacao-entre-entidades-android

Segue links das p�ginas apresentadas no v�deo:

Implementa��o do GCM Client no Android

https://developers.google.com/cloud-messaging/android/client

P�gina de refer�ncia a classe InstanceID

https://developers.google.com/android/reference/com/google/android/gms/iid/InstanceID

Key-value reference para utiliza��o no lado servidor do script GCM

https://developers.google.com/cloud-messaging/server-ref

P�gina de refer�ncia a classe InstanceIDListenerService

https://developers.google.com/android/reference/com/google/android/gms/iid/InstanceIDListenerService

Google Play Services libs

https://developers.google.com/android/guides/setup

Segue link da lib PHP utilizada para facilitar a comunica��o de nosso thrid-part server com o GCM Servers:

Endroid Google Cloud Messaging

https://github.com/endroid/Gcm

Vlw

 