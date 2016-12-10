Notifica��es com NotificationCompat. Push Message Android - Parte 2




Opa, blz?

Dando continuidade a s�rie de v�deos sobre Push Message no Android, nesse v�deo apresento algumas maneiras de utilizar a feature de notifica��es no Android, mais precisamente a classe NotificationCompat, que nos permite trabalhar da mesma forma (em termos de c�digo) na API 21 ou superior quanto em APIs mais antigas.

Notification � uma entidade importante quando utilizando servi�os de push message, pois muitas vezes a exist�ncia do push message � apenas para informar sobre conte�do novo dispon�vel, por�m para informar � necess�rio o Notification que printa parte da informa��o na status bar do device (ou notification area). Al�m de trabalhar junto ao servi�o de push message, o Notification tamb�m pode ser utilizado para servi�os de stream, como no uso de arquivos mp3 com o MediaPlayer, vinculado a um service. O Notification nesse caso permitiria que o controle do audio fosse utilizado no �rea de notifica��es quando a tela estivesse n�o na lock screen e tamb�m quando em lock screen. Como apresentado tamb�m no v�deo, � poss�vel utilizar at� tr�s action buttons junto a notification com o intuito de adiantar tarefas no background, os action buttons t�m principalmente essa funcionalidade, permitir o user realizar tarefas frequentes (ou urgentes para a continuidade da tarefa atual em tela, por exemplo) com apenas um clique e sem a necessidade de abrir um Activity para isso.

No v�deo � apresentado como trabalhar com uma pilha virtual de Activities (utilizando a TaskStackBuilder), que mesmo n�o aparentando, tem uma import�ncia alta na defini��o de Activities que v�o al�m da Activity principal da APP na chamada via Notification e n�o s�o constru�das no AndroidManifest.xml como Activities "especiais" (abertas apenas via Notification). Pois a pilha virtual permiti que o caminho normal seguido pelo user para abrir a Activity (quando entrando pela APP via home screen icon) ainda seja utilizado, por�m utilizado na volta da Activity, tendo em mente que ela foi aberta diretamente via Notification. Apresento tamb�m a interface da Notification com o progress para download / upload de conte�do e tamb�m como utilizar layouts personalizados como RemoteViews.

No v�deo busco apresentar somente o push message ativando o Notification e as v�rias formas de utilizar o Notification (mesmo que ainda tendo mais formas), logo a aplica��o das entidades de push message e Notification ainda n�o est�o em um contexto, por exemplo: um APP Android de mensagens instataneas. A contextualiza��o das features vai vir com v�deos futuros da s�rie. Sem mais delongas vou deixar voc� assistir ao v�deo.

Bugs. : aparentemente o bug do atributo excludeFromRecents ainda n�o foi resolvido. O problema do script de visibilidade de notifica��o aparentemente tamb�m � um bug, mas esse n�o encontrei nada relatado que realmente � um bug, logo no pr�ximo v�deo provavelmente vai ter a corre��o dele.

GitHub do projeto: https://github.com/viniciusthiengo/push-message-serie

GitHub da parte Web do projeto: https://github.com/viniciusthiengo/push-message-serie-web

Segue link da PlayList da s�rie:

Push Messages Android

https://www.youtube.com/watch?v=Wo4lZ72NNN4&list=PLBA57K2L2RII4K3RpWuWsLaCCyPTBb1gw

Segue links das p�ginas utilizadas na constru��o do v�deo:

P�gina da classe NotificationCompat.Builder

http://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html

P�gina tutorial de implementa��o de Notification, na documenta��o do Android

http://developer.android.com/guide/topics/ui/notifiers/notifications.html

P�gina de Design Notification a partir do Material Design

http://developer.android.com/design/patterns/notifications.html

P�gina de Design Notification abaixo do Material Design

http://developer.android.com/design/patterns/notifications_k.html

P�gina documenta��o dos atributos da tag <activity>

http://developer.android.com/guide/topics/manifest/activity-element.html

Material Design Icons

https://materialdesignicons.com/

P�gina de refer�ncia dos atributos do lado servidor no script de comunica��o via push message GCM

https://developers.google.com/cloud-messaging/server-ref

P�gina / resposta no stackoverflow com implementa��o dos scripts de Vibrate, Sound e LED no Notification

http://stackoverflow.com/a/18253601/2578331

Vlw