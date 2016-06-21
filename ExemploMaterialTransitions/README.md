Utilizando Transitions, Material Design Android - Parte 10





Opa, blz?

Nesse v�deo 10 da s�rie Material Design no Android apresento a Framework Transition que foi inserida na API 19 (KitKat) do Android.

Simples de utilizar e abstraindo muito do trabalho pesado que o programador deveria fazer, a Framework Transition nos permite utilizar tr�s caminhos distintos para transi��es em nossas APPs Android:

1 - De Activity / Fragment para Activity / Fragment, sem elementos compartilhados;

2 - De Activity / Fragment para Activity / Fragment, com elementos compartilhados;

3 - Dentro da mesma entidade (Activity / Fragment), por�m com o conte�do recebendo a anima��o de um ou mais transitions (TransitionManager definido explicitamente no c�digo);

Essa mudan�a de entidade ou de conte�do � conhecida na codifica��o como mudan�a de cen�rio (scene). Com a leitura da documenta��o da classe TransitionManager no site do Android podemos concluir que a mudan�a de propriedade de views sem a mudan�a de Activity / Fragment tamb�m � considerada uma mudan�a de scene.

A Transition (classes que herdam dela) t�m duas principais responsabilidades: 1�) saber todas as propriedades de �nicio e fim de anima��o das views que ser�o animadas; 2�) utilizar essas propriedades para montar a anma��o que ser� utilizada na transi��o de cen�rios. O TransitionManager controla (ou administra) um conjunto de transi��es, por�m como comentado no v�deo, n�o cheguei a informa��o de que essa entidade tamb�m executa no background quando estamos utilizando setSharedElement*() e sia, se souber, sinta-se livre para compartilhar nos coment�rios.

No v�deo utilizei as implementa��es de transi��es nativas do Android (Explode, Slide, Fade, ChangeBounds, ChangeScroll). Note que apesar da introdu��o da framework de transi��o na API 19 e de algumas libs de suporte de transitions para APIs anteriores, ficamos apenas com a implementa��o a partir da API 21, pois alguns dos m�todos importantes de transi��o foram inseridos somente a partir da API 21 e as libs que foram encontradas para suporte a transitions em APIs abaixo da 21 deixaram a desejar devido a n�o implementa��o de transitions entre Activities e Fragments. Ent�o � isso, sem mais delongas vou deix�-lo assistir ao v�deo.

Obs. : fique atento quanto a implementa��o de transitions com shared elements (elementos compartilhados), pois essa � a parte interessante dessa framework.

O link para download do projeto se encontra logo abaixo no post.

Segue link para assistir a todos os v�deos da s�rie sobre Material Design no Android:

YouTube PlayList: Material Design

Segue links apresentados no v�deo:

P�gina de transitions no guideline do Material Design Android

http://www.google.com/design/spec/animation/meaningful-transitions.html

�rea de implementa��o de transitions no Android Material Design

https://developer.android.com/training/material/animations.html#Transitions

Post 1 do Blog Android Design Pattners de Alex Lockwood

http://www.androiddesignpatterns.com/2014/12/activity-fragment-transitions-in-android-lollipop-part1.html

P�gina de explica��o de como ocorre as transitions no Android, no GitHub

https://github.com/lgvalle/Material-Animations

P�gina com GIFs animados de transitions no Android (bom para ver algumas possibilidades), no GitHub

https://github.com/saulmm/Android-Material-Examples

Post do Blog de Lucas Rocha falando sobre como funciona a Transition Framework no Android

http://lucasr.org/2014/03/13/how-android-transitions-work/

P�gina da classe abstrata Transition no site de documenta��o do Android

http://lucasr.org/2014/03/13/how-android-transitions-work/

P�gina da classe TransitionManager no site de documenta��o do Android

https://developer.android.com/reference/android/transition/Transition.html

P�gina da classe ActivityOptionsCompat no site de documenta��o do Android

https://developer.android.com/reference/android/transition/TransitionManager.html

P�gina da classe abstrata Window no site de documenta��o do Android

https://developer.android.com/reference/android/support/v4/app/ActivityOptionsCompat.html

Para fechar, assista aos v�deos do SlideNerd sobre Transitions no Android:

http://developer.android.com/reference/android/view/Window.html

SlideNerd Transitions

https://www.youtube.com/watch?v=K3yMV5am-Xo&index=53&list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD

Vlw