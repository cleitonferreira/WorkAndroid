Buscas Com SearchView e SearchRecentSuggestions. Material Design Android - Parte 13






Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre o Material Design no Android, dessa vez abordando o SearchView junto a um SearchRecentSuggestionProvider. O SearchView � a interface que o usu�rio da APP tem para entrar com a busca desejada, essa interface � configurada por um arquivo xml, searchable.xml, que temos de definir dentro do folder /res/xml/. Esse arquivo searchable.xml vai permitir que o Android instancie uma entidade SearchableInfo, entidade na qual todas as Acivities que v�o permitir que uma busca seja realizada devem utilizar, enfatizo isso, pois na documenta��o d� a entender que somente no Searchable Activity � que devemos utilizar essa SearchableInfo. O Searchable Activity � outra entidade que devemos implementar, nela ser� apresentado o resultado da busca. Se sua APP realizar a busca local em um SQLite ou em uma lista (esse �ltimo como no v�deo), ent�o o processamento da busca tamb�m ser� no SearchableActivity. 

Note a utiliza��o do atributo launchMode igual a singleTop para evitar que tenhamos mais de uma SearchableActivity no topo da pilha de Activities, essa defini��o � importante para que n�o se crie v�rias Searchable Activities no topo da pilha se o usu�rio realizar buscas dentro da Searchable Activity. Consequentemente com o uso do singleTop temos de utilizar tamb�m o m�todo onNewIntent() para alterarmos o Intent qual na Searchable Activity. Com o Searchable Activity configurado e definidas no AndroidManifest.xml as Activities que poder�o realizar a busca na interface de search, somente nos resta implementar um SearchRecentSuggestProvider que permitir� que nossa APP sugira buscas recentes ao usu�rio que est� entrando com dados no SearchView. Note que mesmo n�o sendo abordado no v�deo (passei batido sem perceber) � poss�vel enviar mais do que apenas a String de busca na Intent, sobreescrevendo o m�todo startActivity() como abaixo, podemos enviar mais dados:

 

@Override

    public void startActivity(Intent intent) {

        if( Intent.ACTION_SEARCH.equalsIgnoreCase( intent.getAction() ) ){

            intent.putExtra("latitude", 20.56f); // EXEMPLO LATITUDE

            intent.putExtra("longitude", 20.13f); // EXEMPLO LONGITUDE

        }

        super.startActivity(intent);

    }

 

E ent�o obtendo no Searchable Activity como no c�digo abaixo:

 

Log.i("LOG", "Lat: "+intent.getFloatExtra("latitude", 0));

Log.i("LOG", "Lgd: "+intent.getFloatExtra("longitude", 0));

 

No mais o v�deo � mais completo que esse texto, incluindo c�digo para limpar o hist�rico do usu�rio na cache de buscas recentes (algoritmo recomendado na documenta��o do Search no Android). 

Obs. : a parte de busca de dados e filtro deles na base local ou remota � de responsabilidade de seus scripts, pois as entidades de Search muito oferecem apenas a Interface e comunica��o com a entidade que realizar� o processamento dos dados.

O link para download do projeto se encontra logo abaixo no post.

Segue link do v�deo sobre ContentProvider dispon�vel no Blog:

ContentProvider no Android, Entendendo e Utilizando

Segue links das p�ginas apresentadas no v�deo:

P�gina da classe SearchView no Android

http://developer.android.com/reference/android/widget/SearchView.html

P�gina da classe SearchRecentSuggestionsProvider no Android

http://developer.android.com/reference/android/content/SearchRecentSuggestionsProvider.html

P�gina de tutorial de implementa��o do Search feature no Android

http://developer.android.com/guide/topics/search/search-dialog.html

P�gina do tutorial de RecentQueriesSuggetion no SearchView Android

http://developer.android.com/guide/topics/search/adding-recent-query-suggestions.html

P�gina do arquivo de  configura��o Searchable.xml

http://developer.android.com/guide/topics/search/searchable-config.html

Vlw