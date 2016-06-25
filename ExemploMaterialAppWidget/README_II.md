APP Invites Para Compartilhamento. Material Design Android - Parte 15





Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre Material Design no Android, porém o conteúdo desse vídeo não é exclusivo nem novo devido ao Material Design, APP Invites é um conteúdo novo no Android (está em fase Beta), porém não dependente de Material Design, entrou nessa série devido a APP que estamos desenvolvendo com o Material Design ser também utilizada na implementação do APP Invites.

O APP Invites da a nós developers Android um poder de compartilhamento maior que os já conhecidos com as libs de redes sociais, permitindo que os users da APP compartilhem o conteúdo diretamente na caixa de entrada de email dos contatos deles ou até mesmo via SMS (que provavelmente tem um impacto maior, apesar de o gasto ser mais elevado). Apesar de na documentação está constando como versão beta a APP Invites funcionou 100% com versões do Android abaixo e igual a API 21. A possibilidade de utilizarmos o Deep Link também deixa o compartilhamento via APP Invites ainda mais preciso em relação ao conteúdo da APP. 



Quanto as configurações, é ficar atento a meta-tag necessária para a utilização do Google Play Services (esse é necessário), as configurações tanto no gradle app-level como no top-level (comento melhor no vídeo sobre isso) e ao arquivo google-services.json que devemos gerar utilizando a SHA1 de nosso projeto Android. Note que a SHA1 utilizada nesse projeto de exemplo foi a SHA1 do arquivo keystore de debug, porém no vídeo falo sobre as mudanças necessárias para utilizar a SHA1 de seu projeto caso já o tenha assinado ou queira assiná-lo para disponibilizá-lo na Play Store. Feitas as configurações os próximos passos são tranquilos, quase sempre utilizando a entidade AppInviteReferrer para processamento da Intent utilizada nas comunicações via mensagens Boradcast. Sem mais delongas vou deixar você assistir ao vídeo.


Abaixo segue link do vídeo sobre BroadcastReceiver que pode ajudar no entendimento do vídeo acima:

BroadcastReceiver no Android, Executando Tarefas no Background

http://www.thiengo.com.br/broadcastreceiver-no-android-executando-tarefas-no-background

Abaixo seguem os links das páginas apresentadas no vídeo:

Página da APP Invites Android Beta

https://developers.google.com/app-invites/android/

Stackoverflow de como obter o SHA1 fingerprint no Windows

http://stackoverflow.com/questions/27609442/how-to-get-the-sha1-fingerprint-certificate-in-android-studio-for-debug-mode

Vlw