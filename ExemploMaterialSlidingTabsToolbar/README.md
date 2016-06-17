Sliding Tabs Toolbar, Material Design Android - Parte 8



Opa, blz?

Nesse v�deo dou continuidade a s�rie de v�deos sobre Material Design no Android, dessa vez colocando tabs na Toolbar. N�o t�o trivial como era quando utilizavamos ActionBar, para implementar tabs com efeito de sliding temos de utilizar algumas entidades como ViewPager, PageAdapter, SlidingTabLayout e SlidingTabStripe al�m de ter de realizar algumas modifica��es em nosso c�digo implementado anteriormente, principalmente na parte do FloatingActionButton.

A sincronia com os itens do NavigationDrawer � tranquila de realizar apenas utilizando o m�todo setCurrentItem() do ViewPager quando a troca acontece no NavigationDrawer e o m�todo setSelection() do NavigationDrawer quando a mudan�a � direto na tab. Note que o onPageChangeListener que deve ser implmentado � o do SlidingTabLayout, pois a implementa��o da vers�o do ViewPager n�o funciona com esse tipo de implementac�o de tabs. Apesar da utiliza��o das entidades ImageSpan e SpannableString sem um v�deo anterior as explicando o entendimento ficou tranquilo, pois n�o fa�o muita coisa com elas a n�o ser adicionar a imagem (Drawable) a uma String.

Note que n�o cortei do v�deo alguns erros que cometi para mostrar onde foi o vacilo. Sem mais delongas vou deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Veja todos os v�deos dessa s�rie sobre Material Design no Android seguindo a YouTube PlayList abaixo:

Material Design

Segue link do v�deo sobre ViewPager j� feito no Blog:

ViewPager no Android, Entendendo e Utilizando

http://www.google.com/design/spec/components/tabs.html

Segue links das p�ginas apresentadas no v�deo:

https://github.com/google/iosched

P�gina da sess�o Tabs nos guidelines do Material Design Android

http://developer.android.com/reference/android/support/v4/view/ViewPager.html

P�gina do Google IO no GitHub

http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html

P�gina da view ViewPager no site de documento do Android

http://developer.android.com/reference/android/support/v4/view/ViewPager.html

P�gina da classe PageAdapter no site de documenta��o do Android

http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html

P�gina da classe FragmentPageAdapter no site de documenta��o do Android

http://developer.android.com/reference/android/support/v4/app/FragmentPagerAdapter.html

P�gina da classe FragmentStatePageAdapter no site de documenta��o do Android

http://developer.android.com/reference/android/support/v4/app/FragmentStatePagerAdapter.html

P�gina da classe ImageSpan no site de documenta��o do Android

http://developer.android.com/reference/android/text/style/ImageSpan.html

P�gina da classe SpannableString no site de documenta��o do Android

http://developer.android.com/reference/android/text/SpannableString.html

Vlw