FloatingActionButton Com Três Diferentes Libs, Material Design Android - Parte 6




Opa, blz?

Nesse vídeo continuo com a série sobre Material Design no Android, dessa vez mostrando a utilização do FloatingActionButton utilizando no caso três diferentes libs, todas com características próprias e com seus prós e contras. Relembrando que é muito bom que você leia o meterial sobre FloatingActionButton nos guidelines do Material Design no Android. Bom, vamos aos comentários das libs utilizadas:

http://www.google.com/design/spec/components/buttons-floating-action-button.html

FloatingActionButton (com.melnykov.fab.FloatingActionButton): vantagem de ter suporte desde API 7 e a facilidade de implementação e uso. Contra, pouco customizável e apenas uma forma nativa de animação.

Action Button (com.software.shell.fab.ActionButton): vantagem de ter suporte desde API 9, escolha de animação para apresentação e remoção do FloatingActionButton na tela. Alto poder de customização, até mesmo o shadow é customizável por completo. Contra, aparentemente o método playShowAnimation() não tem a animação se movendo na mesma velocidade que quando utilizados os métodos show() e hide(), consequentemente dificutando a visulização da animação inicial na entrada da APP.

FloatingActionMenu (com.github.clans.fab.FloatingActionMenu): a possibilidade de animação (já ligada por padrão) e o uso de menu com outros FloatingActionButtons é a grande diferença em relação as outras libs. Contras, somente a partir da API 14 é que ele funcionará e o método setClosedOnTouchOutside() aparentemente não funciona apenas com a simples chamada a ele passando true como parâmetro de entrada.

Mesmo com os prós e contras das libs, todas são boas e podem lhe atender em seus projetos Android. Somente tome cuidado em quando utilizar o FloatingActionButton, pois como recomendei no inicio do texto a leitura do guideline dele, há uma série de regras em quando utilizá-lo e quando não. Basicamente ele deve ser a view que permitirá que a ação principal da tela seja executada e seu posicionamento e estilo devem ser os corretos na tela de acordo com o guideline. Sem mais delongas vou deixar você assistir ao vídeo.

O link para download do projeto se encontra logo abaixo no post.

Os links ara os vídeos anteriores da série Material Design no Android se encontram na sessão "Relacionado" desse post (a maioria deles).

Segue links das libs e outros apresentados no vídeo:

Página da lib FloatingActionButton de makovkastar no GitHub

https://github.com/makovkastar/FloatingActionButton

Página da lib Floating Action Button Library for Android de shell-software no GitHub

https://github.com/shell-software/fab

Página da lib Floating Action Button de Clans no GitHub

https://github.com/Clans/FloatingActionButton

Página de relatórios de uso das versões e estilos do Android pelo mundo

https://developer.android.com/about/dashboards/index.html

Página do MaterialDesignIcons

http://materialdesignicons.com/

Vlw