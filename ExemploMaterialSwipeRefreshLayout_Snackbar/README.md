SwipeRefreshLayout e Snackbar, Material Design Android - Parte 9




Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre o Material Design no Android, dessa vez abordando duas entidades, SwipeRefreshLayout e Snackbar no Android. O SwipeRefreshLayout é uma forma leve e simples de informar ao user que algo está acontecendo no background da APP, no caso o carregamento de novo conteúdo ou da atualização do conteúdo já apresentado na tela. Bom ficar atento que não utilizamos o Swipe no meio ou no bottom do layout, sempre no topo. O SwipeRefreshLayout já vem incluso na lib de support-v4. Note que enquanto não é implementado um script de conexão para obtermos os dados de um server Web vou continuar colocando scripts locais de inserção de dados para simular as entidades. porém a migração é simples e envolvendo codificação apenas para a lib de conexão.

O Snackbar é um padrão de notificação do Material Design no Android. Muito similar a lib Crouton, porém com espaçamentos no padrão do Material Design. Diferente do SwipeRefreshLayout o Snackbar não tem já uma view pronta para ser utilizada, no caso utilizamos alguma das libs disponíveis por terceiros ou montamos a nossa. No vídeo utilizei a lib nispok.snackbar que além de fácil foi a mais customizável que encontrei. Note que com a apresentação do Snackbar, segundo o guideline do Material Design, nós não podemos remover nem mesmo sobrepor o FloatingActionButton e sim move-lo para cima, no caso utilize o ObjectAnimator que é um conteúdo já abordado aqui no Blog. Bom, sem mais delongas vou deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Segue links dos vídeos que podem ajudar no melhor entendimento desse vídeo:

Fonts Personalizadas no Android Com a Classe Typeface

ObjectAnimator no Android, Aplicando Efeitos nos Componentes Visuais

Segue link da PlayList da série Material Design no Android:

PlayList Material Design Android

Segue links das páginas apresentadas no vídeo:

Página do Snackbar e Toast no guideline do Material Design Android

http://www.google.com/design/spec/components/snackbars-toasts.html

Página do SwipeRefreshLayout no guideline do Material Design Android

http://www.google.com/design/spec/patterns/swipe-to-refresh.html

Página do SwipeRefreshLayout no site de documentação do Android

https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html

Página da lib nispok.snackbar no GitHub

https://github.com/nispok/snackbar

Vlw