FloatingActionButton Com Tr�s Diferentes Libs, Material Design Android - Parte 6




Opa, blz?

Nesse v�deo continuo com a s�rie sobre Material Design no Android, dessa vez mostrando a utiliza��o do FloatingActionButton utilizando no caso tr�s diferentes libs, todas com caracter�sticas pr�prias e com seus pr�s e contras. Relembrando que � muito bom que voc� leia o meterial sobre FloatingActionButton nos guidelines do Material Design no Android. Bom, vamos aos coment�rios das libs utilizadas:

http://www.google.com/design/spec/components/buttons-floating-action-button.html

FloatingActionButton (com.melnykov.fab.FloatingActionButton): vantagem de ter suporte desde API 7 e a facilidade de implementa��o e uso. Contra, pouco customiz�vel e apenas uma forma nativa de anima��o.

Action Button (com.software.shell.fab.ActionButton): vantagem de ter suporte desde API 9, escolha de anima��o para apresenta��o e remo��o do FloatingActionButton na tela. Alto poder de customiza��o, at� mesmo o shadow � customiz�vel por completo. Contra, aparentemente o m�todo playShowAnimation() n�o tem a anima��o se movendo na mesma velocidade que quando utilizados os m�todos show() e hide(), consequentemente dificutando a visuliza��o da anima��o inicial na entrada da APP.

FloatingActionMenu (com.github.clans.fab.FloatingActionMenu): a possibilidade de anima��o (j� ligada por padr�o) e o uso de menu com outros FloatingActionButtons � a grande diferen�a em rela��o as outras libs. Contras, somente a partir da API 14 � que ele funcionar� e o m�todo setClosedOnTouchOutside() aparentemente n�o funciona apenas com a simples chamada a ele passando true como par�metro de entrada.

Mesmo com os pr�s e contras das libs, todas s�o boas e podem lhe atender em seus projetos Android. Somente tome cuidado em quando utilizar o FloatingActionButton, pois como recomendei no inicio do texto a leitura do guideline dele, h� uma s�rie de regras em quando utiliz�-lo e quando n�o. Basicamente ele deve ser a view que permitir� que a a��o principal da tela seja executada e seu posicionamento e estilo devem ser os corretos na tela de acordo com o guideline. Sem mais delongas vou deixar voc� assistir ao v�deo.

O link para download do projeto se encontra logo abaixo no post.

Os links ara os v�deos anteriores da s�rie Material Design no Android se encontram na sess�o "Relacionado" desse post (a maioria deles).

Segue links das libs e outros apresentados no v�deo:

P�gina da lib FloatingActionButton de makovkastar no GitHub

https://github.com/makovkastar/FloatingActionButton

P�gina da lib Floating Action Button Library for Android de shell-software no GitHub

https://github.com/shell-software/fab

P�gina da lib Floating Action Button de Clans no GitHub

https://github.com/Clans/FloatingActionButton

P�gina de relat�rios de uso das vers�es e estilos do Android pelo mundo

https://developer.android.com/about/dashboards/index.html

P�gina do MaterialDesignIcons

http://materialdesignicons.com/

Vlw