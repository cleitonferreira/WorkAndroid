Utilizando Transitions, Material Design Android - Parte 10





Opa, blz?

Nesse vídeo 10 da série Material Design no Android apresento a Framework Transition que foi inserida na API 19 (KitKat) do Android.

Simples de utilizar e abstraindo muito do trabalho pesado que o programador deveria fazer, a Framework Transition nos permite utilizar três caminhos distintos para transições em nossas APPs Android:

1 - De Activity / Fragment para Activity / Fragment, sem elementos compartilhados;

2 - De Activity / Fragment para Activity / Fragment, com elementos compartilhados;

3 - Dentro da mesma entidade (Activity / Fragment), porém com o conteúdo recebendo a animação de um ou mais transitions (TransitionManager definido explicitamente no código);

Essa mudança de entidade ou de conteúdo é conhecida na codificação como mudança de cenário (scene). Com a leitura da documentação da classe TransitionManager no site do Android podemos concluir que a mudança de propriedade de views sem a mudança de Activity / Fragment também é considerada uma mudança de scene.

A Transition (classes que herdam dela) têm duas principais responsabilidades: 1ª) saber todas as propriedades de ínicio e fim de animação das views que serão animadas; 2ª) utilizar essas propriedades para montar a anmação que será utilizada na transição de cenários. O TransitionManager controla (ou administra) um conjunto de transições, porém como comentado no vídeo, não cheguei a informação de que essa entidade também executa no background quando estamos utilizando setSharedElement*() e sia, se souber, sinta-se livre para compartilhar nos comentários.

No vídeo utilizei as implementações de transições nativas do Android (Explode, Slide, Fade, ChangeBounds, ChangeScroll). Note que apesar da introdução da framework de transição na API 19 e de algumas libs de suporte de transitions para APIs anteriores, ficamos apenas com a implementação a partir da API 21, pois alguns dos métodos importantes de transição foram inseridos somente a partir da API 21 e as libs que foram encontradas para suporte a transitions em APIs abaixo da 21 deixaram a desejar devido a não implementação de transitions entre Activities e Fragments. Então é isso, sem mais delongas vou deixá-lo assistir ao vídeo.

Obs. : fique atento quanto a implementação de transitions com shared elements (elementos compartilhados), pois essa é a parte interessante dessa framework.

O link para download do projeto se encontra logo abaixo no post.

Segue link para assistir a todos os vídeos da série sobre Material Design no Android:

YouTube PlayList: Material Design

Segue links apresentados no vídeo:

Página de transitions no guideline do Material Design Android

http://www.google.com/design/spec/animation/meaningful-transitions.html

Área de implementação de transitions no Android Material Design

https://developer.android.com/training/material/animations.html#Transitions

Post 1 do Blog Android Design Pattners de Alex Lockwood

http://www.androiddesignpatterns.com/2014/12/activity-fragment-transitions-in-android-lollipop-part1.html

Página de explicação de como ocorre as transitions no Android, no GitHub

https://github.com/lgvalle/Material-Animations

Página com GIFs animados de transitions no Android (bom para ver algumas possibilidades), no GitHub

https://github.com/saulmm/Android-Material-Examples

Post do Blog de Lucas Rocha falando sobre como funciona a Transition Framework no Android

http://lucasr.org/2014/03/13/how-android-transitions-work/

Página da classe abstrata Transition no site de documentação do Android

http://lucasr.org/2014/03/13/how-android-transitions-work/

Página da classe TransitionManager no site de documentação do Android

https://developer.android.com/reference/android/transition/Transition.html

Página da classe ActivityOptionsCompat no site de documentação do Android

https://developer.android.com/reference/android/transition/TransitionManager.html

Página da classe abstrata Window no site de documentação do Android

https://developer.android.com/reference/android/support/v4/app/ActivityOptionsCompat.html

Para fechar, assista aos vídeos do SlideNerd sobre Transitions no Android:

http://developer.android.com/reference/android/view/Window.html

SlideNerd Transitions

https://www.youtube.com/watch?v=K3yMV5am-Xo&index=53&list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD

Vlw