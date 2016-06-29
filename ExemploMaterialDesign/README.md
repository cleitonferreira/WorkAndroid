Volley, Gson e RetryPolicy em Material Design Android S�rie APP





Opa, blz?

Nesse v�deo dou continuidade a APP da s�rie Material Design no Android, do Blog, dessa vez implementando comunica��o remota com um servidor Web no qual tem instalado a linguagem de backend PHP e o SGBD MySQL. Comunica��o realizada com o suporte da lib Volley para transmiss�o e recebimento de ddos e da lib Gson para o parser de Json para Objeto Java e vice-versa.

Note que o objetivo do v�deo foi integrar o Volley a APP que est� sendo constru�da na s�rie, tendo em mente que j� tem no Blog dois v�deos sobre a lib Volley, alguns outros v�deos utilizando a lib Volley, al�m de a documenta��o (apesar de estar em ingl�s) ser bem explicativa incluindo c�digos de exemplos. Por�m a integra��o apresentada no v�deo inclui conte�dos importantes como o RetryPolicy e o porqu� de conte�dos duplicados na base de dados remota quando h� um delay muito alto na resposta do servidor, al�m de utilizar o Volley com o padr�o Singleton. H� tamb�m a utiliza��o do JsonArrayRequest para receber e enviar dados para o Servidor Web (nesse caso � implementado um CustomRequest).

Na parte do RetryPolicy recomendo a altera��o apenas do parametro do TimeOut, por�m essa � apenas uma opini�o minha baseada nas necessidades de projeto que j� tive, voc� dever� alterar os par�metros necess�rios de acordo com suas especifica��es de projetos. Note no v�deo que h� uma problem�tica com a persist�ncia dos fragments, at� mesmo recomendo a utiliza��o do SQLite para a poss�vel solu��o. Com v�deos futuros vamos ver como corrigir isso. Ressalto que no v�deo abordo como carregar tanto dados novos como dados mais antigos no RecyclerView. No v�deo tamb�m � apresentada uma forma de realizar conex�o "localhost" para utilizar uma base de dados em sua m�quina ao inv�s de um servidor Web. Sem mais delongas vou deixar voc� assistir ao v�deo.

Segue link para download / fork do projeto no GitHub: https://github.com/viniciusthiengo/tc-material-design

Segue link da s�rie Material Design no Android:

S�rie Material Design, YouTube channel

Links dos v�deos / post sobre o Volley Android recomendados pelo Blog:

Transmitting Network Data Using Volley

http://developer.android.com/intl/zh-cn/training/volley/index.html

Volley no Android, Entendendo e Utilizando

http://www.thiengo.com.br/volley-no-android-entendendo-e-utilizando

Android working with Volley Library - AndroidHive

http://www.androidhive.info/2014/05/android-working-with-volley-library-1/

GitHub Volley-Demo (bom RetryPolicy content)

https://github.com/smanikandan14/Volley-demo

Stackoverflow com implementa��o de uma CustomRequest para utilizar JsonArrayRequest / JsonObjectRequest com envio de dados no Volley Android

http://stackoverflow.com/questions/19837820/volley-jsonobjectrequest-post-request-not-working/19945676#19945676

Segue links das libs via Maven, Volley e Gson:

Android Volley GitHub lib

https://github.com/mcxiaoke/android-volley

Maven Gson

http://mvnrepository.com/artifact/com.google.code.gson/gson/2.3.1

Caso queira se aventurar no SQLite para j� adiantar uma poss�vel solu��o para o problema de persist�ncia dos conte�dos dos fragments, veja o v�deo SQLite no Android, Entendendo e Utilizando dispon�vel no Blog.

Vlw