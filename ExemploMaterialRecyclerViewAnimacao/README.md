Animação, onLongPress e GridLayoutManager em RecyclerView, Material Design Android - Parte 3




Opa, blz?

Nesse vídeo dou continuidade a série sobre Material Design no Android, porém termino aqui o vídeo 1 sobre RecyclerView, nesse falando sobre as outras duas entidades de LayoutManager, GridLayoutManager e StaggeredGridLayoutManager. A primeira alinha os itens não evitando gaps, enquanto a segunda da foco em evitar gaps entre as células. Mostro também como implementar OnLongPressListener (além do OnClickListener) utilizando o GestureDetector.SimpleOnGestureListener que via MotionEvent nos permite detectar qual foi o evento disparado. Por último mostro como utilizar a lib Android View Animations de Daimajia para colocar animações nos itens do RecyclerView, note que nem todas as animações funcionam, ou porque a view sendo utilizada para animar não dá suporte ou porque o device realmente não dá suporte, porém em meus testes a maioria funcionou sem problemas (inclusive na API 10), não esqueça de utilizar os blocos try...catch, caso contrário pode ocorrer Exceptions em devices sem suporte a animação escolhida em seu script. Então é isso, nesse vídeo não mostrei o CardView como comentado no vídeo anterior, pois optei por evitar um vídeo ainda maior com um conteúdo misturado tendo RecyclerView e CardView. Sem mais delongas vou deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Os links dos primeiros vídeos da série sobre o Material Design no Android se encontram na área "Relacionado" do post.

Seguem links das páginas apresentadas no vídeo:

Página da classe GridLayoutManager no site de documentação do Android

https://developer.android.com/reference/android/support/v7/widget/GridLayoutManager.html

Página da classe StaggeredGridLayoutManager no site de documentação do Android 

https://developer.android.com/reference/android/support/v7/widget/StaggeredGridLayoutManager.html

Página da classe GestureDetector no site de documentação do Android

http://developer.android.com/reference/android/view/GestureDetector.html

Página da classe estática SimpleOnGestureListener no site de documentação do Android

http://developer.android.com/reference/android/view/GestureDetector.SimpleOnGestureListener.html

Página da lib Android View Animations no GitHub

https://github.com/daimajia/AndroidViewAnimations

Vlw 