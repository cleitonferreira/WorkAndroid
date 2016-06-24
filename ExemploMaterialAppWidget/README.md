AppWidget. Material Design Android - Parte 14



Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre o Material Design no Android, dessa vez abordando uma entidade n�o t�o comum que � o AppWidget que � uma esp�cie de miniatura de nossas APPs, por�m rodando na home screen (ou tela de bloqueio). Note que apesar do tamanho da p�gina de tutorial no site do Android sobre a implementa��o de AppWidget, a implementa��o � bem tranquila, pois a explica��o das �n� possibilidades � que � longa, mas no momento da implementa��o o c�digo � relativamente pequeno.

Mesmo sendo abordado somente no final do v�deo (ou pr�ximo a isso), fique atento a configura��o do AndroidManifest.xml, pois � nele que precisamos setar o Receiver que vai responder as mensagens de broadcast enviadas pelo AppWidget e � nele tamb�m que vamos setar o Service respons�vel por vincular o Adapter Factory a cole��o que apresentar� os dados no AppWidget. Outro arquivo importante � o appwidget_provider_info.xml que � colocado dentro do folder res/xml/ � o arquivo de configura��o de nosso AppWidget (e a instancia do AppWidgetProvider). Vale ressaltar que o tipo de AppWidget que est� sendo utilizado na APP de exemplo da s�rie � o Collection Widget, pois h� outros tipos: Information Widget, Control Widget e Hybrid Widget. Sem mais delongas, vou deixar voc� assistir ao v�deos que est� mais completo que o texto.

Acesse o projeto no GitHub https://github.com/viniciusthiengo/tc-material-design

Segue link do v�deo sobre BroadcastReceiver para ajudar no entendimento do conte�do abordado no v�deo:

BroadcastReceiver no Android, Executando Tarefas no Background

Segue link das p�ginas listadas no v�deo:

P�gina de design guidelines do Widget

http://developer.android.com/design/patterns/widgets.html

P�gina de tutorial de implementa��o do AppWidget no site de documenta��o do Android

https://developer.android.com/guide/topics/appwidgets/index.html

P�gina da class AppWidgetManager

http://developer.android.com/reference/android/appwidget/AppWidgetManager.html

P�gina da classe RemoteViews

http://developer.android.com/reference/android/widget/RemoteViews.html

P�gina da classe RemoteViewsFactory

http://developer.android.com/reference/android/widget/RemoteViewsService.RemoteViewsFactory.html

P�gina da classe RemoteViewsService

http://developer.android.com/reference/android/widget/RemoteViewsService.html

P�gina do Stackoverflow com implementa��o de um script de AlarmManager para ativar o onUpdate do AppWidgetProvider com um tempo menor do que 30 minutos (m�nimo permitido no Android)

http://stackoverflow.com/questions/3310264/frequently-updating-widgets-more-frequently-than-what-updateperiodmillis-allows

P�gina da lib Glide para obten��o da imagem remota em formato Bitmap e com download s�ncrono na Thread de background

https://github.com/bumptech/glide/wiki/Loading-and-Caching-on-Background-Threads

Vlw