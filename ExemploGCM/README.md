GCM Downstream Messages. Push Message Android - Parte 1




Opa, blz?

Nesse vídeo dou inicio a uma nova série, Push Message no Android, porém não descartando futuras atualizações na APP de carros da série anterior. No final dessa série vou voltar a APP de carros e implementar uma feature de push message (GCM, SNS, Parser) que seja a melhor opção para nossa APP de carros. Note que também separei esse conteúdo de push message para não confundir seguidores que estão buscando apenas uma implementação desse tipo de script e não uma completa como seria se utilizando a APP de carros.

Como apresentado no vídeo, a implementação do novo script do Google Cloud Message (GCM) está mais simples que a versão anterior, tendo em mente que a versão anterior não mais funcionará, logo a migração para o novo script é necessária o quanto antes. Apesar da utilização da classe InstanceID no contexto de GCM ela pode ser utilizada para "n" outras entidades, não há vinculo restrito com os scripts de GCM. O InstanceID nos informa um identificador único para nosso conjunto APP / Device além de outras features como autenticação.

Fique atento quanto a configuração inicial para utilizar o PlayServices na APP e consequentemente utilizar o GCM. Realize o registro do serviço requisitado, GCM, dessa vez não há necessidade de fingerprint (SHA1 gerado via shell script), apenas de cliques em "Ok" (ou o equivalente) e depois a atualização dos gradles top level e app level. Utilize seus próprios API_KEY e SENDER_ID, provavelmente vc terá de alterar o nome do package principal de seu projeto, pois nomes de package no Android são únicos para toda a plataforma.

Não comentei nesse vídeo (provavelmente vou falar nos próximos), mas é possível trabalhar com mensagens em tópicos (o registration id não teria muita relevância nesse caso de assinatura em tópicos) e com o analytics do Developer Play Store Dashboard para obter dados de falhas e cia na utilização do GCM na APP.

Note que a implementação de InstanceIDListenerService é necessária segundo a documentação, pois o registration id do APP / Device pode se tornar antigo e então parar de funcionar, dessa forma, sem o InstanceIDListenerService, ou seu script realiza a verificação de todos os results no lado servidor para cada push message gerado, ou fica sem atualizar o registration id e consequentemente sem enviar novas push messages ao referente device. Note que esse primeiro vídeo foi também uma maneira de atualizar o primeiro vídeo de GCM que já tinha no Blog. Sem mais delongas, vou deixar você assistir ao video.

GitHub do projeto: https://github.com/viniciusthiengo/push-message-serie

GitHub do projeto, parte Web: https://github.com/viniciusthiengo/push-message-serie-web

Segue link de vídeos que complementam conteúdos desse vídeo (caso ainda não os tenha implementado anteriormente):

Volley, Gson e RetryPolicy em Material Design Android Série APP

http://www.thiengo.com.br/volley-gson-e-retrypolicy-em-material-design-android-serie-app

SharedPreferences no Android, Entendendo e Utilizando

http://www.thiengo.com.br/sharedpreferences-no-android-entendendo-e-utilizando

EventBus Lib, Comunicação Entre Entidades Android

http://www.thiengo.com.br/eventbus-lib-comunicacao-entre-entidades-android

Segue links das páginas apresentadas no vídeo:

Implementação do GCM Client no Android

https://developers.google.com/cloud-messaging/android/client

Página de referência a classe InstanceID

https://developers.google.com/android/reference/com/google/android/gms/iid/InstanceID

Key-value reference para utilização no lado servidor do script GCM

https://developers.google.com/cloud-messaging/server-ref

Página de referência a classe InstanceIDListenerService

https://developers.google.com/android/reference/com/google/android/gms/iid/InstanceIDListenerService

Google Play Services libs

https://developers.google.com/android/guides/setup

Segue link da lib PHP utilizada para facilitar a comunicação de nosso thrid-part server com o GCM Servers:

Endroid Google Cloud Messaging

https://github.com/endroid/Gcm

Vlw

 