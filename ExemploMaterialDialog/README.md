Material Dialog, Correção Bug StatusBar e Ações nos Fragments. Material Design Android - Parte 7





Opa, blz?

Nesse vídeo continuo com a série Material Design no Android, dessa vez corrigindo alguns Bugs como o da StatusBar, colocando ações nos cliques nos itens do RecyclerView que anteriormente apenas chamava um Toast, e por final apresento a utilização de uma lib que nos permite colocar o Dialog no padrão do Material Design (a lib é meio bugada, mas funciona).

No vídeo apresento três maneiras de corrigir o problema de sobreposição de StatusBar quando rodando em Android com API maior ou igual a 19. A ültima solução pode sim parecer a melhor (visualmente ela é a melhor), porém não deixe de levar em conta o problema de dependencia grande a uma única lib.

Com o problema do Material Dialog, tentei corrigi-lo com diversos temas diferentes, com margin, ... mas mesmo assim aquela pequena barra no bottom não saiu, e quando saiu nós perdemos as bordas rounded nas APIs abaixo da 21.

Note que nos comentários sobre Fragment e Parcelable passei um pouco mais rápido, pois já fiz vídeos sobre essas entidades (estão abaixo no post). Então é isso, sem mais delongas vou deixar você assistir ao vídeo.

Obs. : O bug do profile atual não ser mantido no header do NavigationDrawer foi corrigido e está já no projeto disponível para download.

O link para download do projeto está logo abaixo no post.

Os links dos últimos vídeos da série Material Design no Android estão na área "Relacionado" do post.

Segue links de vídeos que podem lhe ajudar a compreender melhor o conteúdo do vídeo:

Parcelable no Android, Entendendo e Utilizando

http://www.thiengo.com.br/parcelable-no-android-entendendo-e-utilizando

Fragments no Android, Trabalhando com Múltiplas Activities

http://www.thiengo.com.br/fragments-no-android-trabalhando-com-multiplas-activities

Ciclo de Vida e Otimização de Fragments no Android

http://www.thiengo.com.br/ciclo-de-vida-e-otimizacao-de-fragments-no-android

Segue links das páginas apresentadas no vídeo:

Página de Buttons no guideline do Material Desing Android

http://www.google.com/design/spec/components/buttons.html

Página da lib MaterialDialog no GitHub

https://github.com/drakeet/MaterialDialog

Página da classe ContextThemeWrapper no site de documentação do Android

http://developer.android.com/reference/android/view/ContextThemeWrapper.html

Vlw