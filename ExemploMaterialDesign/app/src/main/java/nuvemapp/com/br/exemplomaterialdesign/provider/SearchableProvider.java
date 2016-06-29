package nuvemapp.com.br.exemplomaterialdesign.provider;

import android.content.SearchRecentSuggestionsProvider;


public class SearchableProvider extends SearchRecentSuggestionsProvider {
    public static final String AUTHORITY = "nuvemapp.com.br.exemplomaterialdesign.provider.SearchableProvider";
    public static final int MODE = DATABASE_MODE_QUERIES;

    public SearchableProvider(){
        setupSuggestions( AUTHORITY, MODE );
    }
}
