ButterKnife Lib, Simplificando Acesso a Views no Android


Opa, blz?

Nesse v�deo apresento a lib ButtlerKnife que simplifica o acesso as views de nossos layouts XML em nossas APPs Android por meio de annotations. Desenvolvida pelo j� conhecido Jake Wharton (se utilizou o ActionBarSherlock algum dia sabe quem � ele) a lib ButtlerKnife al�m de simplificar o acesso as Views nos permite vincular listeners as views sem a necessidade de classes an�nimas e implementa��o de Interfaces. Com os listener temos ainda mais flexibilidade, pois podemos remover o par�metro de entrada (o default � View) ou j� coloca-lo no mesmo tipo da view vinculada, Button, por exemplo. Por�m vejo como a principal vantagem na lib ButtlerKnife a padroniza��o de vincula��o entre as variaveis de instancia e as views do XML, sem necessidade de cast e de acesso a findViewById(...), como falei no v�deo, podem ter situa��es em que temos de acessar dezenas de views em uma mesma entidade (situa��es que considero comum por ter passado por isso mais de uma vez), com a lib conseguimos deixar a vincula��o e declara��o das variaveis tudo em um lugar somente e ent�o invocar o m�todo ButtlerKnife.inject(...). Como comento no v�deo tamb�m, muito provavelmente a APP perde em tempo de processamento, por�m a perda deve ser na casa de algumas dezenas de milisegundos, logo n�o sei se vale a pena quebrarmos a cabe�a com esse pequeno tempo de processamento que pode ser perdido ante ao uso da lib ButtlerKnife que melhora em muito a manutenibilidade do c�digo. Ent�o � isso, o v�deo ficou pequeno em rela��o aos �ltimos enviados, a lib a ultil, mas esquente a cabe�a com ela em momento de refatora��o de c�digo se voc� estiver com a APP em desenvolvimento.

Obs. : Desculpe o dog no background, ainda n�o podendo editar os v�deos.

O link para download do projeto se encontra logo abaixo no post.

Segue link do post sobre BaseAdapter se ainda n�o conhecer essa entidade:

Utilizando BaseAdapter Para Personaliza��o Completa da ListView

Segue links das p�ginas apresentadas no v�deo:

P�gina do Buttler Knife

http://jakewharton.github.io/butterknife/

P�gina do Buttler Knife no GitHub

https://github.com/JakeWharton/butterknife

Vlw