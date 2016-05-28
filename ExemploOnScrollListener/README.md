Carregando Dados no ListView Com OnScrollListener e Volley no Android




Opa, blz?

Nesse v�deo apresento uma maneira de carregar dados da Web e apresent�-los no ListView no Android, mais precisamente carregar dados utilizando OnScrollListener e Volley quando o usu�rio alcan�ar o �ltimo item do ListView, muito conhecido como "carregar mais". No v�deo utilizo a mescla de v�rias entidades como: Volley, Universal Image Loader, ListView Listeners (OnItemClickListener e OnScrollListener) e Interface Java. No v�deo mostro o carregamento somente quando o �ltimo item do ListView � apresentado na tela, por�m esse � um item de escolha baseado nas requisi��es de seu projeto.

Entenda a importancia da flag isThereMore, pois ela n�o somente evita a tentativa de carregamento quando n�o h� mais dados a serem carregados, na verdade ela evita o uso desnecess�rio de conex�o Web (poupando cr�ditos 3G em alguns casos) e consequentemente o consumo extra de bateria. O ProgressBar utilizado tem um o papel de informar ao usu�rio que algo est� acontecendo no background, no caso, o carregamento de mais itens. Fique atento a parte do script PHP tamb�m, pois h� necessidade de criarmos um filtro nele baseado nos dados que eviamos para o server Web para obter mais carros. No caso fique atento quanto a l�gica de filtro utilizada, pois a linguagem de backend pode ser qualquer uma (Java, PHP ou Python, por exemplo). Ent�o � isso, vou evitar mais delongas e deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Segue links �teis que lhe ajudar�o a entender as entidades utilizadas nesse v�deo:

Utilizando BaseAdapter Para Personaliza��o Completa da ListView

Volley no Android, Entendendo e Utilizando

Carregamento e Cache de Imagem Com Universal Image Loader no Android

Parcelable no Android, Entendendo e Utilizando

Segue link da p�gina apresentada no v�deo:

P�gina do listener OnScrollListener no site oficioal do Android

http://developer.android.com/reference/android/widget/AbsListView.OnScrollListener.html

Vlw