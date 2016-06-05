Utilizando NavigationDrawer, Material Design Android - Parte 5




Opa, blz?

Nesse vídeo dou continuidade a série sobre Material Design no Android, dessa vez mostrando uma implementação do NavigationDrawer, no caso utilizando a lib MaterialDrawer de Mike Penz que nos permite ter uma Full NavigationDrawer rodando em nossa APP Android com a chamada a poucos métodos das entidades da lib.

Note que a lib nos permite personalizar todo o conteúdo, apesar da mudança do Adapter e da ListView serem desencorajados pelo autor da lib. No vídeo apresento a facilidade de implementar tanto o listener de click simples quanto o de long click. Mostro também como setar os profiles no header do NavigationDrawer.

Note que no vídeo comentei sobre a implementação do onSaveInstanceState() da Activity, porém acabei passando "batido" sem implementar, no big deal, a implementação é simples e no código de exemplo que está disponível para download já deixei implementado, se surgir a dúvida baixe o código e veja como ficou a implementação (bem simples mesmo, poucas linhas de código). Adicionei também a implementação do método onBackPressed(), pois se testar o projeto você notará que mesmo com o NavigationDrawer aberto a APP é fechada quando na verdade o comportamento comum é que o NavigationDrawer seja fechado e ai sim com ele fechado seja fechada a APP se o back button for pressionado novamente. Bom é isso, vou evitar mais delongas e deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo, no post.

Os links dos vídeos anteriores da série Material Design no Android se encontram na sessão "Relacionado" desse post.

Segue links apresentados no vídeo:

Página da lib MaterialDrawer no GitHub

https://github.com/mikepenz/MaterialDrawer

Página da Wiki da lib MaterialDrawer no GitHub 

https://github.com/mikepenz/MaterialDrawer/wiki/.MaterialDrawer-Wiki

Página do NavigationDrawer no guideline do Material Design

http://www.google.com/design/spec/patterns/navigation-drawer.html

Como comentei sobre a implementação manual apresentada na série Material Design do SlideNerd, segue link: NavigationDrawer SlideNerd

https://www.youtube.com/watch?v=zWpEh9k8i7Q&list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD&index=6

Vlw



Ex: https://github.com/rudsonlive/NavigationDrawer-MaterialDesign