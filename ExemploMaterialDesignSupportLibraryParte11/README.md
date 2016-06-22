Design Support Library e CollapsingToolbarLayout, Material Design Android - Parte 11




Opa, blz?

Dando continuidade e série de vídeos sobre o Material Design no Android, dessa vez apresentando a lib de suporte do Material Design no Android, Android Design Support Library. No vídeo mostro três das várias entidades que é possível implementar com essa lib. Realizei a troca do script de FloatingActionMenu pelo script do FloatingActionButton da lib de suporte que já inicia com o suporte a paritr da API 7, consequentemente perddemos um pouco em customização, digo, um layout já mais robusto e pronto que a FloatingActionMenu tinha, porém nada que não podemos implementar com a nova FloatingActionButton de suporte. Os scripts de Snackbar foram também alterados pelos scripts de Snackbar da nova lib de suporte. A implementação do Snackbar de suporte ficou bem mais simples e tão eficiente quanto, somente não temos mais a opção de deixar ativa por tempo indeterminado a Snackbar, no big deal!

Finalmente, ante a implementação de libs que nos permitem criar o hide / show toolbar de maneira não muito trivial, as entidades CoordinatorLayout, AppBarLayout e CollapsingToolbarLayout, juntamente com o Toolbar, nos permitem criar um hide / show toolbar simples e somente utilizando o XML, além de ser possível a implementação de um parallax collapse mode, nada mais nada menos que aquela estilosa Toolbar que contém uma imagem e os botões de menu e StatusBar sobre um fundo transparente onde temos a imagem de baixo deles. Apesar da série de bugs encontrados (até mesmo a APP de amostra criada por um dos membros do time de developers do Android está com uma série de bugs, apresentados no vídeo - APP link) ainda sim vale a pena a migração, tendo em que as atualizações podem começar logo trazendo mais entidades tendo suporte e a correção das entidades já com suporte e bugadas.

Note que como já tinha implementado uma série das entidades que agora têm suporte e que tenho de limitar algumas abordagens durante o vídeo, optei por apresentar principalmente o Toolbar com CollapsingToolbarLayout, CoordinatorLayout e AppBarLayout e como implementação a parte o FloatingActionButton e Snackbar de suporte, as entidades DrawerNavigation e SlidingTabs vou implementando com o decorrer dos próximos vídeos devido a essas entidades já estarem implementadas (porém utilizando libs de suporte não nativas). No mais é somente isso, o vídeo ficou um pouco longo, porém acredito que vale a pena assistí-lo até o final.

O link para download do projeto se encontra logo abaixo no post, no Blog (http://www.thiengo.com.br/)

Para acompanhar a série Material Design no Android siga a PlayList:

Material Design PlayList - Blog Thiengo Calopsita

Segue os links das páginas apresentadas no vídeo:

Post sobre a Android Design Support Library no Android Developers Blog

http://android-developers.blogspot.com.br/2015/05/android-design-support-library.html

Página no GitHub da APP de apresentação das entidades suportadas no lib de suporte Android Design Support Library

https://github.com/chrisbanes/cheesesquare

Página da classe CoordinatorLayout

https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout.html

Página da classe abstrata CoordinatorLayout.Behavior

https://developer.android.com/reference/android/support/design/widget/CoordinatorLayout.Behavior.html

Página da classe AppBarLayout

https://developer.android.com/reference/android/support/design/widget/AppBarLayout.html

Página da classe CollapsingToolbarLayout

https://developer.android.com/reference/android/support/design/widget/CollapsingToolbarLayout.html

Página da classe NestedScrollView

https://developer.android.com/reference/android/support/v4/widget/NestedScrollView.html

Página que contém explicação do atributo fitSystemWindow

http://developer.android.com/reference/android/view/View.html#fitSystemWindows(android.graphics.Rect)

Vlw