Carregamento e Cache de Imagem Com Universal Image Loader no Android


Opa, blz?

Nesse vídeo mostro como realizar carregamento de imagens da Web e além de apresenta-las no screen do device do usuário salva-las também na memória do aparelho e SDCard para que as imagens continuem sendo carregadas mesmo quando não há mais conexão com a Internet. A lib open source utilizada é a Universal Image Loader que além de ser bem consistente (mais de três anos de lib) é muito simples de se utilizar. A lib nos fornece um grande conjunto de métodos para customização, mas acredito que os métodos relacionados a cache são os de maior importância, e apesar de podermos escolher qual cache utilizar (ou ambas) recomendo a utilização de ambas, memória e SDCard, caso sua APP começar a ter problemas de vazamento de memória não acredito que deixar apenas uma das opções lhe ajudará muito, nesse caso recomendo que você destrinche os métodos todos realicionados ao carregamento da imagem e as caches, pois a lib é quase toda reconfigurável. A lib Universal Image Loader nos permite trabalhar como algumas configurações de estilização da imagem, que apesar de serem simples chamadas métodos são as vezes trabalhos pesados internamente no Android, logo recomendo que qualquer trabalho na imagem que tenha configuração de qualidade, tamanho, crop, ... seja esses realizados no servidor que tem muito mais memória e processador para isso, caso contrário há o risco de Exception. No mais é isso, não tem muito o que falar, recomendo a lib para carregar imagens de servidores remotos, para carregar loca utiliza um simples ImageView, já é o suficiente.

O link para download do projeto se encontra logo abaixo no post

Segue link do vídeo do BaseAdapter para auxiliar no entendimento do vídeo acima:

Utilizando BaseAdapter Para Personalização Completa da ListView

Segue links das páginas da lib Universal Image Loader apresentadas no vídeo:

Página principal da lib no GitHub

https://github.com/nostra13/Android-Universal-Image-Loader

Página de apresentação do fluxo de trabalho da lib

https://github.com/nostra13/Android-Universal-Image-Loader/wiki/Task-flow

Página de informações úteis sobre a utilização da lib

https://github.com/nostra13/Android-Universal-Image-Loader/wiki/Useful-Info

Vlw