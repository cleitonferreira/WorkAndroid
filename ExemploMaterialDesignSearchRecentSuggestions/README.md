Buscas Com SearchView e SearchRecentSuggestions. Material Design Android - Parte 13






Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre o Material Design no Android, dessa vez abordando o SearchView junto a um SearchRecentSuggestionProvider. O SearchView é a interface que o usuário da APP tem para entrar com a busca desejada, essa interface é configurada por um arquivo xml, searchable.xml, que temos de definir dentro do folder /res/xml/. Esse arquivo searchable.xml vai permitir que o Android instancie uma entidade SearchableInfo, entidade na qual todas as Acivities que vão permitir que uma busca seja realizada devem utilizar, enfatizo isso, pois na documentação dá a entender que somente no Searchable Activity é que devemos utilizar essa SearchableInfo. O Searchable Activity é outra entidade que devemos implementar, nela será apresentado o resultado da busca. Se sua APP realizar a busca local em um SQLite ou em uma lista (esse último como no vídeo), então o processamento da busca também será no SearchableActivity. 

Note a utilização do atributo launchMode igual a singleTop para evitar que tenhamos mais de uma SearchableActivity no topo da pilha de Activities, essa definição é importante para que não se crie várias Searchable Activities no topo da pilha se o usuário realizar buscas dentro da Searchable Activity. Consequentemente com o uso do singleTop temos de utilizar também o método onNewIntent() para alterarmos o Intent qual na Searchable Activity. Com o Searchable Activity configurado e definidas no AndroidManifest.xml as Activities que poderão realizar a busca na interface de search, somente nos resta implementar um SearchRecentSuggestProvider que permitirá que nossa APP sugira buscas recentes ao usuário que está entrando com dados no SearchView. Note que mesmo não sendo abordado no vídeo (passei batido sem perceber) é possível enviar mais do que apenas a String de busca na Intent, sobreescrevendo o método startActivity() como abaixo, podemos enviar mais dados:

 

@Override

    public void startActivity(Intent intent) {

        if( Intent.ACTION_SEARCH.equalsIgnoreCase( intent.getAction() ) ){

            intent.putExtra("latitude", 20.56f); // EXEMPLO LATITUDE

            intent.putExtra("longitude", 20.13f); // EXEMPLO LONGITUDE

        }

        super.startActivity(intent);

    }

 

E então obtendo no Searchable Activity como no código abaixo:

 

Log.i("LOG", "Lat: "+intent.getFloatExtra("latitude", 0));

Log.i("LOG", "Lgd: "+intent.getFloatExtra("longitude", 0));

 

No mais o vídeo é mais completo que esse texto, incluindo código para limpar o histórico do usuário na cache de buscas recentes (algoritmo recomendado na documentação do Search no Android). 

Obs. : a parte de busca de dados e filtro deles na base local ou remota é de responsabilidade de seus scripts, pois as entidades de Search muito oferecem apenas a Interface e comunicação com a entidade que realizará o processamento dos dados.

O link para download do projeto se encontra logo abaixo no post.

Segue link do vídeo sobre ContentProvider disponível no Blog:

ContentProvider no Android, Entendendo e Utilizando

Segue links das páginas apresentadas no vídeo:

Página da classe SearchView no Android

http://developer.android.com/reference/android/widget/SearchView.html

Página da classe SearchRecentSuggestionsProvider no Android

http://developer.android.com/reference/android/content/SearchRecentSuggestionsProvider.html

Página de tutorial de implementação do Search feature no Android

http://developer.android.com/guide/topics/search/search-dialog.html

Página do tutorial de RecentQueriesSuggetion no SearchView Android

http://developer.android.com/guide/topics/search/adding-recent-query-suggestions.html

Página do arquivo de  configuração Searchable.xml

http://developer.android.com/guide/topics/search/searchable-config.html

Vlw