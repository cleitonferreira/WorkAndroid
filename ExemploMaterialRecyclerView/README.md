

RecyclerView, Material Design Android - Parte 2



Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre Material Design no Android, dessa vez falando sobre o RecyclerView que veio para substituir tanto o ListView quanto o GridView (incluindo as entidades de apoio a ambas). O RecyclerView é muito mais eficiente que as duas antigas implementações, mesmo utilizando uma configuração de ViewHolder praticamente igual (não podemos definir otimização apenas no aspecto do ViewHolder). Uma das grandes vantagens do RecyclerView é a flexibilidade de poder mudar de LayoutManager sem ter de implementar um caminhão de código somente para ter versões de tiles ou cards em nossa lista.

Como com ListView e GridView o RecyclerView precisa de entidades extras para poder funcionar, no caso temos o LayoutManager (no vídeo utilizei o LinearLayoutManager) que é responsável pela redenrização da view de cada item no screen do device. Temos o Adapter que é reponsável por vincular os dados do conjunto passado a ele a view (que será a view de cada item do RecyclerView) e então enviar essa view ao LayoutManager. E para finalizar temos o ViewHolder que é responsável pela cache das views criadas no método onCreateViewHolder() para posteriormente reutiliza-las otimizando então o trabalho com o RecyclerView.

Acabei pulando a parte de mostrar o RecyclerView na horizontal, basta ir na mesma linha que coloquei LinearLayoutManager.VERTICAL e alterar para LinearLayoutManager.HORIZONTAL. As implementações dos outros LayoutManagers virão provavelmente no próximo vídeo onde mostrarei também o CardView. Fique atento quanto a implementação do Listener de Click no RecyclerView, pois não há um método simples como no ListView para essa funcionalidade. Sem mais delongas vou deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Segue link das páginas apresentadas no vídeo:

Página Creating Lists and Cards do site de desenvolvedores Android

https://developer.android.com/training/material/lists-cards.html

Página da classe RecyclerView no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html

Página da classe RecyclerView.LayoutManager no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.LayoutManager.html

Página da classe LinearLayoutManager no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/LinearLayoutManager.html

Página da classe RecyclerView.Adapter no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html

Página da classe RecyclerView.ViewHolder no site de desenvolvedores Android

https://developer.android.com/reference/android/support/v7/widget/RecyclerView.ViewHolder.html

Sites e canais de apoio para esse vídeo:

Grokking Android - A First Glance at Android’s RecyclerView

https://www.grokkingandroid.com/first-glance-androids-recyclerview/

Slidenerd - RecyclerView

https://www.youtube.com/watch?v=mGTRNp6FbU4&list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD&index=15

Vlw