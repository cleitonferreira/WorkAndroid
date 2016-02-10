package nuvemapp.com.br.exemploviewpersonalizada;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by XPredator on 10/02/2016.
 */
public class EmailText extends EditText {

    public EmailText(Context context) {
        super(context);
    }

    public EmailText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public boolean isEmail() {
        String expressaoRegular = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        String email = getText().toString();

        return(email.matches(expressaoRegular));
    }

}
