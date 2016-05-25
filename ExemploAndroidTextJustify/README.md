TextJustify Lib Com SpannableString no Android




Opa, blz?

Nesse vídeo apresento a lib TextJustify que nos permite justificar textos no Android, caracteristica que a principio o Android não nos fornece de forma nativa. A lib é simples de utilizar, trabalhamos no vídeo, no caso, com a view DocumentView que aparenemente herda de TextView, porém não, pois quando utilizamos o Linkify, por exemplo, a instancia de DocumentView não é aceita, se tentarmos o cast (TextView) também não é aceito. A lib pode ser util em casos como resumos de itens do ListView, para texto completo recomendo com o alinhamento a esquerda, pois é mais confortável na leitura. No vídeo é mostrado também que a Lib TextJustify tem uma limitação que pode atrapalhar seu uso, se quisermos colocar textos linkados (facimente conseguido com TextView / Spannable e Linkify) aparenemente não é possível com o uso da lib, mesmo se criarmos os links via SpannableString. Agora é esperar uma atualizava corrigida ou ampliada se essa for mesmo uma limitação da lib. Outra coisa que é possível notar é não funcionamento dos métodos de Hyphen (setHyphenator() e setHyphenated()) se estiver sendo utilizando algum Spannable, provavelmente outra limitação da lib. Então é isso, acredito que para resumos a lib é uma boa escolha, mais por questão de designer mesmo, para texto completo onde provavelmente terá links e emails não recomendo o uso dela.

O link para download do projeto se encontra logo abaixo no post.

Segue link do vídeo sobre a classe Linkify no android:

Linkify no Android, Entendendo e Utilizando

Segue link das páginas apresentadas no vídeo:

Página da lib TextJustify no Github

https://github.com/bluejamesbond/TextJustify-Android

Página da Wiki da lib TextJustify

https://github.com/bluejamesbond/TextJustify-Android/wiki/3-%C2%B7-Examples

Página da interface Spannable no site oficial do Android

http://developer.android.com/reference/android/text/Spannable.html

Página da interface Spanned no site oficial do Android

http://developer.android.com/reference/android/text/Spanned.html

Página da classe SpannableString no site oficial do Android

http://developer.android.com/reference/android/text/SpannableString.html

Página da classe SpannableStringBuilder no site oficial do Android

http://developer.android.com/reference/android/text/SpannableStringBuilder.html

 

Vlw