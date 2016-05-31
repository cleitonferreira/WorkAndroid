Tracking Com Location API, JobScheduler e Google Maps V2 no Android - Parte 4




Opa, blz?

Nesse vídeo mostro a implementação de um script de Tracking utilizando as tecnologias Location API, JobScheduler API, AsyncTask, EventBus lib e um Dashboard Web para também termos um acompanhamento remoto com uma página Web utilizando Ajax para atualização do Google Maps Web. Não há implementação como costumo fazer nos outros vídeos, porém acredito estar mais show de bola, pois apresento uma implementação utilizando também conteúdos que utilizei em outros vídeos anteriores a essa série do Location API e que são bastante úteis, como: SharedPreferences, AsyncTask, EventBus ("a" Lib do Android)... Fique atento quanto aos comentários que faço sobre a JobSchedulerCompat, pois há alguns problemas sérios nela, um deles é que o consumo de bateria em um dos casos de implementação passou dos 40% a noite o outro foi que eu testando aqui em meu aparelho real e emulador Genymotion ele rodava apenas a primeira vez, nas outras não funcionava, mas ai pode ser problema local (meus devices de teste), nesse caso vc teria de testar com os seus para ver se o problema continua.

Outra coisa a se notar é a não implementação do script de getLastLocation() que aparentemente pode parecer a implementação óbvia a ser utilizada até o momento que descobrimos que ela ou é muito lenta para atualizar sua instancia de last location ou não atualiza até a próxima construção da APP no device. Lembrando que há várias formas de realizar o tracking, uma um pouco mais óbvia é com a utilização de um Service, AlarmaManager e BroadcastReceiver, mas enfim, vou evitar mais delongas e deixar você assistir ao vídeo.

Obs. : O vídeo de cadastro de Places para utilizar no próximo vídeo de "Places Mais Próximos" será implementado ainda, então se baixar o código Web (HTML, JavaScript, PHP, ...) saiba que ainda falta essa parte.

O link para download do projeto, incluindo dados Web, estão logo abaixo no post.

Os links dos vídeos anteriores a essa série estão na "Relacionado" dessa página.

Segue abaixo os links dos vídeos das outras entidades uteis além das de maps utilizadas nesse vídeo:

Google Maps V2 no Android, Inicio e Configuração

http://www.thiengo.com.br/google-maps-v2-no-android-inicio-configuracao

Markers e Listeners no Google Maps Android

http://www.thiengo.com.br/markers-e-listeners-no-google-maps-android

EventBus Lib, Comunicação Entre Entidades Android

http://www.thiengo.com.br/eventbus-lib-comunicacao-entre-entidades-android

SharedPreferences no Android, Entendendo e Utilizando

http://www.thiengo.com.br/sharedpreferences-no-android-entendendo-e-utilizando

AsyncTask no Android, Acesso a Thread Principal de Forma Otimizada

http://www.thiengo.com.br/asynctask-no-android-acesso-a-thread-principal-de-forma-otimizada

Vlw