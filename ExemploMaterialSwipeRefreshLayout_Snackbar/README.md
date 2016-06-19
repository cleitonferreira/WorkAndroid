SwipeRefreshLayout e Snackbar, Material Design Android - Parte 9




Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre o Material Design no Android, dessa vez abordando duas entidades, SwipeRefreshLayout e Snackbar no Android. O SwipeRefreshLayout � uma forma leve e simples de informar ao user que algo est� acontecendo no background da APP, no caso o carregamento de novo conte�do ou da atualiza��o do conte�do j� apresentado na tela. Bom ficar atento que n�o utilizamos o Swipe no meio ou no bottom do layout, sempre no topo. O SwipeRefreshLayout j� vem incluso na lib de support-v4. Note que enquanto n�o � implementado um script de conex�o para obtermos os dados de um server Web vou continuar colocando scripts locais de inser��o de dados para simular as entidades. por�m a migra��o � simples e envolvendo codifica��o apenas para a lib de conex�o.

O Snackbar � um padr�o de notifica��o do Material Design no Android. Muito similar a lib Crouton, por�m com espa�amentos no padr�o do Material Design. Diferente do SwipeRefreshLayout o Snackbar n�o tem j� uma view pronta para ser utilizada, no caso utilizamos alguma das libs dispon�veis por terceiros ou montamos a nossa. No v�deo utilizei a lib nispok.snackbar que al�m de f�cil foi a mais customiz�vel que encontrei. Note que com a apresenta��o do Snackbar, segundo o guideline do Material Design, n�s n�o podemos remover nem mesmo sobrepor o FloatingActionButton e sim move-lo para cima, no caso utilize o ObjectAnimator que � um conte�do j� abordado aqui no Blog. Bom, sem mais delongas vou deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Segue links dos v�deos que podem ajudar no melhor entendimento desse v�deo:

Fonts Personalizadas no Android Com a Classe Typeface

ObjectAnimator no Android, Aplicando Efeitos nos Componentes Visuais

Segue link da PlayList da s�rie Material Design no Android:

PlayList Material Design Android

Segue links das p�ginas apresentadas no v�deo:

P�gina do Snackbar e Toast no guideline do Material Design Android

http://www.google.com/design/spec/components/snackbars-toasts.html

P�gina do SwipeRefreshLayout no guideline do Material Design Android

http://www.google.com/design/spec/patterns/swipe-to-refresh.html

P�gina do SwipeRefreshLayout no site de documenta��o do Android

https://developer.android.com/reference/android/support/v4/widget/SwipeRefreshLayout.html

P�gina da lib nispok.snackbar no GitHub

https://github.com/nispok/snackbar

Vlw