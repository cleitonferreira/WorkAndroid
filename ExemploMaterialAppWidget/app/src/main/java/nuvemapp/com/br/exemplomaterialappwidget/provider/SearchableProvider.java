package nuvemapp.com.br.exemplomaterialappwidget.provider;

import android.content.SearchRecentSuggestionsProvider;


public class SearchableProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = "nuvemapp.com.br.exemplomaterialappwidget.provider.SearchableProvider";
    public static final int MODE = DATABASE_MODE_QUERIES;

    public SearchableProvider(){
        setupSuggestions( AUTHORITY, MODE );
    }
}
