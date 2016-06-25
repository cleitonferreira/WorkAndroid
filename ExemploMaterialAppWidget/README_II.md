APP Invites Para Compartilhamento. Material Design Android - Parte 15





Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre Material Design no Android, por�m o conte�do desse v�deo n�o � exclusivo nem novo devido ao Material Design, APP Invites � um conte�do novo no Android (est� em fase Beta), por�m n�o dependente de Material Design, entrou nessa s�rie devido a APP que estamos desenvolvendo com o Material Design ser tamb�m utilizada na implementa��o do APP Invites.

O APP Invites da a n�s developers Android um poder de compartilhamento maior que os j� conhecidos com as libs de redes sociais, permitindo que os users da APP compartilhem o conte�do diretamente na caixa de entrada de email dos contatos deles ou at� mesmo via SMS (que provavelmente tem um impacto maior, apesar de o gasto ser mais elevado). Apesar de na documenta��o est� constando como vers�o beta a APP Invites funcionou 100% com vers�es do Android abaixo e igual a API 21. A possibilidade de utilizarmos o Deep Link tamb�m deixa o compartilhamento via APP Invites ainda mais preciso em rela��o ao conte�do da APP. 



Quanto as configura��es, � ficar atento a meta-tag necess�ria para a utiliza��o do Google Play Services (esse � necess�rio), as configura��es tanto no gradle app-level como no top-level (comento melhor no v�deo sobre isso) e ao arquivo google-services.json que devemos gerar utilizando a SHA1 de nosso projeto Android. Note que a SHA1 utilizada nesse projeto de exemplo foi a SHA1 do arquivo keystore de debug, por�m no v�deo falo sobre as mudan�as necess�rias para utilizar a SHA1 de seu projeto caso j� o tenha assinado ou queira assin�-lo para disponibiliz�-lo na Play Store. Feitas as configura��es os pr�ximos passos s�o tranquilos, quase sempre utilizando a entidade AppInviteReferrer para processamento da Intent utilizada nas comunica��es via mensagens Boradcast. Sem mais delongas vou deixar voc� assistir ao v�deo.


Abaixo segue link do v�deo sobre BroadcastReceiver que pode ajudar no entendimento do v�deo acima:

BroadcastReceiver no Android, Executando Tarefas no Background

http://www.thiengo.com.br/broadcastreceiver-no-android-executando-tarefas-no-background

Abaixo seguem os links das p�ginas apresentadas no v�deo:

P�gina da APP Invites Android Beta

https://developers.google.com/app-invites/android/

Stackoverflow de como obter o SHA1 fingerprint no Windows

http://stackoverflow.com/questions/27609442/how-to-get-the-sha1-fingerprint-certificate-in-android-studio-for-debug-mode

Vlw