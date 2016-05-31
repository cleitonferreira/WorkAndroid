Tracking Com Location API, JobScheduler e Google Maps V2 no Android - Parte 4




Opa, blz?

Nesse v�deo mostro a implementa��o de um script de Tracking utilizando as tecnologias Location API, JobScheduler API, AsyncTask, EventBus lib e um Dashboard Web para tamb�m termos um acompanhamento remoto com uma p�gina Web utilizando Ajax para atualiza��o do Google Maps Web. N�o h� implementa��o como costumo fazer nos outros v�deos, por�m acredito estar mais show de bola, pois apresento uma implementa��o utilizando tamb�m conte�dos que utilizei em outros v�deos anteriores a essa s�rie do Location API e que s�o bastante �teis, como: SharedPreferences, AsyncTask, EventBus ("a" Lib do Android)... Fique atento quanto aos coment�rios que fa�o sobre a JobSchedulerCompat, pois h� alguns problemas s�rios nela, um deles � que o consumo de bateria em um dos casos de implementa��o passou dos 40% a noite o outro foi que eu testando aqui em meu aparelho real e emulador Genymotion ele rodava apenas a primeira vez, nas outras n�o funcionava, mas ai pode ser problema local (meus devices de teste), nesse caso vc teria de testar com os seus para ver se o problema continua.

Outra coisa a se notar � a n�o implementa��o do script de getLastLocation() que aparentemente pode parecer a implementa��o �bvia a ser utilizada at� o momento que descobrimos que ela ou � muito lenta para atualizar sua instancia de last location ou n�o atualiza at� a pr�xima constru��o da APP no device. Lembrando que h� v�rias formas de realizar o tracking, uma um pouco mais �bvia � com a utiliza��o de um Service, AlarmaManager e BroadcastReceiver, mas enfim, vou evitar mais delongas e deixar voc� assistir ao v�deo.

Obs. : O v�deo de cadastro de Places para utilizar no pr�ximo v�deo de "Places Mais Pr�ximos" ser� implementado ainda, ent�o se baixar o c�digo Web (HTML, JavaScript, PHP, ...) saiba que ainda falta essa parte.

O link para download do projeto, incluindo dados Web, est�o logo abaixo no post.

Os links dos v�deos anteriores a essa s�rie est�o na "Relacionado" dessa p�gina.

Segue abaixo os links dos v�deos das outras entidades uteis al�m das de maps utilizadas nesse v�deo:

Google Maps V2 no Android, Inicio e Configura��o

http://www.thiengo.com.br/google-maps-v2-no-android-inicio-configuracao

Markers e Listeners no Google Maps Android

http://www.thiengo.com.br/markers-e-listeners-no-google-maps-android

EventBus Lib, Comunica��o Entre Entidades Android

http://www.thiengo.com.br/eventbus-lib-comunicacao-entre-entidades-android

SharedPreferences no Android, Entendendo e Utilizando

http://www.thiengo.com.br/sharedpreferences-no-android-entendendo-e-utilizando

AsyncTask no Android, Acesso a Thread Principal de Forma Otimizada

http://www.thiengo.com.br/asynctask-no-android-acesso-a-thread-principal-de-forma-otimizada

Vlw