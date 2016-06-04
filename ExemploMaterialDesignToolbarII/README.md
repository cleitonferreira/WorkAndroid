Toolbar, Material Design Android - Parte 1




Opa, blz?

Nesse v�deo come�o a s�rie sobre Material Design e outras novas entidades no Android. No primeiro v�deo apresento algumas maneiras de utilizar o Toolbar no Android (como ActionBar e como Standalone mode). Bem simples de configurar a Toolbar � um ViewGroup (como LinearLayout, por exemplo) diferente do que era a antiga ActionBar que fazia parte da Activity. No v�deo implemento al�m do modelo convencional de ActionBar, uma Toolbar no bottom do layout trabalhando como uma barra de redes sociais da APP e �rea de link de acesso a parte de configura��es da APP. Na SecondActivity mostro uma forma de se montar a Floating Toolbar, utilizando <selector> quando em vers�es maiores ou iguais a API 21 (Lollipop) e utilizando 9patch caso contr�rio. Fique atento ao modo de setar o listener de click ao ImageView que est� dentro do Toolbar.

Note que a barra de redes socias do v�deo � uma barra fake, pois n�o setei as urls corretas das p�ginas sociais do blog, caso queira reaproveita-la altere as urls para as de sua APP nas redes sociais. N�o esque�a de setar no gradle a lib de suporte que permitir� a utiliza��o do Toolbar em vers�es anteriores a API 21. Sem mais delongas vou deix�-lo assitir o v�deo.

Obs. : As implementa��es dos �cones e funcionalidades de Search e Navigation vou colocar em videos futuros da s�rie, esse foquei apenas no Toolbar.

O link para download do projeto se encontra logo abaixo no post.

Segue link do v�deo sobre o 9patch:

9-Patch no Android, Mantendo a Qualidade de Imagens de Background

Segue links das p�ginas apresentadas no v�deo:

P�gina da classe Toolbar no site de documenta��o do Android

https://developer.android.com/reference/android/support/v7/widget/Toolbar.html

P�gina de implementa��o do Material Design no Android, �rea de cores a serem definidas

https://developer.android.com/training/material/theme.html

Post do Android Developers Blog com implementa��o da Toolbar via AppCompat v21

http://android-developers.blogspot.com.br/2014/10/appcompat-v21-material-design-for-pre.html

Post do Android Developers Blog com implementa��o do Material Design no Android

http://android-developers.blogspot.com.br/2014/10/implementing-material-design-in-your.html

�rea da Toolbar na guideline do Material Design Android

http://www.google.com/design/spec/layout/structure.html#structure-toolbars

Material Pallete para defini��o de paletas para APP Android

http://www.materialpalette.com/

Material Design Icons para download de icons para Android

http://materialdesignicons.com/

Android Asset Studio para simplifica��o na cria��o imagens 9patch

http://romannurik.github.io/AndroidAssetStudio/nine-patches.html

Vlw