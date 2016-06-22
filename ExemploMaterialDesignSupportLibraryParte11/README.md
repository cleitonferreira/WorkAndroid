Design Support Library e CollapsingToolbarLayout, Material Design Android - Parte 11




Opa, blz?

Dando continuidade e s�rie de v�deos sobre o Material Design no Android, dessa vez apresentando a lib de suporte do Material Design no Android, Android Design Support Library. No v�deo mostro tr�s das v�rias entidades que � poss�vel implementar com essa lib. Realizei a troca do script de FloatingActionMenu pelo script do FloatingActionButton da lib de suporte que j� inicia com o suporte a paritr da API 7, consequentemente perddemos um pouco em customiza��o, digo, um layout j� mais robusto e pronto que a FloatingActionMenu tinha, por�m nada que n�o podemos implementar com a nova FloatingActionButton de suporte. Os scripts de Snackbar foram tamb�m alterados pelos scripts de Snackbar da nova lib de suporte. A implementa��o do Snackbar de suporte ficou bem mais simples e t�o eficiente quanto, somente n�o temos mais a op��o de deixar ativa por tempo indeterminado a Snackbar, no big deal!

Finalmente, ante a implementa��o de libs que nos permitem criar o hide / show toolbar de maneira n�o muito trivial, as entidades CoordinatorLayout, AppBarLayout e CollapsingToolbarLayout, juntamente com o Toolbar, nos permitem criar um hide / show toolbar simples e somente utilizando o XML, al�m de ser poss�vel a implementa��o de um parallax collapse mode, nada mais nada menos que aquela estilosa Toolbar que cont�m uma imagem e os bot�es de menu e StatusBar sobre um fundo transparente onde temos a imagem de baixo deles. Apesar da s�rie de bugs encontrados (at� mesmo a APP de amostra criada por um dos membros do time de developers do Android est� com uma s�rie de bugs, apresentados no v�deo - APP link) ainda sim vale a pena a migra��o, tendo em que as atualiza��es podem come�ar logo trazendo mais entidades tendo suporte e a corre��o das entidades j� com suporte e bugadas.

Note que como j� tinha implementado uma s�rie das entidades que agora t�m suporte e que tenho de limitar algumas abordagens durante o v�deo, optei por apresentar principalmente o Toolbar com CollapsingToolbarLayout, CoordinatorLayout e AppBarLayout e como implementa��o a parte o FloatingActionButton e Snackbar de suporte, as entidades DrawerNavigation e SlidingTabs vou implementando com o decorrer dos pr�ximos v�deos devido a essas entidades j� estarem implementadas (por�m utilizando libs de suporte n�o nativas). No mais � somente isso, o v�deo ficou um pouco longo, por�m acredito que vale a pena assist�-lo at� o final.

O link para download do projeto se encontra logo abaixo no post, no Blog (http://www.thiengo.com.br/)

Para acompanhar a s�rie Material Design no Android siga a PlayList:

Material Design PlayList - Blog Thiengo Calopsita

Segue os links das p�ginas apresentadas no v�deo:

Post sobre a Android Design Support Library no Android Developers Blog

http://android-developers.blogspot.com.br/2015/05/android-design-support-library.html

P�gina no GitHub da APP de apresenta��o das entidades suportadas no lib de suporte Android Design Support Library

https://github.com/chrisbanes/cheesesquare

P�gina da classe CoordinatorLayout

https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout.html

P�gina da classe abstrata CoordinatorLayout.Behavior

https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout.Behavior.html

P�gina da classe AppBarLayout

https://developer.android.com/reference/android/support/design/widget/AppBarLayout.html

P�gina da classe CollapsingToolbarLayout

https://developer.android.com/reference/android/support/design/widget/CollapsingToolbarLayout.html

P�gina da classe NestedScrollView

https://developer.android.com/reference/android/support/v4/widget/NestedScrollView.html

P�gina que cont�m explica��o do atributo fitSystemWindow

http://developer.android.com/reference/android/view/View.html#fitSystemWindows(android.graphics.Rect)

Vlw