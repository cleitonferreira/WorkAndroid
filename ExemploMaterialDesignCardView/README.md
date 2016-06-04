Utilizando CardView, Material Design Android - Parte 4





Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre o Material Design no Android, dessa vez mostrando como utilizar o CardView (ao menos uma maneira). Nesse v�deo preferi mostrar tamb�m alguns aspectos que o guideline do Material Design p�e como padr�o no momento da implementa��o do CardView, como os espa�amentos entre views filhas do CardView, os posicionamentos dos elementos que s�o prim�rios, secund�rios, ... os tamanhos de fonte e imagem (m�dia, v�deo tamb�m). Fique atento quanto a utiliza��o de alguns atributos, principalmente o atributo "cardMaxElevation" que n�o funcionou comigo quando no XML, somente quando utilizei ele via Java API (m�todo setMaxCardElevation()) � que ele funcionou sem problemas. Os demais atributos comento bastante sobre eles no v�deo.

Enfim, no final tem uma implementa��o de um script que nos permite colocar corners do ImageView arredondadas de acordo com nossa escolha (no exemplo foram as do topo), al�m de esse script tamb�m redimensionar a imagem. Note que o script completo foi utilizado apenas em vers�es anteriores a API 21 devido aos problemas encontrados com o uso de imagens no CardView em vers�es anteriores a API 21. Mostrei o valor 14 para obter o tamanho correto que ser� utilizado na imagem, por�m esse n�mero � �til somente se voc� estiver implementando o mesmo tipo de layout (pelo menos com o CardView pegando todo a tela e as mesmas margens apresentadas no v�deo), caso contr�rio voc� ter� de (via "for�a bruta") encontrar o n�mero correto para teu layout ou ent�o implementar um script diferente do apresentado. Mas � isso, vou evitar mais delongas e deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Os links dos v�deos anteriores dessa s�rie de Material Design no Android est�o na sess�o "Relacionado" do post.

Segue links apresentados no v�deo:

P�gina da classe CardView no site de documenta��o do Android.

https://developer.android.com/reference/android/support/v7/widget/CardView.html

P�gina de implementa��o do CardView com Material Design no site de documenta��o do Android.

https://developer.android.com/training/material/lists-cards.html#Dependencies

P�gina de descri��o do CardView (incluindo bons gr�ficos) no site de documenta��o do Xamarin Android.

http://developer.xamarin.com/guides/android/platform_features/android_l/cardview/

P�gina de Cards no Guideline do Material Design.

http://www.google.com/design/spec/components/cards.html

P�gina do stackoverflow onde foi obtido o script de arredondamento de bordas de Bitmaps.

http://stackoverflow.com/questions/2459916/how-to-make-an-imageview-with-rounded-corners/5252726#5252726

Vlw


Exemplos:

https://github.com/gabrielemariotti/cardslib