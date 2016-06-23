Lib Fresco Para Carregamento de Imagens (com GIFs e WebPs Animados). Material Design Android - Parte 12




Opa, blz?

Nesse vídeo apresento a lib Fresco para carregamento de imagens no Android. Liberada a pouco pelo Facebook essa lib tem como principal diferencial a administração de bitmaps em cache utilizando uma heap que não é acessada pelo Garbage Collector do Java, mais precisamente a heap ashmem, isso para versões anteriores a API 21, pois segundo o post de apresentação da lib, muitas das partes ineficazes de administração de cache das versões 4.x ou abaixo foram solucionadas a partir da API 21. Essa administração eficiente da memória / cache faz com que a lib Fresco fique menos propícia a gerar um OutOfMemoryError. A lib tem suporte a partir da API 9 e não é uma lib do Material Design, apenas foi abordada nessa série do Blog.

Antes de utilizar a lib Fresco eu estava rodando alguns testes com a lib Glide, que mesmo seguindo o passo-a-passo da documentação não conseguia parar com a série de OutOfMemoryError, isso baixando imagens em torno de 30 a 50 Kb.

Além da administração diferenciada da memória do device para com o uso de imagens, a lib Fresco traz uma série de features como por exemplo o arredondamento de bordas da imagem, a apresentação com a animação de fadeIn (não busquei se é possível fornecer uma animação personalizada, muito provavelmente sim), a aplicação de filtro com cor na imagem e a execução de animações de imagens no formato .GiF e .WEBP. Para trabalhar com a requisição, carregamento e apresentação da imagem a lib utiliza o padrão MVC onde a entidade DraweeView é responsável por realizar a requisição e a apresentação da Imagem (ou imagens, tendo em mente que podem ser difinidas as imagens de placeholder, erro, retentativa e imagens de background) trabalhando como sendo a View do padrão. A interface DraweeHierarchy trabalha como sendo a entidade que renderiza o conteúdo em DraweeView podendo alterar algumas caracteristicas de apresentação, como as bordas arredondadas, sendo assim o Model do padrão. E por fim temos o DraweeController que fica com o trabalho de gerenciar o carregamento da imagem da memória, network, local,... mais precisamente de se comunicar com o Pipeline que realiza todo esse trabalho de cache e load de imagem. No vídeo mostro a utilização das três entidades, muito mais a utilização do DraweeControler e do DraweeView por meio da entidade SimpleDraweeView.

Voltando ao Pipeline, o que ele faz é: obtendo uma requisicão, verificar se na cache de bitmap há a imagem solicitada, essa cache é a heap ashmem quando em versões 4.x ou abaixo, no Android. Caso a imagem esteja na cache de bitmaps, retorne ela sem a necessidade de decodificação, pois na cache de bitmaps as entidades são salvas de forma não comprimidas. Se não houver uma correspondência da imagem na cache de bitmaps o Pipeline vai para a cache de memória, encontrando uma correspondência a entidade é decodificada e enviada ara ser salva na cache de bitmap, e então enviada para ser apresentada no DraweeView. Se mesmo na cache de memória não houver uma correspondência da imagem, então o pipeline verifica a cache de disco, essa é a única das caches que persiste depois que a APP não está sendo mais utilizada, ou seja, foi para o background ou até mesmo foi removida da parte da memória de APPs em execução. Encontrando uma correspondência na cache de disco essa é decodificada, enviada para ser salva na cache de memória, logo após na cache de bitmap e então para ser apresentada na DraweeView. Caso nem mesmo na cache de disco tenha uma correspondência então a imagem é baixada da internet ou acessada em algum local do device (folder assets, raw, sdcard).

Bom é isso, se estiver utilizando qualquer uma das outras libs de carregamento de imagem recomendo que migre para o Fresco que tem suporte a partir da API 9. O carregamento de imagens em sua APP tende a ficar mais confiavel quanto ao não problema com OutOfMemoryError. Leia os links do Fresco e do IOSched que apresento na vídeo e deixo logo abaixo, pois eles vão complementar com segurança o conteúdo do vídeo. Dê muita atenção ao conteúdo do post do IOSched no GitHub, pois nele tem uma maneira / lógica de trabalhar com folders no servidor como se fossem os folders drawable do Android. Algo interessante é como são criadas as cópias de diferentes tamanhos da imagem updada no servidor deles, ao invés de realizar esse processo logo no envio da imagem ao servidor (um user realizando um cadastro com foto, por exemplo), o que é feito é que a imagem é salva e somente depois um script que é chamado pelo "crontab" do linux é que é realizado o processo de replicação da imagem pelos outros folders do servidor, permitindo então que um script de verificação de tamanho de imagem no Andorid consiga baixar as imagens do folder correto no servidor.

O link para download do projeto se entcontra logo abaixo no post.

Para assistir aos outros vídeos da série Material Design no Android, siga a PlayList abaixo:

Material Design no Android

Segue os links apresentados no vídeo:

Página da lib Fresco

http://frescolib.org/

Post no Facebook Blog sobre a lib Fresco

https://code.facebook.com/posts/366199913563917

Página do IOSched no GitHub apresentando uma lógica de armazenamento de imagens no Servidor para posterior carregamento em APPs Android

https://github.com/google/iosched/blob/master/doc/IMAGES.md

Post no Stackoverflow de discussão sobre Picasso Lib, ImageLoader Volley, Glide e Fresco no Android

http://stackoverflow.com/questions/29363321/picasso-v-s-imageloader-v-s-fresco-vs-glide

Vlw


