Volley, Gson e RetryPolicy em Material Design Android Série APP





Opa, blz?

Nesse vídeo dou continuidade a APP da série Material Design no Android, do Blog, dessa vez implementando comunicação remota com um servidor Web no qual tem instalado a linguagem de backend PHP e o SGBD MySQL. Comunicação realizada com o suporte da lib Volley para transmissão e recebimento de ddos e da lib Gson para o parser de Json para Objeto Java e vice-versa.

Note que o objetivo do vídeo foi integrar o Volley a APP que está sendo construída na série, tendo em mente que já tem no Blog dois vídeos sobre a lib Volley, alguns outros vídeos utilizando a lib Volley, além de a documentação (apesar de estar em inglês) ser bem explicativa incluindo códigos de exemplos. Porém a integração apresentada no vídeo inclui conteúdos importantes como o RetryPolicy e o porquê de conteúdos duplicados na base de dados remota quando há um delay muito alto na resposta do servidor, além de utilizar o Volley com o padrão Singleton. Há também a utilização do JsonArrayRequest para receber e enviar dados para o Servidor Web (nesse caso é implementado um CustomRequest).

Na parte do RetryPolicy recomendo a alteração apenas do parametro do TimeOut, porém essa é apenas uma opinião minha baseada nas necessidades de projeto que já tive, você deverá alterar os parâmetros necessários de acordo com suas especificações de projetos. Note no vídeo que há uma problemática com a persistência dos fragments, até mesmo recomendo a utilização do SQLite para a possível solução. Com vídeos futuros vamos ver como corrigir isso. Ressalto que no vídeo abordo como carregar tanto dados novos como dados mais antigos no RecyclerView. No vídeo também é apresentada uma forma de realizar conexão "localhost" para utilizar uma base de dados em sua máquina ao invés de um servidor Web. Sem mais delongas vou deixar você assistir ao vídeo.

Segue link para download / fork do projeto no GitHub: https://github.com/viniciusthiengo/tc-material-design

Segue link da série Material Design no Android:

Série Material Design, YouTube channel

Links dos vídeos / post sobre o Volley Android recomendados pelo Blog:

Transmitting Network Data Using Volley

http://developer.android.com/intl/zh-cn/training/volley/index.html

Volley no Android, Entendendo e Utilizando

http://www.thiengo.com.br/volley-no-android-entendendo-e-utilizando

Android working with Volley Library - AndroidHive

http://www.androidhive.info/2014/05/android-working-with-volley-library-1/

GitHub Volley-Demo (bom RetryPolicy content)

https://github.com/smanikandan14/Volley-demo

Stackoverflow com implementação de uma CustomRequest para utilizar JsonArrayRequest / JsonObjectRequest com envio de dados no Volley Android

http://stackoverflow.com/questions/19837820/volley-jsonobjectrequest-post-request-not-working/19945676#19945676

Segue links das libs via Maven, Volley e Gson:

Android Volley GitHub lib

https://github.com/mcxiaoke/android-volley

Maven Gson

http://mvnrepository.com/artifact/com.google.code.gson/gson/2.3.1

Caso queira se aventurar no SQLite para já adiantar uma possível solução para o problema de persistência dos conteúdos dos fragments, veja o vídeo SQLite no Android, Entendendo e Utilizando disponível no Blog.

Vlw