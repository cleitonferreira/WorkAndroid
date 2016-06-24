AppWidget. Material Design Android - Parte 14



Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre o Material Design no Android, dessa vez abordando uma entidade não tão comum que é o AppWidget que é uma espécie de miniatura de nossas APPs, porém rodando na home screen (ou tela de bloqueio). Note que apesar do tamanho da página de tutorial no site do Android sobre a implementação de AppWidget, a implementação é bem tranquila, pois a explicação das “n” possibilidades é que é longa, mas no momento da implementação o código é relativamente pequeno.

Mesmo sendo abordado somente no final do vídeo (ou próximo a isso), fique atento a configuração do AndroidManifest.xml, pois é nele que precisamos setar o Receiver que vai responder as mensagens de broadcast enviadas pelo AppWidget e é nele também que vamos setar o Service responsável por vincular o Adapter Factory a coleção que apresentará os dados no AppWidget. Outro arquivo importante é o appwidget_provider_info.xml que é colocado dentro do folder res/xml/ é o arquivo de configuração de nosso AppWidget (e a instancia do AppWidgetProvider). Vale ressaltar que o tipo de AppWidget que está sendo utilizado na APP de exemplo da série é o Collection Widget, pois há outros tipos: Information Widget, Control Widget e Hybrid Widget. Sem mais delongas, vou deixar você assistir ao vídeos que está mais completo que o texto.

Acesse o projeto no GitHub https://github.com/viniciusthiengo/tc-material-design

Segue link do vídeo sobre BroadcastReceiver para ajudar no entendimento do conteúdo abordado no vídeo:

BroadcastReceiver no Android, Executando Tarefas no Background

Segue link das páginas listadas no vídeo:

Página de design guidelines do Widget

http://developer.android.com/design/patterns/widgets.html

Página de tutorial de implementação do AppWidget no site de documentação do Android

https://developer.android.com/guide/topics/appwidgets/index.html

Página da class AppWidgetManager

http://developer.android.com/reference/android/appwidget/AppWidgetManager.html

Página da classe RemoteViews

http://developer.android.com/reference/android/widget/RemoteViews.html

Página da classe RemoteViewsFactory

http://developer.android.com/reference/android/widget/RemoteViewsService.RemoteViewsFactory.html

Página da classe RemoteViewsService

http://developer.android.com/reference/android/widget/RemoteViewsService.html

Página do Stackoverflow com implementação de um script de AlarmManager para ativar o onUpdate do AppWidgetProvider com um tempo menor do que 30 minutos (mínimo permitido no Android)

http://stackoverflow.com/questions/3310264/frequently-updating-widgets-more-frequently-than-what-updateperiodmillis-allows

Página da lib Glide para obtenção da imagem remota em formato Bitmap e com download síncrono na Thread de background

https://github.com/bumptech/glide/wiki/Loading-and-Caching-on-Background-Threads

Vlw