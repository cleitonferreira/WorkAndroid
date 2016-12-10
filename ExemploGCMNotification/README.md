Notificações com NotificationCompat. Push Message Android - Parte 2




Opa, blz?

Dando continuidade a série de vídeos sobre Push Message no Android, nesse vídeo apresento algumas maneiras de utilizar a feature de notificações no Android, mais precisamente a classe NotificationCompat, que nos permite trabalhar da mesma forma (em termos de código) na API 21 ou superior quanto em APIs mais antigas.

Notification é uma entidade importante quando utilizando serviços de push message, pois muitas vezes a existência do push message é apenas para informar sobre conteúdo novo disponível, porém para informar é necessário o Notification que printa parte da informação na status bar do device (ou notification area). Além de trabalhar junto ao serviço de push message, o Notification também pode ser utilizado para serviços de stream, como no uso de arquivos mp3 com o MediaPlayer, vinculado a um service. O Notification nesse caso permitiria que o controle do audio fosse utilizado no área de notificações quando a tela estivesse não na lock screen e também quando em lock screen. Como apresentado também no vídeo, é possível utilizar até três action buttons junto a notification com o intuito de adiantar tarefas no background, os action buttons têm principalmente essa funcionalidade, permitir o user realizar tarefas frequentes (ou urgentes para a continuidade da tarefa atual em tela, por exemplo) com apenas um clique e sem a necessidade de abrir um Activity para isso.

No vídeo é apresentado como trabalhar com uma pilha virtual de Activities (utilizando a TaskStackBuilder), que mesmo não aparentando, tem uma importância alta na definição de Activities que vão além da Activity principal da APP na chamada via Notification e não são construídas no AndroidManifest.xml como Activities "especiais" (abertas apenas via Notification). Pois a pilha virtual permiti que o caminho normal seguido pelo user para abrir a Activity (quando entrando pela APP via home screen icon) ainda seja utilizado, porém utilizado na volta da Activity, tendo em mente que ela foi aberta diretamente via Notification. Apresento também a interface da Notification com o progress para download / upload de conteúdo e também como utilizar layouts personalizados como RemoteViews.

No vídeo busco apresentar somente o push message ativando o Notification e as várias formas de utilizar o Notification (mesmo que ainda tendo mais formas), logo a aplicação das entidades de push message e Notification ainda não estão em um contexto, por exemplo: um APP Android de mensagens instataneas. A contextualização das features vai vir com vídeos futuros da série. Sem mais delongas vou deixar você assistir ao vídeo.

Bugs. : aparentemente o bug do atributo excludeFromRecents ainda não foi resolvido. O problema do script de visibilidade de notificação aparentemente também é um bug, mas esse não encontrei nada relatado que realmente é um bug, logo no próximo vídeo provavelmente vai ter a correção dele.

GitHub do projeto: https://github.com/viniciusthiengo/push-message-serie

GitHub da parte Web do projeto: https://github.com/viniciusthiengo/push-message-serie-web

Segue link da PlayList da série:

Push Messages Android

https://www.youtube.com/watch?v=Wo4lZ72NNN4&list=PLBA57K2L2RII4K3RpWuWsLaCCyPTBb1gw

Segue links das páginas utilizadas na construção do vídeo:

Página da classe NotificationCompat.Builder

http://developer.android.com/reference/android/support/v4/app/NotificationCompat.Builder.html

Página tutorial de implementação de Notification, na documentação do Android

http://developer.android.com/guide/topics/ui/notifiers/notifications.html

Página de Design Notification a partir do Material Design

http://developer.android.com/design/patterns/notifications.html

Página de Design Notification abaixo do Material Design

http://developer.android.com/design/patterns/notifications_k.html

Página documentação dos atributos da tag <activity>

http://developer.android.com/guide/topics/manifest/activity-element.html

Material Design Icons

https://materialdesignicons.com/

Página de referência dos atributos do lado servidor no script de comunicação via push message GCM

https://developers.google.com/cloud-messaging/server-ref

Página / resposta no stackoverflow com implementação dos scripts de Vibrate, Sound e LED no Notification

http://stackoverflow.com/a/18253601/2578331

Vlw