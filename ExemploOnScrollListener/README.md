Carregando Dados no ListView Com OnScrollListener e Volley no Android




Opa, blz?

Nesse vídeo apresento uma maneira de carregar dados da Web e apresentá-los no ListView no Android, mais precisamente carregar dados utilizando OnScrollListener e Volley quando o usuário alcançar o último item do ListView, muito conhecido como "carregar mais". No vídeo utilizo a mescla de várias entidades como: Volley, Universal Image Loader, ListView Listeners (OnItemClickListener e OnScrollListener) e Interface Java. No vídeo mostro o carregamento somente quando o último item do ListView é apresentado na tela, porém esse é um item de escolha baseado nas requisições de seu projeto.

Entenda a importancia da flag isThereMore, pois ela não somente evita a tentativa de carregamento quando não há mais dados a serem carregados, na verdade ela evita o uso desnecessário de conexão Web (poupando créditos 3G em alguns casos) e consequentemente o consumo extra de bateria. O ProgressBar utilizado tem um o papel de informar ao usuário que algo está acontecendo no background, no caso, o carregamento de mais itens. Fique atento a parte do script PHP também, pois há necessidade de criarmos um filtro nele baseado nos dados que eviamos para o server Web para obter mais carros. No caso fique atento quanto a lógica de filtro utilizada, pois a linguagem de backend pode ser qualquer uma (Java, PHP ou Python, por exemplo). Então é isso, vou evitar mais delongas e deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Segue links úteis que lhe ajudarão a entender as entidades utilizadas nesse vídeo:

Utilizando BaseAdapter Para Personalização Completa da ListView

Volley no Android, Entendendo e Utilizando

Carregamento e Cache de Imagem Com Universal Image Loader no Android

Parcelable no Android, Entendendo e Utilizando

Segue link da página apresentada no vídeo:

Página do listener OnScrollListener no site oficioal do Android

http://developer.android.com/reference/android/widget/AbsListView.OnScrollListener.html

Vlw