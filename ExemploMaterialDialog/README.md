Material Dialog, Corre��o Bug StatusBar e A��es nos Fragments. Material Design Android - Parte 7





Opa, blz?

Nesse v�deo continuo com a s�rie Material Design no Android, dessa vez corrigindo alguns Bugs como o da StatusBar, colocando a��es nos cliques nos itens do RecyclerView que anteriormente apenas chamava um Toast, e por final apresento a utiliza��o de uma lib que nos permite colocar o Dialog no padr�o do Material Design (a lib � meio bugada, mas funciona).

No v�deo apresento tr�s maneiras de corrigir o problema de sobreposi��o de StatusBar quando rodando em Android com API maior ou igual a 19. A �ltima solu��o pode sim parecer a melhor (visualmente ela � a melhor), por�m n�o deixe de levar em conta o problema de dependencia grande a uma �nica lib.

Com o problema do Material Dialog, tentei corrigi-lo com diversos temas diferentes, com margin, ... mas mesmo assim aquela pequena barra no bottom n�o saiu, e quando saiu n�s perdemos as bordas rounded nas APIs abaixo da 21.

Note que nos coment�rios sobre Fragment e Parcelable passei um pouco mais r�pido, pois j� fiz v�deos sobre essas entidades (est�o abaixo no post). Ent�o � isso, sem mais delongas vou deixar voc� assistir ao v�deo.

Obs. : O bug do profile atual n�o ser mantido no header do NavigationDrawer foi corrigido e est� j� no projeto dispon�vel para download.

O link para download do projeto est� logo abaixo no post.

Os links dos �ltimos v�deos da s�rie Material Design no Android est�o na �rea "Relacionado" do post.

Segue links de v�deos que podem lhe ajudar a compreender melhor o conte�do do v�deo:

Parcelable no Android, Entendendo e Utilizando

http://www.thiengo.com.br/parcelable-no-android-entendendo-e-utilizando

Fragments no Android, Trabalhando com M�ltiplas Activities

http://www.thiengo.com.br/fragments-no-android-trabalhando-com-multiplas-activities

Ciclo de Vida e Otimiza��o de Fragments no Android

http://www.thiengo.com.br/ciclo-de-vida-e-otimizacao-de-fragments-no-android

Segue links das p�ginas apresentadas no v�deo:

P�gina de Buttons no guideline do Material Desing Android

http://www.google.com/design/spec/components/buttons.html

P�gina da lib MaterialDialog no GitHub

https://github.com/drakeet/MaterialDialog

P�gina da classe ContextThemeWrapper no site de documenta��o do Android

http://developer.android.com/reference/android/view/ContextThemeWrapper.html

Vlw