AutoCompleteTextView no Android, Entendendo e Utilizando



Opa, blz?

Nesse vídeo mostro algumas maneiras de como utilizar o componente visual AutoCompleteTextView no Android. Apresento quetro maneiras, sendo que as duas primeiras são muito próximas e o que diferencia as duas últimas é a bus sendo realizada em um servidor Web em uma delas. Note o uso de arrays que foram definidos no xml do Android (mais precisamente no string.xml) para separar a visão da lógica. A lista de objetos State foi inevitável, então persistir com ela na MainActivity. A utilização da interface Filterable é para informar ao adapter que nós iremos implementar um filtro para os dados, o Filterable não necessáriamente deve ser utilizado somente no contexto no AutoCompleteTextView, você pode utilizá-lo em outras situções que haja a necessidade de filtro também, até mesmo um simples ListView. Como informado, o Filterable apenas informa que iremos realizar um filtro, mas é com a implementação do Filter que nós definimos nosso filtro personalizado na lista. Lembrando que o método performFiltering() da calsse abstrata Filter roda já em uma Thread diferente da Thread principal ou Thread UI, sendo assim aproveitei essa "jogada" para já realizar a conexão com o servidor Web nesse método, assim não foi necessária outro script para realizara chamada dos dados na Web. O retorno do método performFiltering() é direcionado para o método publishResults() que no caso já roda na Thread principal novamente. Fique atento na parte que utilizo uma flag chamada id para controlar a apresentação do DropDown do AutoCompleteTextView quando em conexão Web, pois como informado no vídeo, a chamada ao método performFiltering() cria uma nova Thread, mas não desliga a anterior, e a nova Thread fica na fila eseperando a finalização da Thread anterior para então começar a ser processada. Coloquei o TextWatcher para acompanharmos tudo que está sendo digitado no AutoCompleteTextView, mas ele pode ser utilizado em outras Views que permitem entrada de dados, como o próprio EditText, por exemplo. Vou evitar mais delongas e deixar você assistir ao vídeo.

O link para download do projeto, incluindo arquivo php, se encontra logo abaixo no post.

Segue links dos vídeos que podem lhe ajudar a compreender melhor algumas entidades utilizadas no projeto do vídeo:

Spinner (ou Select) no Android, Entendendo e Utilizando

Utilizando BaseAdapter Para Personalização Completa da ListView

Parser JSON no Android, Entendendo e Utilizando

Volley no Android, Entendendo e Utilizando

Segue link das páginas apresentadas no vídeo:

Página da View AutoCompleteTextView no site oficial do Android

http://developer.android.com/reference/android/widget/AutoCompleteTextView.html

Página da interface Filterable na site oficial do Android

http://developer.android.com/reference/android/widget/Filterable.html

Página da classe abstrata Filter no site oficial do Android

http://developer.android.com/reference/android/widget/Filter.html

Vlw