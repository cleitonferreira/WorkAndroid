TextJustify Lib Com SpannableString no Android




Opa, blz?

Nesse v�deo apresento a lib TextJustify que nos permite justificar textos no Android, caracteristica que a principio o Android n�o nos fornece de forma nativa. A lib � simples de utilizar, trabalhamos no v�deo, no caso, com a view DocumentView que aparenemente herda de TextView, por�m n�o, pois quando utilizamos o Linkify, por exemplo, a instancia de DocumentView n�o � aceita, se tentarmos o cast (TextView) tamb�m n�o � aceito. A lib pode ser util em casos como resumos de itens do ListView, para texto completo recomendo com o alinhamento a esquerda, pois � mais confort�vel na leitura. No v�deo � mostrado tamb�m que a Lib TextJustify tem uma limita��o que pode atrapalhar seu uso, se quisermos colocar textos linkados (facimente conseguido com TextView / Spannable e Linkify) aparenemente n�o � poss�vel com o uso da lib, mesmo se criarmos os links via SpannableString. Agora � esperar uma atualizava corrigida ou ampliada se essa for mesmo uma limita��o da lib. Outra coisa que � poss�vel notar � n�o funcionamento dos m�todos de Hyphen (setHyphenator() e setHyphenated()) se estiver sendo utilizando algum Spannable, provavelmente outra limita��o da lib. Ent�o � isso, acredito que para resumos a lib � uma boa escolha, mais por quest�o de designer mesmo, para texto completo onde provavelmente ter� links e emails n�o recomendo o uso dela.

O link para download do projeto se encontra logo abaixo no post.

Segue link do v�deo sobre a classe Linkify no android:

Linkify no Android, Entendendo e Utilizando

Segue link das p�ginas apresentadas no v�deo:

P�gina da lib TextJustify no Github

https://github.com/bluejamesbond/TextJustify-Android

P�gina da Wiki da lib TextJustify

https://github.com/bluejamesbond/TextJustify-Android/wiki/3-%C2%B7-Examples

P�gina da interface Spannable no site oficial do Android

http://developer.android.com/reference/android/text/Spannable.html

P�gina da interface Spanned no site oficial do Android

http://developer.android.com/reference/android/text/Spanned.html

P�gina da classe SpannableString no site oficial do Android

http://developer.android.com/reference/android/text/SpannableString.html

P�gina da classe SpannableStringBuilder no site oficial do Android

http://developer.android.com/reference/android/text/SpannableStringBuilder.html

 

Vlw