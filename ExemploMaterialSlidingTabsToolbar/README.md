Sliding Tabs Toolbar, Material Design Android - Parte 8



Opa, blz?

Nesse vídeo dou continuidade a série de vídeos sobre Material Design no Android, dessa vez colocando tabs na Toolbar. Não tão trivial como era quando utilizavamos ActionBar, para implementar tabs com efeito de sliding temos de utilizar algumas entidades como ViewPager, PageAdapter, SlidingTabLayout e SlidingTabStripe além de ter de realizar algumas modificações em nosso código implementado anteriormente, principalmente na parte do FloatingActionButton.

A sincronia com os itens do NavigationDrawer é tranquila de realizar apenas utilizando o método setCurrentItem() do ViewPager quando a troca acontece no NavigationDrawer e o método setSelection() do NavigationDrawer quando a mudança é direto na tab. Note que o onPageChangeListener que deve ser implmentado é o do SlidingTabLayout, pois a implementação da versão do ViewPager não funciona com esse tipo de implementacão de tabs. Apesar da utilização das entidades ImageSpan e SpannableString sem um vídeo anterior as explicando o entendimento ficou tranquilo, pois não faço muita coisa com elas a não ser adicionar a imagem (Drawable) a uma String.

Note que não cortei do vídeo alguns erros que cometi para mostrar onde foi o vacilo. Sem mais delongas vou deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Veja todos os vídeos dessa série sobre Material Design no Android seguindo a YouTube PlayList abaixo:

Material Design

Segue link do vídeo sobre ViewPager já feito no Blog:

ViewPager no Android, Entendendo e Utilizando

http://www.google.com/design/spec/components/tabs.html

Segue links das páginas apresentadas no vídeo:

https://github.com/google/iosched

Página da sessão Tabs nos guidelines do Material Design Android

http://developer.android.com/reference/android/support/v4/view/ViewPager.html

Página do Google IO no GitHub

http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html

Página da view ViewPager no site de documento do Android

http://developer.android.com/reference/android/support/v4/view/ViewPager.html

Página da classe PageAdapter no site de documentação do Android

http://developer.android.com/reference/android/support/v4/view/PagerAdapter.html

Página da classe FragmentPageAdapter no site de documentação do Android

http://developer.android.com/reference/android/support/v4/app/FragmentPagerAdapter.html

Página da classe FragmentStatePageAdapter no site de documentação do Android

http://developer.android.com/reference/android/support/v4/app/FragmentStatePagerAdapter.html

Página da classe ImageSpan no site de documentação do Android

http://developer.android.com/reference/android/text/style/ImageSpan.html

Página da classe SpannableString no site de documentação do Android

http://developer.android.com/reference/android/text/SpannableString.html

Vlw