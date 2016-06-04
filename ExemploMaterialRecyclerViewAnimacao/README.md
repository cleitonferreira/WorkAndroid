Anima��o, onLongPress e GridLayoutManager em RecyclerView, Material Design Android - Parte 3




Opa, blz?

Nesse v�deo dou continuidade a s�rie sobre Material Design no Android, por�m termino aqui o v�deo 1 sobre RecyclerView, nesse falando sobre as outras duas entidades de LayoutManager, GridLayoutManager e StaggeredGridLayoutManager. A primeira alinha os itens n�o evitando gaps, enquanto a segunda da foco em evitar gaps entre as c�lulas. Mostro tamb�m como implementar OnLongPressListener (al�m do OnClickListener) utilizando o GestureDetector.SimpleOnGestureListener que via MotionEvent nos permite detectar qual foi o evento disparado. Por �ltimo mostro como utilizar a lib Android View Animations de Daimajia para colocar anima��es nos itens do RecyclerView, note que nem todas as anima��es funcionam, ou porque a view sendo utilizada para animar n�o d� suporte ou porque o device realmente n�o d� suporte, por�m em meus testes a maioria funcionou sem problemas (inclusive na API 10), n�o esque�a de utilizar os blocos try...catch, caso contr�rio pode ocorrer Exceptions em devices sem suporte a anima��o escolhida em seu script. Ent�o � isso, nesse v�deo n�o mostrei o CardView como comentado no v�deo anterior, pois optei por evitar um v�deo ainda maior com um conte�do misturado tendo RecyclerView e CardView. Sem mais delongas vou deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Os links dos primeiros v�deos da s�rie sobre o Material Design no Android se encontram na �rea "Relacionado" do post.

Seguem links das p�ginas apresentadas no v�deo:

P�gina da classe GridLayoutManager no site de documenta��o do Android

https://developer.android.com/reference/android/support/v7/widget/GridLayoutManager.html

P�gina da classe StaggeredGridLayoutManager no site de documenta��o do Android 

https://developer.android.com/reference/android/support/v7/widget/StaggeredGridLayoutManager.html

P�gina da classe GestureDetector no site de documenta��o do Android

http://developer.android.com/reference/android/view/GestureDetector.html

P�gina da classe est�tica SimpleOnGestureListener no site de documenta��o do Android

http://developer.android.com/reference/android/view/GestureDetector.SimpleOnGestureListener.html

P�gina da lib Android View Animations no GitHub

https://github.com/daimajia/AndroidViewAnimations

Vlw 