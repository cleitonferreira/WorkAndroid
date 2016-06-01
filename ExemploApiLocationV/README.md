Busca Por Locais Pr�ximos, Location API Android - Parte 5





Opa, blz?

Nesse v�deo mostro uma implementa��o de um script de busca de locais mais pr�ximos, o core do script � implementado no backend com o PHP e o MySQL (muito mais o MySQL), por�m como estamos com o Android sendo o principal cliente dessa feature, uma boa parte do c�digo est� no Android para permitir a solicita��o dos locais mais pr�ximos e o tratamento da resposta. No v�deo mostro a utiliza��o da classe WeakReference que nos permite ainda utilizar a referencia de nossa Activity, por�m n�o bloqueando o Garbage Collector de destru�-la caso n�o haja mais referencias fortes a ela. � muito importante que voc� saiba do problema que pode ter na mem�ria dispon�vel para sua APP se estiver utilizando classes internas que t�m o processamento longo dentro de Threads de background, isso evita a remo��o do objeto de sua Activity caso n�o esteja utilizando a inner class da maneira correta e sua APP tenha sofrido algum evento que chamou a reconstru��o da Activity (mudan�a na orienta��o do device, por exemplo).

O C�lculo utilizado na constru��o do resultado da busca por locais mais pr�ximos � o mesmo da resposta de Paulo Rodrigues nessa discuss�o do stackoverflow: Como obter dist�ncia dadas as coordenadas usando SQL?

http://pt.stackoverflow.com/users/4337/paulo-rodrigues

http://pt.stackoverflow.com/questions/9128/como-obter-dist%C3%A2ncia-dadas-as-coordenadas-usando-sql

Com esse post finalizo a s�rie do Location API no Android. Sem mais delongas vou deixar voc� assistir ao v�deo.

Obs. : tente se poss�vel deixar todo o filtro de resultado (n�o somente no caso de busca por locais) no banco de dados, ele foi constru�do para tamb�m lidar com filtros eficiente mesmo quando muito complexos.

O link para download do projeto, incluindo arquivos PHP, se encontra logo abaixo no post.

Os links dos v�deos anteriores da s�rie est�o na sess�o "Relacionado" logo abaixo no post.

Segue links de posts que podem lhe ajudar a compreender melhor as entidades sendo utilizadas no v�deo:

Parser JSON no Android, Entendendo e Utilizando

AsyncTask no Android, Acesso a Thread Principal de Forma Otimizada

Para uma melhor compreens�o do WeakReference veja esse link: Understanding Weak References

https://weblogs.java.net/blog/2006/05/04/understanding-weak-references

Recomendo tamb�m a leitura do livro "Efficient Android Threading" de Anders Goransson que al�m de muitos assuntos interessantes discutidos no livro tem uma abordagem muito boa sobre WeakReference class.

http://www.thiengo.com.br/efficient-android-threading

Vlw