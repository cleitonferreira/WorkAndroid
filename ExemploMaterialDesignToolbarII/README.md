Toolbar, Material Design Android - Parte 1




Opa, blz?

Nesse vídeo começo a série sobre Material Design e outras novas entidades no Android. No primeiro vídeo apresento algumas maneiras de utilizar o Toolbar no Android (como ActionBar e como Standalone mode). Bem simples de configurar a Toolbar é um ViewGroup (como LinearLayout, por exemplo) diferente do que era a antiga ActionBar que fazia parte da Activity. No vídeo implemento além do modelo convencional de ActionBar, uma Toolbar no bottom do layout trabalhando como uma barra de redes sociais da APP e área de link de acesso a parte de configurações da APP. Na SecondActivity mostro uma forma de se montar a Floating Toolbar, utilizando <selector> quando em versões maiores ou iguais a API 21 (Lollipop) e utilizando 9patch caso contrário. Fique atento ao modo de setar o listener de click ao ImageView que está dentro do Toolbar.

Note que a barra de redes socias do vídeo é uma barra fake, pois não setei as urls corretas das páginas sociais do blog, caso queira reaproveita-la altere as urls para as de sua APP nas redes sociais. Não esqueça de setar no gradle a lib de suporte que permitirá a utilização do Toolbar em versões anteriores a API 21. Sem mais delongas vou deixá-lo assitir o vídeo.

Obs. : As implementações dos ícones e funcionalidades de Search e Navigation vou colocar em videos futuros da série, esse foquei apenas no Toolbar.

O link para download do projeto se encontra logo abaixo no post.

Segue link do vídeo sobre o 9patch:

9-Patch no Android, Mantendo a Qualidade de Imagens de Background

Segue links das páginas apresentadas no vídeo:

Página da classe Toolbar no site de documentação do Android

https://developer.android.com/reference/android/support/v7/widget/Toolbar.html

Página de implementação do Material Design no Android, área de cores a serem definidas

https://developer.android.com/training/material/theme.html

Post do Android Developers Blog com implementação da Toolbar via AppCompat v21

http://android-developers.blogspot.com.br/2014/10/appcompat-v21-material-design-for-pre.html

Post do Android Developers Blog com implementação do Material Design no Android

http://android-developers.blogspot.com.br/2014/10/implementing-material-design-in-your.html

Área da Toolbar na guideline do Material Design Android

http://www.google.com/design/spec/layout/structure.html#structure-toolbars

Material Pallete para definição de paletas para APP Android

http://www.materialpalette.com/

Material Design Icons para download de icons para Android

http://materialdesignicons.com/

Android Asset Studio para simplificação na criação imagens 9patch

http://romannurik.github.io/AndroidAssetStudio/nine-patches.html

Vlw