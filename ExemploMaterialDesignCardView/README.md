Utilizando CardView, Material Design Android - Parte 4





Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre o Material Design no Android, dessa vez mostrando como utilizar o CardView (ao menos uma maneira). Nesse vídeo preferi mostrar também alguns aspectos que o guideline do Material Design põe como padrão no momento da implementação do CardView, como os espaçamentos entre views filhas do CardView, os posicionamentos dos elementos que são primários, secundários, ... os tamanhos de fonte e imagem (mídia, vídeo também). Fique atento quanto a utilização de alguns atributos, principalmente o atributo "cardMaxElevation" que não funcionou comigo quando no XML, somente quando utilizei ele via Java API (método setMaxCardElevation()) é que ele funcionou sem problemas. Os demais atributos comento bastante sobre eles no vídeo.

Enfim, no final tem uma implementação de um script que nos permite colocar corners do ImageView arredondadas de acordo com nossa escolha (no exemplo foram as do topo), além de esse script também redimensionar a imagem. Note que o script completo foi utilizado apenas em versões anteriores a API 21 devido aos problemas encontrados com o uso de imagens no CardView em versões anteriores a API 21. Mostrei o valor 14 para obter o tamanho correto que será utilizado na imagem, porém esse número é útil somente se você estiver implementando o mesmo tipo de layout (pelo menos com o CardView pegando todo a tela e as mesmas margens apresentadas no vídeo), caso contrário você terá de (via "força bruta") encontrar o número correto para teu layout ou então implementar um script diferente do apresentado. Mas é isso, vou evitar mais delongas e deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Os links dos vídeos anteriores dessa série de Material Design no Android estão na sessão "Relacionado" do post.

Segue links apresentados no vídeo:

Página da classe CardView no site de documentação do Android.

https://developer.android.com/reference/android/support/v7/widget/CardView.html

Página de implementação do CardView com Material Design no site de documentação do Android.

https://developer.android.com/training/material/lists-cards.html#Dependencies

Página de descrição do CardView (incluindo bons gráficos) no site de documentação do Xamarin Android.

http://developer.xamarin.com/guides/android/platform_features/android_l/cardview/

Página de Cards no Guideline do Material Design.

http://www.google.com/design/spec/components/cards.html

Página do stackoverflow onde foi obtido o script de arredondamento de bordas de Bitmaps.

http://stackoverflow.com/questions/2459916/how-to-make-an-imageview-with-rounded-corners/5252726#5252726

Vlw


Exemplos:

https://github.com/gabrielemariotti/cardslib