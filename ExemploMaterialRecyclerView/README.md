

RecyclerView, Material Design Android - Parte 2



Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre Material Design no Android, dessa vez falando sobre o RecyclerView que veio para substituir tanto o ListView quanto o GridView (incluindo as entidades de apoio a ambas). O RecyclerView � muito mais eficiente que as duas antigas implementa��es, mesmo utilizando uma configura��o de ViewHolder praticamente igual (n�o podemos definir otimiza��o apenas no aspecto do ViewHolder). Uma das grandes vantagens do RecyclerView � a flexibilidade de poder mudar de LayoutManager sem ter de implementar um caminh�o de c�digo somente para ter vers�es de tiles ou cards em nossa lista.

Como com ListView e GridView o RecyclerView precisa de entidades extras para poder funcionar, no caso temos o LayoutManager (no v�deo utilizei o LinearLayoutManager) que � respons�vel pela redenriza��o da view de cada item no screen do device. Temos o Adapter que � repons�vel por vincular os dados do conjunto passado a ele a view (que ser� a view de cada item do RecyclerView) e ent�o enviar essa view ao LayoutManager. E para finalizar temos o ViewHolder que � respons�vel pela cache das views criadas no m�todo onCreateViewHolder() para posteriormente reutiliza-las otimizando ent�o o trabalho com o RecyclerView.

Acabei pulando a parte de mostrar o RecyclerView na horizontal, basta ir na mesma linha que coloquei LinearLayoutManager.VERTICAL e alterar para LinearLayoutManager.HORIZONTAL. As implementa��es dos outros LayoutManagers vir�o provavelmente no pr�ximo v�deo onde mostrarei tamb�m o CardView. Fique atento quanto a implementa��o do Listener de Click no RecyclerView, pois n�o h� um m�todo simples como no ListView para essa funcionalidade. Sem mais delongas vou deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Segue link das p�ginas apresentadas no v�deo:

P�gina Creating Lists and Cards do site de desenvolvedores Android

https://developer.android.com/training/material/lists-cards.html

P�gina da classe RecyclerView no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html

P�gina da classe RecyclerView.LayoutManager no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.LayoutManager.html

P�gina da classe LinearLayoutManager no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/LinearLayoutManager.html

P�gina da classe RecyclerView.Adapter no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html

P�gina da classe RecyclerView.ViewHolder no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.ViewHolder.html

Sites e canais de apoio para esse v�deo:

Grokking Android - A First Glance at Android�s RecyclerView

https://www.grokkingandroid.com/first-glance-androids-recyclerview/

Slidenerd - RecyclerView

https://www.youtube.com/watch?v=mGTRNp6FbU4&list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD&index=15

Vlw