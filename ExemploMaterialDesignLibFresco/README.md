Lib Fresco Para Carregamento de Imagens (com GIFs e WebPs Animados). Material Design Android - Parte 12




Opa, blz?

Nesse v�deo apresento a lib Fresco para carregamento de imagens no Android. Liberada a pouco pelo Facebook essa lib tem como principal diferencial a administra��o de bitmaps em cache utilizando uma heap que n�o � acessada pelo Garbage Collector do Java, mais precisamente a heap ashmem, isso para vers�es anteriores a API 21, pois segundo o post de apresenta��o da lib, muitas das partes ineficazes de administra��o de cache das vers�es 4.x ou abaixo foram solucionadas a partir da API 21. Essa administra��o eficiente da mem�ria / cache faz com que a lib Fresco fique menos prop�cia a gerar um OutOfMemoryError. A lib tem suporte a partir da API 9 e n�o � uma lib do Material Design, apenas foi abordada nessa s�rie do Blog.

Antes de utilizar a lib Fresco eu estava rodando alguns testes com a lib Glide, que mesmo seguindo o passo-a-passo da documenta��o n�o conseguia parar com a s�rie de OutOfMemoryError, isso baixando imagens em torno de 30 a 50 Kb.

Al�m da administra��o diferenciada da mem�ria do device para com o uso de imagens, a lib Fresco traz uma s�rie de features como por exemplo o arredondamento de bordas da imagem, a apresenta��o com a anima��o de fadeIn (n�o busquei se � poss�vel fornecer uma anima��o personalizada, muito provavelmente sim), a aplica��o de filtro com cor na imagem e a execu��o de anima��es de imagens no formato .GiF e .WEBP. Para trabalhar com a requisi��o, carregamento e apresenta��o da imagem a lib utiliza o padr�o MVC onde a entidade DraweeView � respons�vel por realizar a requisi��o e a apresenta��o da Imagem (ou imagens, tendo em mente que podem ser difinidas as imagens de placeholder, erro, retentativa e imagens de background) trabalhando como sendo a View do padr�o. A interface DraweeHierarchy trabalha como sendo a entidade que renderiza o conte�do em DraweeView podendo alterar algumas caracteristicas de apresenta��o, como as bordas arredondadas, sendo assim o Model do padr�o. E por fim temos o DraweeController que fica com o trabalho de gerenciar o carregamento da imagem da mem�ria, network, local,... mais precisamente de se comunicar com o Pipeline que realiza todo esse trabalho de cache e load de imagem. No v�deo mostro a utiliza��o das tr�s entidades, muito mais a utiliza��o do DraweeControler e do DraweeView por meio da entidade SimpleDraweeView.

Voltando ao Pipeline, o que ele faz �: obtendo uma requisic�o, verificar se na cache de bitmap h� a imagem solicitada, essa cache � a heap ashmem quando em vers�es 4.x ou abaixo, no Android. Caso a imagem esteja na cache de bitmaps, retorne ela sem a necessidade de decodifica��o, pois na cache de bitmaps as entidades s�o salvas de forma n�o comprimidas. Se n�o houver uma correspond�ncia da imagem na cache de bitmaps o Pipeline vai para a cache de mem�ria, encontrando uma correspond�ncia a entidade � decodificada e enviada ara ser salva na cache de bitmap, e ent�o enviada para ser apresentada no DraweeView. Se mesmo na cache de mem�ria n�o houver uma correspond�ncia da imagem, ent�o o pipeline verifica a cache de disco, essa � a �nica das caches que persiste depois que a APP n�o est� sendo mais utilizada, ou seja, foi para o background ou at� mesmo foi removida da parte da mem�ria de APPs em execu��o. Encontrando uma correspond�ncia na cache de disco essa � decodificada, enviada para ser salva na cache de mem�ria, logo ap�s na cache de bitmap e ent�o para ser apresentada na DraweeView. Caso nem mesmo na cache de disco tenha uma correspond�ncia ent�o a imagem � baixada da internet ou acessada em algum local do device (folder assets, raw, sdcard).

Bom � isso, se estiver utilizando qualquer uma das outras libs de carregamento de imagem recomendo que migre para o Fresco que tem suporte a partir da API 9. O carregamento de imagens em sua APP tende a ficar mais confiavel quanto ao n�o problema com OutOfMemoryError. Leia os links do Fresco e do IOSched que apresento na v�deo e deixo logo abaixo, pois eles v�o complementar com seguran�a o conte�do do v�deo. D� muita aten��o ao conte�do do post do IOSched no GitHub, pois nele tem uma maneira / l�gica de trabalhar com folders no servidor como se fossem os folders drawable do Android. Algo interessante � como s�o criadas as c�pias de diferentes tamanhos da imagem updada no servidor deles, ao inv�s de realizar esse processo logo no envio da imagem ao servidor (um user realizando um cadastro com foto, por exemplo), o que � feito � que a imagem � salva e somente depois um script que � chamado pelo "crontab" do linux � que � realizado o processo de replica��o da imagem pelos outros folders do servidor, permitindo ent�o que um script de verifica��o de tamanho de imagem no Andorid consiga baixar as imagens do folder correto no servidor.

O link para download do projeto se entcontra logo abaixo no post.

Para assistir aos outros v�deos da s�rie Material Design no Android, siga a PlayList abaixo:

Material Design no Android

Segue os links apresentados no v�deo:

P�gina da lib Fresco

http://frescolib.org/

Post no Facebook Blog sobre a lib Fresco

https://code.facebook.com/posts/366199913563917

P�gina do IOSched no GitHub apresentando uma l�gica de armazenamento de imagens no Servidor para posterior carregamento em APPs Android

https://github.com/google/iosched/blob/master/doc/IMAGES.md

Post no Stackoverflow de discuss�o sobre Picasso Lib, ImageLoader Volley, Glide e Fresco no Android

http://stackoverflow.com/questions/29363321/picasso-v-s-imageloader-v-s-fresco-vs-glide

Vlw


