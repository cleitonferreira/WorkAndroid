Busca Por Locais Próximos, Location API Android - Parte 5





Opa, blz?

Nesse vídeo mostro uma implementação de um script de busca de locais mais próximos, o core do script é implementado no backend com o PHP e o MySQL (muito mais o MySQL), porém como estamos com o Android sendo o principal cliente dessa feature, uma boa parte do código está no Android para permitir a solicitação dos locais mais próximos e o tratamento da resposta. No vídeo mostro a utilização da classe WeakReference que nos permite ainda utilizar a referencia de nossa Activity, porém não bloqueando o Garbage Collector de destruí-la caso não haja mais referencias fortes a ela. É muito importante que você saiba do problema que pode ter na memória disponível para sua APP se estiver utilizando classes internas que têm o processamento longo dentro de Threads de background, isso evita a remoção do objeto de sua Activity caso não esteja utilizando a inner class da maneira correta e sua APP tenha sofrido algum evento que chamou a reconstrução da Activity (mudança na orientação do device, por exemplo).

O Cálculo utilizado na construção do resultado da busca por locais mais próximos é o mesmo da resposta de Paulo Rodrigues nessa discussão do stackoverflow: Como obter distância dadas as coordenadas usando SQL?

http://pt.stackoverflow.com/users/4337/paulo-rodrigues

http://pt.stackoverflow.com/questions/9128/como-obter-dist%C3%A2ncia-dadas-as-coordenadas-usando-sql

Com esse post finalizo a série do Location API no Android. Sem mais delongas vou deixar você assistir ao vídeo.

Obs. : tente se possível deixar todo o filtro de resultado (não somente no caso de busca por locais) no banco de dados, ele foi construído para também lidar com filtros eficiente mesmo quando muito complexos.

O link para download do projeto, incluindo arquivos PHP, se encontra logo abaixo no post.

Os links dos vídeos anteriores da série estão na sessão "Relacionado" logo abaixo no post.

Segue links de posts que podem lhe ajudar a compreender melhor as entidades sendo utilizadas no vídeo:

Parser JSON no Android, Entendendo e Utilizando

AsyncTask no Android, Acesso a Thread Principal de Forma Otimizada

Para uma melhor compreensão do WeakReference veja esse link: Understanding Weak References

https://weblogs.java.net/blog/2006/05/04/understanding-weak-references

Recomendo também a leitura do livro "Efficient Android Threading" de Anders Goransson que além de muitos assuntos interessantes discutidos no livro tem uma abordagem muito boa sobre WeakReference class.

http://www.thiengo.com.br/efficient-android-threading

Vlw