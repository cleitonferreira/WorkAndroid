Utilizando NavigationDrawer, Material Design Android - Parte 5




Opa, blz?

Nesse v�deo dou continuidade a s�rie sobre Material Design no Android, dessa vez mostrando uma implementa��o do NavigationDrawer, no caso utilizando a lib MaterialDrawer de Mike Penz que nos permite ter uma Full NavigationDrawer rodando em nossa APP Android com a chamada a poucos m�todos das entidades da lib.

Note que a lib nos permite personalizar todo o conte�do, apesar da mudan�a do Adapter e da ListView serem desencorajados pelo autor da lib. No v�deo apresento a facilidade de implementar tanto o listener de click simples quanto o de long click. Mostro tamb�m como setar os profiles no header do NavigationDrawer.

Note que no v�deo comentei sobre a implementa��o do onSaveInstanceState() da Activity, por�m acabei passando "batido" sem implementar, no big deal, a implementa��o � simples e no c�digo de exemplo que est� dispon�vel para download j� deixei implementado, se surgir a d�vida baixe o c�digo e veja como ficou a implementa��o (bem simples mesmo, poucas linhas de c�digo). Adicionei tamb�m a implementa��o do m�todo onBackPressed(), pois se testar o projeto voc� notar� que mesmo com o NavigationDrawer aberto a APP � fechada quando na verdade o comportamento comum � que o NavigationDrawer seja fechado e ai sim com ele fechado seja fechada a APP se o back button for pressionado novamente. Bom � isso, vou evitar mais delongas e deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo, no post.

Os links dos v�deos anteriores da s�rie Material Design no Android se encontram na sess�o "Relacionado" desse post.

Segue links apresentados no v�deo:

P�gina da lib MaterialDrawer no GitHub

https://github.com/mikepenz/MaterialDrawer

P�gina da Wiki da lib MaterialDrawer no GitHub 

https://github.com/mikepenz/MaterialDrawer/wiki/.MaterialDrawer-Wiki

P�gina do NavigationDrawer no guideline do Material Design

http://www.google.com/design/spec/patterns/navigation-drawer.html

Como comentei sobre a implementa��o manual apresentada na s�rie Material Design do SlideNerd, segue link: NavigationDrawer SlideNerd

https://www.youtube.com/watch?v=zWpEh9k8i7Q&list=PLonJJ3BVjZW6CtAMbJz1XD8ELUs1KXaTD&index=6

Vlw



Ex: https://github.com/rudsonlive/NavigationDrawer-MaterialDesign